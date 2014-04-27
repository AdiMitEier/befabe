<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="de" lang="de">
    <head>
        <meta charset="utf-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Business Informatics Group Quiz - Zwischenstand</title>
        <link rel="stylesheet" type="text/css" href="style/screen.css" />
        <script src="js/jquery.js" type="text/javascript"></script>
        <script src="js/framework.js" type="text/javascript"></script>
    </head>
    <body id="winnerpage">
        <a class="accessibility" href="#roundwinner">Zur Rundenwertung springen</a>
        <header role="banner" aria-labelledby="mainheading"><h1 id="mainheading"><span class="accessibility">Business Informatics Group</span> Quiz</h1></header>
        <nav role="navigation" aria-labelledby="navheading">
            <h2 id="navheading" class="accessibility">Navigation</h2>
            <ul>
                <li><a id="logoutlink" title="Klicke hier um dich abzumelden" href="#" accesskey="l">Abmelden</a></li>
            </ul>
        </nav>
        
        <jsp:useBean id="player1" scope="session" class="at.ac.tuwien.big.we14.lab2.api.impl.SimplePlayer"/>
        <jsp:useBean id="player2" scope="session" class="at.ac.tuwien.big.we14.lab2.api.impl.SimplePlayer"/>
       
        <section role="main">
           
            <!-- winner message -->
            <section id="roundwinner" aria-labelledby="roundwinnerheading">
                <h2 id="roundwinnerheading" class="accessibility">Rundenzwischenstand</h2>
                <p class="roundwinnermessage">
					<% if ( player1.getRightQuestions() > player2.getRightQuestions() ) { %>
					Spieler <%=player1.getName() %> gewinnt die Runde.
					<% } else if  ( player1.getRightQuestions() < player2.getRightQuestions() ) { %>
					Spieler <%=player2.getName() %> gewinnt die Runde.
					<% } else { %>
					Die Runde geht unentschieden aus. 
					<% } %>
				
				</p>
            </section>
        	
        	 	
            <!-- round info -->    
            <section id="roundinfo" aria-labelledby="roundinfoheading">
                <h2 id="roundinfoheading" class="accessibility">Spielerinformationen</h2>
                <div id="player1info" class="playerinfo">
                    <span id="player1name" class="playername"><%=player1.getName() %></span>
                    <ul class="playerroundsummary">
                        <li><span class="accessibility">Frage 1:</span><span id="player1answer1" class=<%=player1.getRound1State().toString()%>> <%=player1.getRound1State().toGermanString()%></span></li>
                        <li><span class="accessibility">Frage 2:</span><span id="player1answer2" class=<%=player1.getRound2State().toString()%>> <%=player1.getRound2State().toGermanString()%></span></li>
                        <li><span class="accessibility">Frage 3:</span><span id="player1answer3" class=<%=player1.getRound3State().toString()%>> <%=player1.getRound3State().toGermanString()%></span></li>
                    </ul>
                    <p id="player1roundcounter" class="playerroundcounter">Gewonnene Runden: <span id="player1wonrounds" class="playerwonrounds"><%=player1.getWonRounds() %></span></p>
                </div>
                <div id="player2info" class="playerinfo">
                    <span id="player2name" class="playername"><%=player2.getName() %></span>
                    <ul class="playerroundsummary">
                        <li><span class="accessibility">Frage 1:</span><span id="player2answer1"  class=<%=player2.getRound1State().toString()%>><%=player2.getRound1State().toGermanString()%></span></li>
                        <li><span class="accessibility">Frage 2:</span><span id="player2answer2"  class=<%=player2.getRound2State().toString()%>><%=player2.getRound2State().toGermanString()%></span></li>
                        <li><span class="accessibility">Frage 3:</span><span id="player2answer3"  class=<%=player2.getRound2State().toString()%>><%=player2.getRound2State().toGermanString()%></span></li>
                    </ul>
                    <p id="player2roundcounter" class="playerroundcounter">Gewonnene Runden: <span id="player2wonrounds" class="playerwonrounds"><%=player2.getWonRounds() %></span></p>
                </div>
                <form id="startform" action="BigQuizServlet" method="post">
       				<input type="submit" id="next" name="startQuiz" value="Weiter"/>
       			</form>
               <!-- <a id="next" href="question.jsp">Weiter</a> --> 
            </section>
        </section>

        <!-- footer -->
        <footer role="contentinfo">© 2014 BIG Quiz</footer>
    </body>
</html>
