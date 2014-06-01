import at.ac.tuwien.big.we14.lab4.dbpedia.api.DBPediaService;
import at.ac.tuwien.big.we14.lab4.dbpedia.api.SelectQueryBuilder;
import at.ac.tuwien.big.we14.lab4.dbpedia.vocabulary.DBPProp;
import at.ac.tuwien.big.we14.lab4.dbpedia.vocabulary.DBPedia;
import at.ac.tuwien.big.we14.lab4.dbpedia.vocabulary.DBPediaOWL;

import com.google.common.io.Files;
import com.google.common.io.InputSupplier;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.sparql.vocabulary.FOAF;
import com.hp.hpl.jena.vocabulary.RDF;
import com.hp.hpl.jena.vocabulary.RDFS;

import data.JSONDataInserter;
import play.Application;
import play.GlobalSettings;
import play.Logger;
import play.Play;
import play.db.jpa.JPA;
import play.libs.F.Function0;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Locale;

import models.Category;
import models.Choice;
import models.Question;
import models.QuizDAO;

public class Global extends GlobalSettings {

	@play.db.jpa.Transactional
	public static void insertJSonData() throws IOException {
		File file = new File(Play.application().configuration().getString("questions.filePath"));
		InputSupplier<FileInputStream> inputStreamSupplier = 
				Files.newInputStreamSupplier(file);
		FileInputStream inputStream = inputStreamSupplier.getInput();
		JSONDataInserter.insertData(inputStream);
		Logger.info("Data from json file '" + file.getName() + "' inserted.");
		QuizDAO.INSTANCE.persist(createDBPediaCategory());
		Logger.info("Data from DBPedia inserted");
	}

	@play.db.jpa.Transactional
	public void onStart(Application app) {
		try {
			JPA.withTransaction(new Function0<Boolean>() {

				@Override
				public Boolean apply() throws Throwable {
					insertJSonData();
					return true;
				}

			});
		} catch (Throwable e) {
			e.printStackTrace();
		}

	}

	public void onStop(Application app) {
		Logger.info("Application shutdown...");
	}


	private static Category createDBPediaCategory() {
		Logger.info("check if dbpedia is available");
		if(!DBPediaService.isAvailable()){
			Logger.info("DBPedia is currently not available");
			return null;
		}

		// create new category

		Category movies = new Category();
		movies.setNameDE("Filme");
		movies.setNameEN("Movies");



		// create Questions for category




		// question 1 murnberger

		Resource directorMurnberger = DBPediaService.loadStatements(DBPedia.createResource("Wolfgang_Murnberger"));

		SelectQueryBuilder murnbergerQuery = DBPediaService.createQueryBuilder()
				.setLimit(3)
				.addWhereClause(RDF.type, DBPediaOWL.Film) // category film
				//.addPredicateExistsClause(FOAF.name)
				.addWhereClause(DBPediaOWL.director, directorMurnberger) // austrian films
				.addFilterClause(RDFS.label, Locale.GERMAN)
				.addFilterClause(RDFS.label, Locale.ENGLISH)
				;

		// get choices

		Model moviesMurnbergerQuery = DBPediaService.loadStatements(murnbergerQuery.toQueryString());


		murnbergerQuery.removeWhereClause(DBPediaOWL.director, directorMurnberger);
		murnbergerQuery.addMinusClause(DBPediaOWL.director, directorMurnberger);

		Model moviesNonMurnbergerQuery = DBPediaService.loadStatements(murnbergerQuery.toQueryString());

		Question murnbergerMovies = createQuestion("In which movies was Wolfgang Murnberger director?",
				"In welchen Filmen hat Wolfgang Murnberger Regie geführt?",
				movies,
				"25");

		murnbergerMovies.setMaxTime(new BigDecimal("25"));

		addChoicesToQuestion(murnbergerMovies, 
				DBPediaService.getResourceNames(moviesMurnbergerQuery, Locale.ENGLISH),
				DBPediaService.getResourceNames(moviesMurnbergerQuery, Locale.GERMAN),
				DBPediaService.getResourceNames(moviesNonMurnbergerQuery, Locale.ENGLISH),
				DBPediaService.getResourceNames(moviesNonMurnbergerQuery, Locale.GERMAN));



		// question 2 Haneke movies - done

		Resource director = DBPediaService.loadStatements(DBPedia.createResource("Michael_Haneke"));

		SelectQueryBuilder hanekeQuery = DBPediaService.createQueryBuilder()
				.setLimit(3)
				.addWhereClause(RDF.type, DBPediaOWL.Film) // category film
				//.addPredicateExistsClause(FOAF.name)
				.addWhereClause(DBPediaOWL.director, director) // austrian films
				.addFilterClause(RDFS.label, Locale.GERMAN)
				.addFilterClause(RDFS.label, Locale.ENGLISH)
				;

		// get choices

		Model moviesHanekeQuery = DBPediaService.loadStatements(hanekeQuery.toQueryString());


		hanekeQuery.removeWhereClause(DBPediaOWL.director, director);
		hanekeQuery.addMinusClause(DBPediaOWL.director, director);

		Model moviesNonHanekeQuery = DBPediaService.loadStatements(hanekeQuery.toQueryString());

	
		Question hanekeMovies = createQuestion("In which movies was Michael Haneke director?",
				"In welchen Filmen hat Michael Haneke Regie geführt?",
				movies,
				"25");

		hanekeMovies.setMaxTime(new BigDecimal("25"));

		addChoicesToQuestion(hanekeMovies, 
				DBPediaService.getResourceNames(moviesHanekeQuery, Locale.ENGLISH),
				DBPediaService.getResourceNames(moviesHanekeQuery, Locale.GERMAN),
				DBPediaService.getResourceNames(moviesNonHanekeQuery, Locale.ENGLISH),
				DBPediaService.getResourceNames(moviesNonHanekeQuery, Locale.GERMAN));


		// question 3 bierbichler


		Resource bierbichler = DBPediaService.loadStatements(DBPedia.createResource("Josef_Bierbichler"));

		SelectQueryBuilder bierbichlerQuery = DBPediaService.createQueryBuilder()
				.setLimit(4)
				//.addWhereClause(DBPediaOWL.starring)
				//.addPredicateExistsClause(FOAF.name)
				.addWhereClause(DBPediaOWL.starring, bierbichler) 
				//.addWhereClause(DBPediaOWL.writer, dorfer)
				//.addWhereClause(DBPediaOWL.Name, dorfer)
				.addFilterClause(RDFS.label, Locale.GERMAN)
				.addFilterClause(RDFS.label, Locale.ENGLISH)
				;

		// get choices

		Model bierbichlerMovieQuery = DBPediaService.loadStatements(bierbichlerQuery.toQueryString());

		//Model haderMovieQuery = DBPediaService.loadStatements("SELECT ?film	WHERE { ?film <http://dbpedia.org/ontology/starring> <http://dbpedia.org/resource/Josef_Hader> }");


		bierbichlerQuery.removeWhereClause(DBPediaOWL.starring, bierbichler);
		bierbichlerQuery.addMinusClause(DBPediaOWL.starring, bierbichler);
		bierbichlerQuery.setLimit(2);

		Model nonbierbichlerMovieQuery = DBPediaService.loadStatements(bierbichlerQuery.toQueryString());

	
		Question dorferActors = createQuestion("In which movies did Josef Bierbichler starr?",
				"In welchen Filmen hat Josef Bierbichler mitgespielt?",
				movies,
				"25");


		addChoicesToQuestion(dorferActors, 
				DBPediaService.getResourceNames(bierbichlerMovieQuery, Locale.ENGLISH),
				DBPediaService.getResourceNames(bierbichlerMovieQuery, Locale.GERMAN),
				DBPediaService.getResourceNames(nonbierbichlerMovieQuery, Locale.ENGLISH),
				DBPediaService.getResourceNames(nonbierbichlerMovieQuery, Locale.GERMAN));




		// question 4 Hader 

		Resource actor = DBPediaService.loadStatements(DBPedia.createResource("Josef_Hader"));

		SelectQueryBuilder haderQuery = DBPediaService.createQueryBuilder()
				.setLimit(4)

				//.addPredicateExistsClause(FOAF.name)
				.addWhereClause(DBPediaOWL.starring, actor)
				.addWhereClause(DBPediaOWL.writer, actor) 
				//.addWhereClause(DBPediaOWL.Name, hader)
				.addFilterClause(RDFS.label, Locale.GERMAN)
				.addFilterClause(RDFS.label, Locale.ENGLISH)
				;

		// get choices

		Model haderMovieQuery = DBPediaService.loadStatements(haderQuery.toQueryString());

		//Model haderMovieQuery = DBPediaService.loadStatements("SELECT ?film	WHERE { ?film <http://dbpedia.org/ontology/starring> <http://dbpedia.org/resource/Josef_Hader> }");

	
		haderQuery.removeWhereClause(DBPediaOWL.writer, actor);
		haderQuery.addMinusClause(DBPediaOWL.writer, actor);
		haderQuery.setLimit(4);

		Model nonHaderMovieQuery = DBPediaService.loadStatements(haderQuery.toQueryString());

		Question haderActors = createQuestion("In which movies did Josef Hader starr and write the script?",
				"In welchen Filmen hat Josef Hader mitgespielt und das Drehbuch geschrieben?",
				movies,
				"25");


		addChoicesToQuestion(haderActors, 
				DBPediaService.getResourceNames(haderMovieQuery, Locale.ENGLISH),
				DBPediaService.getResourceNames(haderMovieQuery, Locale.GERMAN),
				DBPediaService.getResourceNames(nonHaderMovieQuery, Locale.ENGLISH),
				DBPediaService.getResourceNames(nonHaderMovieQuery, Locale.GERMAN));


		// question5 antel - done

		Resource directorAntel = DBPediaService.loadStatements(DBPedia.createResource("Franz_Antel"));

		SelectQueryBuilder antelQuery = DBPediaService.createQueryBuilder()
				.setLimit(3)
				.addWhereClause(RDF.type, DBPediaOWL.Film) // category film
				//.addPredicateExistsClause(FOAF.name)
				.addWhereClause(DBPediaOWL.director, directorAntel) // austrian films
				.addFilterClause(RDFS.label, Locale.GERMAN)
				.addFilterClause(RDFS.label, Locale.ENGLISH)
				;

		// get choices

		Model antelMovieQuery = DBPediaService.loadStatements(antelQuery.toQueryString());


		antelQuery.removeWhereClause(DBPediaOWL.director, directorAntel);
		antelQuery.addMinusClause(DBPediaOWL.director, directorAntel);
		antelQuery.setLimit(4);

		Model nonantelMovieQuery = DBPediaService.loadStatements(antelQuery.toQueryString());

		Question antelActors = createQuestion("Which movies where directed by Franz Antel?",
				"In welchen Filmen hat Franz Antel Regie geführt?",
				movies,
				"25");


		addChoicesToQuestion(antelActors, 
				DBPediaService.getResourceNames(antelMovieQuery, Locale.ENGLISH),
				DBPediaService.getResourceNames(antelMovieQuery, Locale.GERMAN),
				DBPediaService.getResourceNames(nonantelMovieQuery, Locale.ENGLISH),
				DBPediaService.getResourceNames(nonantelMovieQuery, Locale.GERMAN));


		return movies;	
	}


	private static Question createQuestion(String textEN, String textDE, Category category, String timeout){
		Question question = new Question();
		question.setCategory(category);
		question.setTextEN(textEN);
		question.setTextDE(textDE);
		question.setMaxTime(new BigDecimal(timeout));
		category.addQuestion(question);
		return question;
	}


	private static void addChoicesToQuestion(Question question, List<String> rightChoiceEN, List<String> rightChoiceDE, List<String> wrongChoiceEN, List<String> wrongChoiceDE){

		//create right choices and add to question
		for(int i = 0; i < rightChoiceEN.size(); i++ ){
			Choice right = new Choice();

			right.setTextDE(rightChoiceDE.get(i));
			right.setTextEN(rightChoiceEN.get(i));
			right.setCorrectAnswer(true);
			right.setQuestion(question);
			question.addRightChoice(right);

		}

		//create wrong choices and add to question
		for(int i = 0; i < wrongChoiceEN.size(); i++ ){
			Choice wrong = new Choice();
			wrong.setTextDE(wrongChoiceDE.get(i));
			wrong.setTextEN(wrongChoiceEN.get(i));
			wrong.setCorrectAnswer(false);
			wrong.setQuestion(question);
			question.addWrongChoice(wrong);

		}				
	}


}