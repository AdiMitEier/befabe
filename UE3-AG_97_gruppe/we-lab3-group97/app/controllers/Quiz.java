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
	
	public static QuizGame game;
	private static int questionCounter;
	private static int questionId;
	private static List<String> correctQuestionsPlayer; 
	private static List<Integer> timesQuestionsPlayer = new ArrayList<Integer>();
	private static List<String> correctQuestionsComp;
	private static int pWonRounds;
	private static int cWonRounds;
	
    
    public static Result index() {
    	game=null;
    	return ok(index.render());
    }
    /*
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
    }*/
    
    /*
    public static Result quiz(){
    	User user = new at.ac.tuwien.big.we14.lab2.api.impl.SimpleUser();
    	user.setName(Quiz.session().get("user"));
    	QuizFactory factory = new PlayQuizFactory(Play.application().configuration().getString("questions.de"),user);
    	   	
		if(game==null){	  
			game=factory.createQuizGame();
			game.startNewRound();
		}
		
		if(game!=null){
			if(game.isRoundOver()){
				Logger.info("Render Roundover");
				game.startNewRound();
				return ok(roundover.render());
			} else {
				List<Integer> selectedChoiceIds = new ArrayList<Integer>();
				List<Choice> selectedChoices = new ArrayList<Choice>();
				
				SelectedOptions selectedOptions = Form.form(SelectedOptions.class).bindFromRequest().get();
				Map<String,String[]> map = request().body().asFormUrlEncoded();
				String[] checkedVal=map.get("choice");
				
				if(checkedVal!=null){
					selectedOptions.choice=Arrays.asList(checkedVal);			
					for(String c: selectedOptions.choice){
						selectedChoiceIds.add(Integer.parseInt(c));
					}
					for(Choice q: game.getCurrentRound().getCurrentQuestion(user).getAllChoices()){
						if(selectedChoiceIds.contains(q.getId()))
							selectedChoices.add(q);
					}						
				}
				game.getCurrentRound().answerCurrentQuestion(selectedChoices, 10, user, factory);
			}
		}
		if(game.getCurrentRound().getCurrentQuestion(user)==null){
			Logger.info("game round question is null"); //WTF?
		}
		List<Choice> choices = game.getCurrentRound().getCurrentQuestion(user).getAllChoices();			
		return ok(quiz.render(choices));
    }*/
    
    
    
    public static Result quiz() {
    	User user=new at.ac.tuwien.big.we14.lab2.api.impl.SimpleUser();
		user.setName(Quiz.session().get("userName"));
		List<Choice> selectedChoices = new ArrayList<Choice>();
		List<Integer> selectedChoicesId = new ArrayList<Integer>();
		boolean prevCorrect=true;
		boolean compCorrect=true;
		
		
		//evaluate Answers from previous asked question
		if(game!=null && questionCounter!=0){
			SelectedOptions selectedOptions = Form.form(SelectedOptions.class).bindFromRequest().get();
			Map<String, String[]> map = request().body().asFormUrlEncoded();
			String[] checkedVal=map.get("choice");
			if(checkedVal!=null){
				selectedOptions.choice=Arrays.asList(checkedVal);
				for(String s:selectedOptions.choice){
					selectedChoicesId.add(Integer.parseInt(s));
				}
				for(Choice c:game.getCurrentRound().getQuestion(questionId).getAllChoices()){
					if(selectedChoicesId.contains(c.getId())){
						selectedChoices.add(c);
					}
				}
			}
			for(Choice c:game.getCurrentRound().getQuestion(questionId).getCorrectChoices()){
				if(!selectedChoices.contains(c))
					prevCorrect=false;
			}
			if(prevCorrect){
				correctQuestionsPlayer.set(questionCounter-1, "correct");
			} else {
				correctQuestionsPlayer.set(questionCounter-1, "incorrect");
			}
			double compCorrectCheck = Math.random();
			if(compCorrectCheck>0.6){
				correctQuestionsComp.set(questionCounter-1, "incorrect");
			} else {
				correctQuestionsComp.set(questionCounter-1, "correct");
			}
			timesQuestionsPlayer.add(Integer.parseInt(selectedOptions.timeleftvalue));
			Logger.info(String.valueOf(prevCorrect)+" and answered with "+selectedOptions.timeleftvalue+" seconds left.");			
		}

		if(game==null){
			//if game is new
        	QuizFactory factory = new PlayQuizFactory(Play.application().configuration().getString("questions.de"),user);
    		game=factory.createQuizGame();
    		game.getPlayers().get(1).setName("Computer");//hier wird Computer als Name für den zweiten Gegneer gesetzt
    		correctQuestionsPlayer=new ArrayList<String>();
    		correctQuestionsComp=new ArrayList<String>();
    		setUnknown(correctQuestionsComp);
    		setUnknown(correctQuestionsPlayer);
    		pWonRounds=0;
    		cWonRounds=0;
    		game.startNewRound();
    		questionCounter=0;
    	}
    	if(questionCounter>2){ 
    		//if round is over
    		if(game.getCurrentRoundCount()==5){
    			//check if game is over
    			String winner = checkWhoWon(correctQuestionsPlayer,correctQuestionsComp);
        		correctQuestionsPlayer=new ArrayList<String>();
        		correctQuestionsComp=new ArrayList<String>();
        		timesQuestionsPlayer.clear();
        		setUnknown(correctQuestionsComp);
        		setUnknown(correctQuestionsPlayer);
    			questionCounter=0;
    			int wonA=pWonRounds;
    			int wonB=cWonRounds;
    			pWonRounds=0;
    			cWonRounds=0;
    			String playerA = game.getPlayers().get(0).getName();
    			String playerB = game.getPlayers().get(1).getName();
        		game=null;//TODO achtung hier erst Daten rausziehen und dann an quizover.render() als Argument uebergeben
        		return ok(quizover.render(String.valueOf(wonA), String.valueOf(wonB),winner,playerA,playerB));
        	}
    		List<String> resultForRoundOver=correctQuestionsPlayer;
    		List<String> resultForRoundOverComp=correctQuestionsComp;
    		correctQuestionsPlayer=new ArrayList<String>();
    		correctQuestionsComp=new ArrayList<String>();
    		timesQuestionsPlayer.clear();
    		setUnknown(correctQuestionsComp);
    		setUnknown(correctQuestionsPlayer);
 		  	
    		String winner = checkWhoWon(resultForRoundOver,resultForRoundOverComp);
    		game.startNewRound();
    		questionCounter=0;
    		return ok(roundover.render(String.valueOf(pWonRounds),String.valueOf(cWonRounds),winner,String.valueOf(game.getCurrentRoundCount()-1),resultForRoundOver,resultForRoundOverComp,game.getPlayers().get(0).getName(),game.getPlayers().get(1).getName()));
    	}
    	
    	List<Question> questions = game.getCurrentRound().getQuestions();
    	Random randomGenerator = new Random();  	
    	questionId = randomGenerator.nextInt(questions.size());
    	Quiz.session().put("questionid", String.valueOf(questionId));
    	Question question = game.getCurrentRound().getQuestions().get(questionId);
    	
    	List<Choice> choices = question.getAllChoices();
    	question.getAllChoices().get(1).getQuestion();
    	//game.getCurrentRound().getAnswer(1,user).
    	questionCounter++;
    	return ok(quiz.render(choices,correctQuestionsPlayer,correctQuestionsComp,game.getPlayers().get(0).getName(),game.getPlayers().get(1).getName()));
    }
    
    private static void setUnknown(List<String> listToSet){
    	listToSet.add("unknown");
    	listToSet.add("unknown");
    	listToSet.add("unknown");
    }
    
    private static String checkWhoWon(List<String> answersA,List<String> answersB){
    	boolean equal=true; //prueft ob alle gegebenen Antworten die gleichen waren
		for(int i=0;i<answersA.size();i++){
			if(!answersA.get(i).equals(answersB.get(i))){
				equal = false;
			}
		}
		
		String winner = "checkWhoWon failed";
		
		if(equal){
			//evaluate Winner if Answers are equal - we get the time from the view, but without api its more or less irrelevant if you figth against computer
			double rnd = Math.random();
			if(rnd<=0.5){
				winner=game.getPlayers().get(0).getName();
				pWonRounds=pWonRounds+1;
			} else {
				winner=game.getPlayers().get(1).getName();
				cWonRounds=cWonRounds+1;
			}
		} else {
			int rightQuestionsP=0;
			int rightQuestionsC=0;
			for(int i=0;i<answersA.size();i++){
				if(answersA.get(i).equals("correct")){
					rightQuestionsP++;
				}
				if(answersB.get(i).equals("correct")){
					rightQuestionsC++;
				}
			}
			if(rightQuestionsP>rightQuestionsC){
				//spieler hat gewonnen
				winner=game.getPlayers().get(0).getName();
				pWonRounds=pWonRounds+1;
			} else {
				if(rightQuestionsC>rightQuestionsP){
					winner=game.getPlayers().get(1).getName();//computer hat gewonnen
					cWonRounds=cWonRounds+1;
				}	
				if(rightQuestionsP==rightQuestionsC){
					//wenn heir auch beide gleich viele Punkte haben bei den questions
					double rnd = Math.random();
	    			if(rnd<=0.5){
	    				winner=game.getPlayers().get(0).getName();
	    				pWonRounds=pWonRounds+1;
	    			} else {
	    				winner=game.getPlayers().get(1).getName();
	    				cWonRounds=cWonRounds+1;
	    			}
				}
			}
		}
		return winner;
    }
    

    
    
}