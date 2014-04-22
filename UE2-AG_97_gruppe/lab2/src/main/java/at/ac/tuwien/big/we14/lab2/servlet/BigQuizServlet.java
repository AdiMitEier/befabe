package at.ac.tuwien.big.we14.lab2.servlet;

import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import at.ac.tuwien.big.we14.lab2.api.Category;
import at.ac.tuwien.big.we14.lab2.api.QuestionDataProvider;
import at.ac.tuwien.big.we14.lab2.api.QuizFactory;
import at.ac.tuwien.big.we14.lab2.api.impl.JSONQuestionDataProvider;
import at.ac.tuwien.big.we14.lab2.api.impl.ServletQuizFactory;
import at.ac.tuwien.big.we14.lab2.api.impl.SimpleQuizFactory;

@WebServlet(name="BigQuiz", urlPatterns = {"/BigQuizServlet"})
public class BigQuizServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private QuizFactory quizfactory = new ServletQuizFactory(this.getServletContext());
	private QuestionDataProvider questiondataprovider = quizfactory.createQuestionDataProvider();
	private List<Category> categories = questiondataprovider.loadCategoryData();
	
	public void init(){
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response){
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response){
		
	}
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response){
		
	}
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response){
		
	}
	
}

// Your Servlet implementation