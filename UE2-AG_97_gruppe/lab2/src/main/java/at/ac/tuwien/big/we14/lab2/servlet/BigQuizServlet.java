package at.ac.tuwien.big.we14.lab2.servlet;

import java.io.IOException;
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
import at.ac.tuwien.big.we14.lab2.api.Player;
import at.ac.tuwien.big.we14.lab2.api.Question;
import at.ac.tuwien.big.we14.lab2.api.QuestionDataProvider;
import at.ac.tuwien.big.we14.lab2.api.QuizFactory;
import at.ac.tuwien.big.we14.lab2.api.impl.JSONQuestionDataProvider;
import at.ac.tuwien.big.we14.lab2.api.impl.ServletQuizFactory;
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
	private Player player1;
	private Player player2;
	
	public void init() throws ServletException{
		super.init();
		quizfactory = new ServletQuizFactory(this.getServletContext());
		questiondataprovider = quizfactory.createQuestionDataProvider();
		categories = questiondataprovider.loadCategoryData();
		questionCounter=-1;
		roundCounter=0;
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
		if(questionCounter==0 || questionCounter==-1){
			//abhaengig von der Anzahl der geladenen Kategorien eine zufaellig auswaehlen
			currentCategory = categories.get((int)(Math.random()*categories.size()));
		}	
		if(questionCounter<2){
			//solange man weniger als 3 Fragen beantwortet hat wird immer eine Frage aus derselben Kategorie gestellt
			//abhaengig von der Kategorie ein der Fragen zufaellig auswaehlen
			int numberOfquestions = currentCategory.getQuestions().size();
			Question question = currentCategory.getQuestions().get((int) (Math.random()*numberOfquestions));
			//question und currentCategory an das session atrribut geben
			session.setAttribute("question",question);
			session.setAttribute("category",currentCategory);
			session.setAttribute("player1",player1);
			session.setAttribute("player2", player2);
			//und weitere Verarbeitung an das jsp
			dispatcher = getServletContext().getRequestDispatcher("/question.jsp");
			questionCounter++;
		}else{
			//nach der dritten Frage wird die Runde beendet, dh die kategorie gewechselt und der Rundencounter um 1 erhoeht
			if(roundCounter<4){
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
				dispatcher = getServletContext().getRequestDispatcher("/roundcomplete.jsp");
				player1.resetRightQuestions();
				player2.resetRightQuestions();
				questionCounter=0;
				roundCounter++;
			} else {
				//nach der 5ten Runde hat man das Spiel beendet und kann im finish.jsp ein neues Spiel waehlen
				dispatcher = getServletContext().getRequestDispatcher("/finish.jsp");
				roundCounter=0;
				questionCounter=0;
				player1.setWonRounds(0);
				player2.setWonRounds(0);
				player1.resetRightQuestions();
				player2.resetRightQuestions();
			}
		}
		dispatcher.forward(request, response);
	}
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response){
		
	}
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response){
		
	}
	
}

// Your Servlet implementation