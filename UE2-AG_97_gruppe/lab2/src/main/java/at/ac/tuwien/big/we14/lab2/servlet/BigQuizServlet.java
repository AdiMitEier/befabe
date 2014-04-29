package at.ac.tuwien.big.we14.lab2.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import at.ac.tuwien.big.we14.lab2.api.Category;
import at.ac.tuwien.big.we14.lab2.api.Choice;
import at.ac.tuwien.big.we14.lab2.api.Player;
import at.ac.tuwien.big.we14.lab2.api.Question;
import at.ac.tuwien.big.we14.lab2.api.QuestionDataProvider;
import at.ac.tuwien.big.we14.lab2.api.QuizFactory;
import at.ac.tuwien.big.we14.lab2.api.impl.JSONQuestionDataProvider;
import at.ac.tuwien.big.we14.lab2.api.impl.RoundState;
import at.ac.tuwien.big.we14.lab2.api.impl.ServletQuizFactory;
import at.ac.tuwien.big.we14.lab2.api.impl.SimpleChoice;
import at.ac.tuwien.big.we14.lab2.api.impl.SimplePlayer;
import at.ac.tuwien.big.we14.lab2.api.impl.SimpleQuizFactory;

@WebServlet(name="BigQuiz", urlPatterns = {"/BigQuizServlet"})
public class BigQuizServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private QuizFactory quizfactory;
	private QuestionDataProvider questiondataprovider;
	private List<Category> categories;
	private int roundCounter;
	private int questionCounter;
	private Category currentCategory;
	private int i;
	private Player player1;
	private Player player2;

	private List<Integer> askedQuestions;

	int numberOfquestions;
	Question question;
	Question lastQuestion;


	public void init() throws ServletException{
		super.init();
		quizfactory = new ServletQuizFactory(this.getServletContext());
		questiondataprovider = quizfactory.createQuestionDataProvider();
		categories = questiondataprovider.loadCategoryData();
		currentCategory = categories.get(i);

		//generiere frage der selben kategorie
		numberOfquestions = currentCategory.getQuestions().size();
		question = currentCategory.getQuestions().get((int) (Math.random()*numberOfquestions));
		lastQuestion = question;
		askedQuestions = new ArrayList<Integer>();
		askedQuestions.add(question.getId());
		questionCounter=0;
		roundCounter=0;
		i=0;
		player1 = new SimplePlayer("Ich");
		player2 = new SimplePlayer("Computer");
		player1.setWonRounds(0);
		player2.setWonRounds(0);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{	
		HttpSession session = request.getSession(true);
		RequestDispatcher dispatcher;



		System.out.println("Runde: " + roundCounter + " Frage: " + question.getId() + " " + question.getText());


		dispatcher = getServletContext().getRequestDispatcher("/question.jsp");

		//am start eines neuen spiels alles zurueck setzten
		if(roundCounter == 0 && questionCounter == 0){
			i = 0;
			player1.resetRightQuestions();
			player2.resetRightQuestions();
			player1.setWonRounds(0);
			player2.setWonRounds(0);
		}
		if(roundCounter <= 4){ //5 runden werden gespielt
			//System.out.println("ROUND: " + roundCounter);
			if(questionCounter <=3){ //jede runde werden 3 fragen gestellt
				if(questionCounter == 0){
					player1.resetRightQuestions();
					player2.resetRightQuestions();
				}

				//System.out.println("ENTER new Question: " +  questionCounter);	
				//question und currentCategory an das session atrribut geben
				session.setAttribute("question",question);
				session.setAttribute("category",currentCategory);
				session.setAttribute("player1", player1);
				session.setAttribute("player2", player2);


				if(questionCounter > 0){ // werte antwort der letzten frage aus
					if(!verifyAnswers(request, questionCounter)){ //wenn fragerunde unentschieden, fragerunde wiederholen
						questionCounter--;
					}					
				}

				questionCounter ++;

				//generiere frage der selben kategorie
				numberOfquestions = currentCategory.getQuestions().size();
				int q = (int) (Math.random()*numberOfquestions);
				question = currentCategory.getQuestions().get(q);

				if(questionCounter == 0) lastQuestion = question;

				if(!askedQuestions.isEmpty()){ //wurde frage bereits gestellt?
					if(askedQuestions.contains(question.getId())){
						question = currentCategory.getQuestions().get(i%currentCategory.getQuestions().size());
					}
//					int reroll = 0;
//					while(askedQuestions.contains(question.getId()) && reroll < currentCategory.getQuestions().size()){ // suche neue frage, solang noch nicht gefragte da sind
//						question = currentCategory.getQuestions().get(i%currentCategory.getQuestions().size());
//						reroll++;
//						System.out.println("Reroll question generation");
//					}
				}

				askedQuestions.add(question.getId());


				if(questionCounter <=3){
					//System.out.println("questionCounter <= 3 -> neue frage " +questionCounter);
					dispatcher = getServletContext().getRequestDispatcher("/question.jsp");
				}else{
					//System.out.println("questionCounter > 3 -> round complete");
					roundCounter ++;
					questionCounter = 0;

					System.out.println("player 1 gewonnen: " + player1.getRightQuestions());
					System.out.println("player 2 gewonnen: " + player2.getRightQuestions());
					if(player1.getRightQuestions()>player2.getRightQuestions()){
						//wenn Spieler 1 mehr richtige Antworten hat
						player1.setWonRounds(player1.getWonRounds()+1);
					} else {
						if(player1.getRightQuestions()==player2.getRightQuestions()){
							//wenn Spieler 1 und Spieler 2 gleich viele Antworten haben
							player1.setWonRounds(player1.getWonRounds()+1);
							player2.setWonRounds(player2.getWonRounds()+1);
						} else {
							//wenn Spieler 2 mehr richtige Antworten hat
							player2.setWonRounds(player2.getWonRounds()+1);
						}
					}

					i++;
					currentCategory = categories.get(i%categories.size());
					dispatcher = getServletContext().getRequestDispatcher("/roundcomplete.jsp");
					lastQuestion = question;
				}

			}else{
				//System.out.println("neue runde -> stats zur�ck setzten");


				roundCounter ++;
				questionCounter = 0;
				player1.resetRightQuestions();
				player2.resetRightQuestions();
				askedQuestions.clear();

				i++;
				currentCategory = categories.get(i);
				//System.out.println("Naechste Runde hat Kategorie:" +currentCategory.getName());
			}
		}else{
			roundCounter = 0;
			questionCounter = 0;

			dispatcher = getServletContext().getRequestDispatcher("/finish.jsp");

		}


		//		dispatcher = getServletContext().getRequestDispatcher("/start.jsp");
		dispatcher.forward(request, response);

	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response){

	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response){

	}

	private boolean verifyAnswers(HttpServletRequest request, int round){

		//System.out.println("current question: " + question.getId());
		//System.out.println("last question: " + lastQuestion.getId());
		//auswerten der runde: 
		List<Choice> correctAnswers = lastQuestion.getCorrectChoices();
		//for(Choice c : correctAnswers){
		//	System.out.println(c.toString());
		//}

		//Computer antworten generieren

		List<SimpleChoice> aiAnswers = new ArrayList<SimpleChoice>(); 

		for(Choice choice : lastQuestion.getAllChoices()){
			//ist die antwort eine korrekte antwort, chance von 70% die antwort zu waehlen, sonst 50%
			if(correctAnswers.contains(choice)){

				if(Math.random() > 0.1){
					aiAnswers.add((SimpleChoice) choice);
				}
			}else if(Math.random() >0.8){
				aiAnswers.add((SimpleChoice) choice);
			}
		}

		//wenn die anzahlt der gewaehlten antworten != anzahl der korrekten anzahl -> frage falsch
		int answers = 0;
		if(correctAnswers.size() == aiAnswers.size()){
			//System.out.println("Computer antworten: ");
			//sind gewaehlten antworten selben wie korrekten antworten?
			for(Choice choice: aiAnswers){
				//System.out.println(choice.toString());
				if(correctAnswers.contains(choice)){
					answers ++;
				}
			}
		}

		//sind alle gewaehlten antworten korrekt, runde richtig bewerten, sonst falsch
		if(answers == correctAnswers.size()){
			//System.out.println("answer correct");
			((SimplePlayer) player2).setState(round, RoundState.CORRECT);	
			//player2.incrementRightQuestions();
		}else{
			//System.out.println("answer incorrect");
			((SimplePlayer) player2).setState(round, RoundState.INCORRECT);			
		}




		//ueberpruefe ob player antwort richtig ist
		if(request.getParameter("answers") !=null){
			//System.out.println("Spieler antworten: ");
			String[] answerIds = request.getParameterValues("answers");
			int correct = 0;
			int id;

			if(answerIds.length == correctAnswers.size()){
				for(int i = 0; i<answerIds.length; i++){ //ueberpruefe ob die gewaehlte antwort in den korrekten enthalten ist
					id = Integer.parseInt(answerIds[i].substring(0, answerIds[i].length()-1));
					for(int j = 0; j < correctAnswers.size(); j++){
						if(correctAnswers.get(j).getId() == id){
							correct++; //richtige anwort gewaehlt -> erhoehe counter
						}
					}

				}
				if(correct==correctAnswers.size()){ //wurde keine falsche antwort gewaehlt -> frage richtig
					((SimplePlayer) player1).setState(round, RoundState.CORRECT);	
					//player1.incrementRightQuestions();

				}else{
					((SimplePlayer) player1).setState(round, RoundState.INCORRECT);			
				}
			}else{
				((SimplePlayer) player1).setState(round, RoundState.INCORRECT);		//sind anzahl gewaehlter antworten != anzahl korrekter antworten -> frage falsch					
			}

		}else{
			((SimplePlayer) player1).setState(round, RoundState.INCORRECT);			
		}



		System.out.println(((SimplePlayer) player1).getWonRounds());
		System.out.println(((SimplePlayer) player2).getWonRounds());
		lastQuestion = question;
		boolean tie = ((SimplePlayer)player1).getState(round) == ((SimplePlayer)player2).getState(round); 
		if(tie){//ist die Runde unentschieden ausgegangen? 
			//runde wiederholen -> questionCounter decrementieren
			int computerTime = (int) (Math.random()*30);
			int playerTime = 30 - Integer.parseInt(request.getParameter("timeleftvalue"));
			System.out.println("player: " + playerTime + " Computer: " + computerTime);
			if( playerTime < computerTime){//wenn antwortzeit des spielers geringer ist, gewinnt dieser
				player1.incrementRightQuestions();
				/*if(((SimplePlayer)player2).getState(round) == RoundState.CORRECT){
					player2.decrementRightQuestions();
				}
				((SimplePlayer) player1).setState(round, RoundState.CORRECT);
				*/
				System.out.println("player gewinnt runde");
				return true;
			}
			if(playerTime > computerTime){
				System.out.println("computer gewinnt runde");
				player2.incrementRightQuestions();
				/*((SimplePlayer) player2).setState(round, RoundState.CORRECT);
				if(((SimplePlayer)player1).getState(round) == RoundState.CORRECT){
					player1.decrementRightQuestions();
				}
				*/
				return true;
			}
			return false; //zeit unentschieden

		}else{
			if(((SimplePlayer)player1).getState(round)== RoundState.CORRECT){
				player1.incrementRightQuestions();
			}else{
				player2.incrementRightQuestions();
			}
			return true; // nicht unentschieden
		}

	}
}

// Your Servlet implementation