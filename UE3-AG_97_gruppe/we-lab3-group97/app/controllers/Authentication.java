package controllers;

import java.util.List;

import javax.persistence.Query;

import models.SimpleUser;
import play.data.Form;
import play.db.jpa.JPA;
import play.db.jpa.Transactional;
import play.mvc.Result;
import play.mvc.Controller;
import views.html.*;

public class Authentication extends Controller{
	
public static class Login {
        
        public String username;
        public String password;
        
        public String validate() {
            if(SimpleUser.authenticateUser(username, password) == null) {
                return "Invalid user or password";
            }
            return null;
        }
        
    	
        
    }

	/**
	 * Login page.
	 */
	public static Result login() {
		return ok(
	        login.render(Form.form(Login.class))
	    );
	}
	
    /**
     * Handle login form submission.
     */
	@Transactional
    public static Result authenticate() {
        Form<Login> loginForm = Form.form(Login.class).bindFromRequest();
        if(loginForm.hasErrors()) {
            return badRequest(login.render(loginForm));
        } else {
            session("userName", loginForm.get().username);
            return redirect(
                routes.Quiz.index()
            );
        }
    }

    /**
     * Logout and clean the session.
     */
    public static Result logout() {
        session().clear();
        flash("success", "You've been logged out");
        return redirect(
            routes.Authentication.login()
        );
    }
  
	
    

}
