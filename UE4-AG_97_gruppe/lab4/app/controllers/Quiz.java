package controllers;

import models.*;
import models.QuizUser.Gender;
import play.Logger;
import play.Play;
import play.api.Application;
import play.api.cache.Cache;
import play.data.DynamicForm;
import play.data.Form;
import play.db.jpa.Transactional;
import play.i18n.Messages;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import scala.Option;
import views.html.quiz.index;
import views.html.quiz.quiz;
import views.html.quiz.quizover;
import views.html.quiz.roundover;
import highscore.Failure;
import highscore.PublishHighScoreEndpoint;
import highscore.PublishHighScoreService;
import highscore.data.HighScoreRequestType;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.ws.Service;


@Security.Authenticated(Secured.class)
public class Quiz extends Controller {

	public static Result index() {
		return ok(index.render());
	}

	@play.db.jpa.Transactional(readOnly = true)
	public static Result newGame() {
		createNewGame();
		return redirect(routes.Quiz.question());
	}

	@play.db.jpa.Transactional(readOnly = true)
	private static QuizGame createNewGame() {
		List<Category> allCategories = QuizDAO.INSTANCE.findEntities(Category.class);
		Logger.info("Start game with " + allCategories.size() + " categories.");
		QuizGame game = new QuizGame(allCategories);
		game.startNewRound();
		cacheGame(game);
		return game;
	}

	private static String dataFilePath() {
		return Play.application().configuration().getString("questions.filePath");
	}

	private static QuizUser user() {
		String userId = Secured.getAuthentication(session());
		return QuizDAO.INSTANCE.findById(Long.valueOf(userId));
	}

	@play.db.jpa.Transactional(readOnly = true)
	public static Result question() {
		QuizGame game = cachedGame();
		if (currentQuestion(game) != null) {
			return ok(quiz.render(game));
		} else {
			return badRequest(Messages.get("quiz.no-current-question"));
		}
	}

	@Transactional(readOnly = true)
	private static Question currentQuestion(QuizGame game) {
		if (game != null && game.getCurrentRound() != null) {
			QuizUser user = game.getPlayers().get(0);
			return game.getCurrentRound().getCurrentQuestion(user);
		} else {
			return null;
		}
	}

	@play.db.jpa.Transactional(readOnly = true)
	public static Result addAnswer() {
		QuizGame game = cachedGame();
		Question question = currentQuestion(game);
		if (question != null) {
			processAnswerIfSent(game);
			return redirectAccordingToGameState(game);
		} else {
			return badRequest(Messages.get("quiz.no-current-question"));
		}
	}

	@Transactional
	private static void processAnswerIfSent(QuizGame game) {
		DynamicForm form = Form.form().bindFromRequest();
		QuizUser user = game.getPlayers().get(0);
		Question question = game.getCurrentRound().getCurrentQuestion(user);
		int sentQuestionId = Integer.valueOf(form.data().get("questionid"));
		if (question.getId() == sentQuestionId) {
			List<Choice> choices = obtainSelectedChoices(form, question);
			long time = Long.valueOf(form.get("timeleft"));
			game.answerCurrentQuestion(user, choices, time);
		}
	}

	@Transactional
	private static List<Choice> obtainSelectedChoices(DynamicForm form,
			Question question) {
		Map<String, String> formData = form.data();
		List<Choice> choices = new ArrayList<Choice>();
		int i = 0;
		String chosenId = null;
		while ((chosenId = formData.get("choices[" + i + "]")) != null) {
			Choice choice = getChoiceById(Integer.valueOf(chosenId), question);
			if (choice != null) {
				choices.add(choice);
			}
			i++;
		}
		return choices;
	}

	private static Choice getChoiceById(int id, Question question) {
		for (Choice choice : question.getChoices())
			if (id == choice.getId())
				return choice;
		return null;
	}

	private static Result redirectAccordingToGameState(QuizGame game) {
		if (isRoundOver(game)) {
			return redirect(routes.Quiz.roundResult());
		} else if (isGameOver(game)) {
			return redirect(routes.Quiz.endResult());
		} else {
			return redirect(routes.Quiz.question());
		}
	}

	private static boolean isGameOver(QuizGame game) {
		return game.isRoundOver() && game.isGameOver();
	}

	private static boolean isRoundOver(QuizGame game) {
		return game.isRoundOver() && !game.isGameOver();
	}

	private static void cacheGame(QuizGame game) {
		Cache.set(gameId(), game, 3600, application());
	}

	@play.db.jpa.Transactional(readOnly = true)
	public static Result roundResult() {
		QuizGame game = cachedGame();
		if (game != null && isRoundOver(game)) {
			return ok(roundover.render(game));
		} else {
			return badRequest(Messages.get("quiz.no-round-result"));
		}
	}

	@play.db.jpa.Transactional(readOnly = true)
	public static Result endResult() {
		QuizGame game = cachedGame();
		if (game != null && isGameOver(game)) {
			QuizUser winner = game.getWinner();
			//evaluate loser
			List<QuizUser> players = game.getPlayers();			
			QuizUser loser = null;			
			for(QuizUser p:players){
				if(!p.equals(winner))
					loser=p;
			}
			if(loser.getName().equals("Spieler 2")){
				loser.setFirstName("Robby");
				loser.setLastName("Robot");
				loser.setGender(Gender.male);
				Date date = new Date();
				loser.setBirthDate(date);
			}
			if(winner.getName().equals("Spieler 2")){
				winner.setFirstName("Robby");
				winner.setLastName("Robot");
				winner.setGender(Gender.male);
				Date date = new Date();
				winner.setBirthDate(date);
			}
			if(winner.getName().equals("Spieler 1")){
				winner = user();
			}
			if(loser.getName().equals("Spieler 1")){
				loser = user();
			}			
			
			try {				
				PublishHighScoreService highScoreService = new PublishHighScoreService();
				//from this port methods can be called, rpc-style
				PublishHighScoreEndpoint port = highScoreService.getPublishHighScorePort();
				
				highscore.data.ObjectFactory dataFactory = new highscore.data.ObjectFactory();
				HighScoreRequestType in = dataFactory.createHighScoreRequestType();				
				
				//building up quiz with users (loser,winner) to pass them to the HighscoreRequestType in
				//and publishing it to the endpoint
				String uuid = port.publishHighScore(buildHighScoreRequest(in, winner, loser));
				session("uuid", uuid);
				play.Logger.info(session("uuid"));
				
			} catch (Failure e) {
				play.Logger.info("Failure occured: " + e.getMessage());
				return ok(quizover.render(game));
			} catch (Exception e1){
				play.Logger.info("Exception occured: " + e1.getMessage());
				return ok(quizover.render(game));
			}			
			return ok(quizover.render(game));
		} else {
			return badRequest(Messages.get("quiz.no-end-result"));
		}
	}

	@play.db.jpa.Transactional(readOnly = true)
	public static Result newRound() {
		QuizGame game = cachedGame();
		if (game != null && isRoundOver(game)) {
			game.startNewRound();
			return redirect(routes.Quiz.question());
		} else {
			return badRequest(Messages.get("quiz.no-round-ended"));
		}
	}

	private static QuizGame cachedGame() {
		Option<Object> option = Cache.get(gameId(), application());
		if (option.isDefined() && option.get() instanceof QuizGame) {
			return (QuizGame) option.get();
		} else {
			return createNewGame();
		}
	}

	private static String gameId() {
		return "game." + uuid();
	}

	private static String uuid() {
		String uuid = session("uuid");
		if (uuid == null) {
			uuid = UUID.randomUUID().toString();
			session("uuid", uuid);
		}
		return uuid;
	}

	private static Application application() {
		return Play.application().getWrappedApplication();
	}
	
	private static HighScoreRequestType buildHighScoreRequest(HighScoreRequestType in, QuizUser winner, QuizUser loser) throws DatatypeConfigurationException{
		highscore.generated.ObjectFactory genFactory = new highscore.generated.ObjectFactory();
		highscore.generated.Quiz quiz = genFactory.createQuiz();
		highscore.generated.Users users = genFactory.createUsers();
		highscore.generated.User l = genFactory.createUser();
		highscore.generated.Gender gw = highscore.generated.Gender.MALE;
		switch (winner.getGender()){
			case female:
				gw = highscore.generated.Gender.FEMALE;
			case male:
				gw = highscore.generated.Gender.MALE;
		}
		highscore.generated.User w = genFactory.createUser();
		highscore.generated.Gender gl = highscore.generated.Gender.MALE;			
		switch (loser.getGender()){
			case female:
				gl = highscore.generated.Gender.FEMALE;
			case male:
				gl = highscore.generated.Gender.MALE;
		}
		
		l.setGender(gl);
		GregorianCalendar c = new GregorianCalendar();
		c.setTime(loser.getBirthDate());				
		l.setBirthdate(DatatypeFactory.newInstance().newXMLGregorianCalendar(c));
		l.setFirstname(loser.getFirstName());
		l.setLastname(loser.getLastName());
		l.setName("loser");			
		l.setPassword("");
		
		w.setGender(gw);
		c = new GregorianCalendar();
		c.setTime(winner.getBirthDate());
		w.setBirthdate(DatatypeFactory.newInstance().newXMLGregorianCalendar(c));
		w.setFirstname(winner.getFirstName());
		w.setLastname(winner.getLastName());
		w.setName("winner");
		w.setPassword("");
				
		users.getUser().add(w);
		users.getUser().add(l);
		
		quiz.setUsers(users);
		in.setQuiz(quiz);
		in.setUserKey("rkf4394dwqp49x");
		//play.Logger.info(in.toString());
		return in;		
	}

}
