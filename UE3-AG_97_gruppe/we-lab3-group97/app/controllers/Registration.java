package controllers;

import models.SimpleUser;
import play.data.Form;
import play.db.jpa.JPA;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.registration;

public class Registration extends Controller{

    public static Result registration() {
    	return ok(registration.render());
    }
    
    @Transactional
    public static Result register() {
    	SimpleUser user = Form.form(SimpleUser.class).bindFromRequest().get();
    	
    	JPA.em().persist(user);	
    	return redirect(
                routes.Authentication.login()
            );
    	
    }
	
}
