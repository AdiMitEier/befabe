package controllers;



import java.util.ArrayList;

import play.Logger;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.persistence.EntityManager;

import at.ac.tuwien.big.we14.lab2.api.Answer;
import at.ac.tuwien.big.we14.lab2.api.Choice;
import at.ac.tuwien.big.we14.lab2.api.Question;
import at.ac.tuwien.big.we14.lab2.api.QuizFactory;
import at.ac.tuwien.big.we14.lab2.api.QuizGame;
import at.ac.tuwien.big.we14.lab2.api.User;
import at.ac.tuwien.big.we14.lab2.api.impl.PlayQuizFactory;
import models.SelectedOptions;
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

@Security.Authenticated(Secured.class)
public class Quiz extends Controller {
	
	private static QuizGame game;
	private static int questionCounter;
	
    
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
		
		//evaluate Answers from previous asked question
		if(game!=null && questionCounter!=0){
			SelectedOptions selectedOptions = Form.form(SelectedOptions.class).bindFromRequest().get();
			Map<String, String[]> map = request().body().asFormUrlEncoded();
			String[] checkedVal=map.get("choice");
			selectedOptions.choice=Arrays.asList(checkedVal);
			for(String s:selectedOptions.choice){
				Logger.info(s);
			}
		}

		if(game==null){
        	QuizFactory factory = new PlayQuizFactory(Play.application().configuration().getString("questions.de"),user);
    		game=factory.createQuizGame();
    		game.startNewRound();
    		questionCounter=0;
    	}
    	if(questionCounter>2){ 		
    		if(game.getCurrentRoundCount()==5){
        		//game.
    			questionCounter=0;
        		game=null;//TODO achtung hier erst Daten rausziehen und dann an quizover.render() als Argument uebergeben
        		return ok(quizover.render());
        	}
    		game.startNewRound();
    		questionCounter=0;
    		return ok(roundover.render());
    	}
    	
    	List<Question> questions = game.getCurrentRound().getQuestions();
    	Random randomGenerator = new Random();  	
    	int questionid = randomGenerator.nextInt(questions.size());
    	Quiz.session().put("questionid", String.valueOf(questionid));
    	Question question = game.getCurrentRound().getQuestions().get(questionid);
    	
    	List<Choice> choices = question.getAllChoices();
    	question.getAllChoices().get(1).getQuestion();
    	//game.getCurrentRound().getAnswer(1,user).
    	questionCounter++;
    	return ok(quiz.render(choices));
    }
    
    

    
    
}