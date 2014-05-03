package controllers;



import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import at.ac.tuwien.big.we14.lab2.api.Choice;
import at.ac.tuwien.big.we14.lab2.api.Question;
import at.ac.tuwien.big.we14.lab2.api.QuizFactory;
import at.ac.tuwien.big.we14.lab2.api.QuizGame;
import at.ac.tuwien.big.we14.lab2.api.User;
import at.ac.tuwien.big.we14.lab2.api.impl.PlayQuizFactory;
import models.SimpleUser;
import play.*;
import play.api.mvc.Session;
import play.data.DynamicForm;
import play.data.Form;
import play.db.jpa.JPA;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.*;
import views.html.*;

public class Quiz extends Controller {
	
	private static QuizGame game;
    
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
    
    public static Result index() {
    	return ok(index.render());
    }
    
    public static Result login() {
    	// do login
    	boolean authenticated = true;
    	
    	//TODO begin:User dynamisch aus Anmeldeinformation bekommen
    	User user=new SimpleUser();
    	user.setName("Hans");
    	Quiz.session().put("user", user.getName());
    	//TODO ende
    	if(authenticated) {
    		return ok(index.render());
    	} else {
    		return redirect(
                    routes.Authentication.login()
                );	// badRequest?
    	}	
    }

    public static Result quiz() {
    	User user=new at.ac.tuwien.big.we14.lab2.api.impl.SimpleUser();
		user.setName(Quiz.session().get("user"));
		
    	if(game==null){
        	QuizFactory factory = new PlayQuizFactory(Play.application().configuration().getString("questions.de"),user);
    		game=factory.createQuizGame();
    		game.startNewRound();
    	}
    	
    	Question question = game.getCurrentRound().getCurrentQuestion(user);	   	
    	List<Choice> choices = question.getAllChoices();
    	return ok(quiz.render(choices));
    }

    
    
}