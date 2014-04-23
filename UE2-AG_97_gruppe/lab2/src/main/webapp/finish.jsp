<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="de" lang="de">
    <head>
        <meta charset="utf-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Business Informatics Group Quiz - Spielende</title>
        <link rel="stylesheet" type="text/css" href="style/screen.css" />
        <script src="js/jquery.js" type="text/javascript"></script>
        <script src="js/framework.js" type="text/javascript"></script>
        <script type="text/javascript">

        	if(supportsLocalStorage()) {
        		var date = new Date;
				date.setTime(date.getTime());
				var dateToStore = "Letztes Spiel: " + date.toLocaleDateString(date) + " - " + date.toLocaleTimeString(date);
				localStorage.lastFinishedGame = dateToStore;
        	}
        	
        
// 			if(typeof(Storage)!="undefined"){
// 				var date = new Date;
// 				date.setTime(date.getTime());
// 				var dateToStore = date.getDate() + " " + date.getMonth() + " " + date.getFullYear() + " " + date.getHours() + ":"+date.getMinutes();
// 				localStorage.setItem("lastfinishedGame", dateToStore);	
// 			}	

        </script>
    </head>
    <body id="winnerpage">
        <a class="accessibility" href="#roundwinner">Zur Spielwertung springen</a>
        <header role="banner" aria-labelledby="mainheading"><h1 id="mainheading"><span class="accessibility">Business Informatics Group</span> Quiz</h1></header>
        <nav role="navigation" aria-labelledby="navheading">
            <h2 id="navheading" class="accessibility">Navigation</h2>
            <ul>
                <li><a id="logoutlink" title="Klicke hier um dich abzumelden" href="#" accesskey="l">Abmelden</a></li>
            </ul>
        </nav>
        
        <section role="main">
            <!-- winner message -->
            <section id="roundwinner" aria-labelledby="roundwinnerheading">
                <h2 id="roundwinnerheading" class="accessibility">Endstand</h2>
                <p class="roundwinnermessage">Spieler 2 gewinnt!</p>
            </section>
        	
        	<jsp:useBean id="player1" scope="session" class="at.ac.tuwien.big.we14.lab2.api.impl.SimplePlayer"/>
        	<jsp:useBean id="player2" scope="session" class="at.ac.tuwien.big.we14.lab2.api.impl.SimplePlayer"/>
        	
            <!-- round info -->    
            <section id="roundinfo" aria-labelledby="roundinfoheading">
                <h2 id="roundinfoheading" class="accessibility">Spielerinformationen</h2>
                <div id="player1info" class="playerinfo">
                    <span id="player1name" class="playername"><%=player1.getName() %></span>
                    <p id="player1roundcounter" class="playerroundcounter">Gewonnene Runden: <span id="player1wonrounds" class="playerwonrounds"><%=player1.getWonRounds() %></span></p>
                </div>
                <div id="player2info" class="playerinfo">
                    <span id="player2name" class="playername"><%=player2.getName() %></span>
                    <p id="player2roundcounter" class="playerroundcounter">Gewonnene Runden: <span id="player2wonrounds" class="playerwonrounds"><%=player2.getWonRounds() %></span></p>
                </div>
                <form id="startform" action="BigQuizServlet" method="post">
       				<input type="submit" id="next" name="startQuiz" value="Neues Spiel"/>
       			</form>
                <!--<a id="next" href="question.jsp" accesskey="n">Neues Spiel</a>   -->
            </section>
        </section>

        <!-- footer -->
        <footer role="contentinfo">© 2014 BIG Quiz</footer>
    </body>
</html>
