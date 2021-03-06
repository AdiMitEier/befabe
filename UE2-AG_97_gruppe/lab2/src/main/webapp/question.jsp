<%@page import="at.ac.tuwien.big.we14.lab2.api.Choice"%>
<%@page import="at.ac.tuwien.big.we14.lab2.api.impl.SimpleChoice"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="de" lang="de">
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Business Informatics Group Quiz</title>
<link rel="stylesheet" type="text/css" href="style/screen.css" />
<script src="js/jquery.js" type="text/javascript"></script>
<script src="js/framework.js" type="text/javascript"></script>
<script type="text/javascript">
	function lastFinishedGame() {
		var lastFinishedGame;

		if (supportsLocalStorage()) {
			lastFinishedGame = localStorage.lastFinishedGame;
			if (lastFinishedGame == null) {
				lastFinishedGame = "Nie";
			}

		} else {
			lastFinishedGame = "localStorage not supported by Browser";
		}

		document.getElementById("lastgame").innerHTML = lastFinishedGame;
	}

	//     	if(typeof(Storage)!="undefined"){
	//     		document.getElementById("lastgame").innerHTML=localStorage.getItem("lastfinishedGame");
	// 		} else {
	// 			document.getElementById("lastgame").innerHTML="storage not supported in this browser";
	// 		}
</script>
</head>
                

        </script>
    </head>
    <body id="questionpage">
        <a class="accessibility" href="#question">Zur Frage springen</a>
        <header role="banner" aria-labelledby="mainheading"><h1 id="mainheading"><span class="accessibility">Business Informatics Group</span> Quiz</h1></header>
        <nav role="navigation" aria-labelledby="navheading">
            <h2 id="navheading" class="accessibility">Navigation</h2>
            <ul>
                <li><a id="logoutlink" title="Klicke hier um dich abzumelden" href="#" accesskey="l">Abmelden</a></li>
            </ul>
        </nav>

        
        <!-- round info -->
        <section role="main">
            <section id="roundinfo" aria-labelledby="roundinfoheading">
                <h2 id="roundinfoheading" class="accessibility">Spielerinformationen</h2>
                <div id="player1info">
                    <jsp:useBean id="player1" scope="session" class="at.ac.tuwien.big.we14.lab2.api.impl.SimplePlayer"/>
        			<jsp:useBean id="player2" scope="session" class="at.ac.tuwien.big.we14.lab2.api.impl.SimplePlayer"/>
                    <span id="player1name"><%=player1.getName() %></span>
                    <ul class="playerroundsummary">
                        <li><span class="accessibility">Frage 1:</span><span id="player1answer1" class=<%=player1.getRound1State().toString()%>> <%=player1.getRound1State().toGermanString()%></span></li>
                        <li><span class="accessibility">Frage 2:</span><span id="player1answer2" class=<%=player1.getRound2State().toString()%>> <%=player1.getRound2State().toGermanString()%></span></li>
                        <li><span class="accessibility">Frage 3:</span><span id="player1answer3" class=<%=player1.getRound3State().toString()%>> <%=player1.getRound3State().toGermanString()%></span></li>
                    </ul>
                </div>
                <div id="player2info">
                    <span id="player2name"><%=player2.getName() %></span>
                    <ul class="playerroundsummary">
                        <li><span class="accessibility">Frage 1:</span><span id="player2answer1" class=<%=player2.getRound1State().toString()%>> <%=player2.getRound1State().toGermanString()%></span></li>
                        <li><span class="accessibility">Frage 2:</span><span id="player2answer2" class=<%=player2.getRound2State().toString()%>> <%=player2.getRound2State().toGermanString()%></span></li>
                        <li><span class="accessibility">Frage 3:</span><span id="player2answer3" class=<%=player2.getRound3State().toString()%>> <%=player2.getRound3State().toGermanString()%></span></li>
                    </ul>
                </div>
                <jsp:useBean id="category" scope="session" class="at.ac.tuwien.big.we14.lab2.api.impl.SimpleCategory"/>
                <div id="currentcategory"><span class="accessibility">Kategorie:</span><%=category.getName() %></div>
            </section>
            
            <!-- Question -->
            <section id="question" aria-labelledby="questionheading">
                <form id="questionform" action="BigQuizServlet" method="post">
                    <jsp:useBean id="question" scope="session" class="at.ac.tuwien.big.we14.lab2.api.impl.SimpleQuestion"/>
                    <h2 id="questionheading" class="accessibility">Frage</h2>
                    <p id="questiontext"><%=question.getText()%></p>
                    <%int i = 1;%>
                    <ul id="answers">     	
                    	<%for(Choice choice : question.getAllChoices()) {%>
                    		<li><input name="answers" id=<%="option"+i %> type="checkbox" value=<%=choice.getId() %>/><label for=<%="option"+i %>><%=choice.getText() %></label></li>
	                        <%i++; %>
	                       <%}%>
                    </ul>
                    <input name="timeleftvalue" id="timeleftvalue" type="hidden" value="100"/>
                    <input id="next" type="submit" value="weiter" accesskey="s"/>
                </form>
            </section>
            
                       
            <section id="timer" aria-labelledby="timerheading">
                <h2 id="timerheading" class="accessibility">Timer</h2>
                <p><span id="timeleftlabel">Verbleibende Zeit:</span> <time name="timeleft" id="timeleft">00:30</time></p>
                <meter id="timermeter" min="0" low="20" value="100" max="100"/>
            </section>
            
            <section id="lastgame" onLoad="lastGameFinished()">
                <p>Letztes Spiel: Nie</p>
            </section>
        </section>

        <!-- footer -->
        <footer role="contentinfo">© 2014 BIG Quiz</footer>
        
        <script type="text/javascript">
            //<![CDATA[

            
            // initialize time
            $(document).ready(function() {
                var maxtime = 30;
                var hiddenInput = $("#timeleftvalue");
                var meter = $("#timer meter");
                var timeleft = $("#timeleft");
                
                hiddenInput.val(maxtime);
                meter.val(maxtime);
                meter.attr('max', maxtime);
                meter.attr('low', maxtime/100*20);
                timeleft.text(secToMMSS(maxtime));
            });
            
            // update time
            function timeStep() {
                var hiddenInput = $("#timeleftvalue");
                var meter = $("#timer meter");
                var timeleft = $("#timeleft");
                
                var value = $("#timeleftvalue").val();
                if(value > 0) {
                    value = value - 1;   
                }
                
                hiddenInput.val(value);
                meter.val(value);
                timeleft.text(secToMMSS(value));
                
                if(value <= 0) {
                    $('#questionform').submit();
                }
            }
            
            window.setInterval(timeStep, 1000);
            
            //]]>
        </script>
    </body>

</html>
