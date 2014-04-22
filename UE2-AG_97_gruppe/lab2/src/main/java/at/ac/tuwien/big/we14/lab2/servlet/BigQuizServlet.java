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
import at.ac.tuwien.big.we14.lab2.api.impl.SimpleQuizFactory;

@WebServlet(name="BigQuiz", urlPatterns = {"/BigQuizServlet"})
public class BigQuizServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private QuizFactory quizfactory;
	private QuestionDataProvider questiondataprovider;
	private List<Category> categories;
	private Player player1;
	private Player player2;
	
	public void init() throws ServletException{
		super.init();
		quizfactory = new ServletQuizFactory(this.getServletContext());
		questiondataprovider = quizfactory.createQuestionDataProvider();
		categories = questiondataprovider.loadCategoryData();

	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response){
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{	
		//if(request.getParameter("questionform").equals("next")){
			HttpSession session = request.getSession(true);
			//abhaengig von der Anzahl der geladenen Kategorien eine zufaellig auswaehlen
			Category category = categories.get((int)(Math.random()*categories.size()-1));
			Question question = category.getQuestions().get((int)Math.random()*category.getQuestions().size());
			question.setText("Hallo");
			session.setAttribute("question",question);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/question.jsp");
			dispatcher.forward(request, response);
		//}
	}
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response){
		
	}
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response){
		
	}
	
}

// Your Servlet implementation