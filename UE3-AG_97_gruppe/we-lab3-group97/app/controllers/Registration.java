package controllers;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

import models.SimpleUser;
import play.data.Form;
import play.data.validation.ValidationError;
import play.db.jpa.JPA;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.registration;
import play.i18n.*;

public class Registration extends Controller{

    public static Result registration() {
    	Form<SimpleUser> registrationForm = new Form<SimpleUser>(SimpleUser.class);
    	return ok(registration.render(registrationForm));
    }
    
    @Transactional
    public static Result register() {
    	Form<SimpleUser> registrationForm = Form.form(SimpleUser.class).bindFromRequest();
    	if(registrationForm.hasErrors()) {
    		return badRequest(views.html.registration.render(registrationForm));
    	}
    	SimpleUser user = Form.form(SimpleUser.class).bindFromRequest().get();
    	if(user.getBirthdate() != null) {
    		Date now = new Date();
    		if(user.getBirthdate().after(now)) {
    			registrationForm.reject(Messages.get("register.birthdateIsInFuture"));
    			return badRequest(views.html.registration.render(registrationForm));
    		}
    	}
    	EntityManager entityManager = JPA.em();
    	
    	Query query = entityManager.createQuery("SELECT u FROM SimpleUser u WHERE u.username = :username");
    	query.setParameter("username", user.getUsername());
    	query.setMaxResults(1);
    	if(query.getResultList().size() > 0) {
    		registrationForm.reject(Messages.get("register.errUserExists"));
    		return badRequest(views.html.registration.render(registrationForm));
    	}
    	
    	entityManager.persist(user);	
    	return redirect(
                routes.Authentication.login()
            );
    	
    }
	
}
