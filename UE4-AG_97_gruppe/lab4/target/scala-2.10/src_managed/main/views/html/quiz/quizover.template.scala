
package views.html.quiz

import play.templates._
import play.templates.TemplateMagic._

import play.api.templates._
import play.api.templates.PlayMagic._
import models._
import controllers._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.api.i18n._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import views.html._
import scala.collection._
/**/
object quizover extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[QuizGame,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(game: QuizGame):play.api.templates.HtmlFormat.Appendable = {
        _display_ {
def /*2.2*/player1/*2.9*/ = {{ game.getPlayers().get(0) }};def /*3.2*/player2/*3.9*/ = {{ game.getPlayers().get(1) }};def /*4.2*/winnerMessage/*4.15*/ = {{
    game.getWinner() match {
        case null => Messages("quiz.tie")
        case winner: QuizUser => Messages("quiz.winner", winner.getName())
    }
}};
Seq[Any](format.raw/*1.18*/("""
"""),format.raw/*2.41*/("""
"""),format.raw/*3.41*/("""
"""),format.raw/*9.2*/("""
"""),_display_(Seq[Any](/*10.2*/main("main.quiz",
      pageid = "winnerpage",
      navigation = immutable.Map(routes.Authentication.logout.url -> "login.logout"))/*12.86*/ {_display_(Seq[Any](format.raw/*12.88*/("""
	<section role="main">
		<!-- winner message -->
            <section id="roundwinner" aria-labelledby="roundwinnerheading">
                <h2 id="roundwinnerheading" class="accessibility">"""),_display_(Seq[Any](/*16.68*/Messages("quiz.result"))),format.raw/*16.91*/("""</h2>
                <p class="roundwinnermessage">"""),_display_(Seq[Any](/*17.48*/winnerMessage)),format.raw/*17.61*/("""</p>
            </section>
        
            <!-- round info -->    
            <section id="roundinfo" aria-labelledby="roundinfoheading">
                <h2 id="roundinfoheading" class="accessibility">"""),_display_(Seq[Any](/*22.66*/Messages("quiz.gameinfo"))),format.raw/*22.91*/("""</h2>
                <div id="player1info" class="playerinfo">
                    <span id="player1name" class="playername">"""),_display_(Seq[Any](/*24.64*/player1/*24.71*/.getName())),format.raw/*24.81*/("""</span>
                    <p id="player1roundcounter" class="playerroundcounter">"""),_display_(Seq[Any](/*25.77*/Messages("quiz.wonrounds"))),format.raw/*25.103*/(""": <span id="player1wonrounds" class="playerwonrounds">"""),_display_(Seq[Any](/*25.158*/game/*25.162*/.getWonRounds(player1))),format.raw/*25.184*/("""</span></p>
                </div>
                <div id="player2info" class="playerinfo">
                    <span id="player2name" class="playername">"""),_display_(Seq[Any](/*28.64*/player2/*28.71*/.getName())),format.raw/*28.81*/("""</span>
                    <p id="player2roundcounter" class="playerroundcounter">"""),_display_(Seq[Any](/*29.77*/Messages("quiz.wonrounds"))),format.raw/*29.103*/(""": <span id="player2wonrounds" class="playerwonrounds">"""),_display_(Seq[Any](/*29.158*/game/*29.162*/.getWonRounds(player2))),format.raw/*29.184*/("""</span></p>
                </div>
                """),_display_(Seq[Any](/*31.18*/helper/*31.24*/.form(routes.Quiz.newGame)/*31.50*/ {_display_(Seq[Any](format.raw/*31.52*/("""
                    <input id="next" type="submit" value=""""),_display_(Seq[Any](/*32.60*/Messages("quiz.start"))),format.raw/*32.82*/(""""/>
                """)))})),format.raw/*33.18*/("""
            </section>
            <script type="text/javascript">
            //<![CDATA[
	            $(document).ready(function()"""),format.raw/*37.42*/("""{"""),format.raw/*37.43*/("""
	         	   if(supportsLocalStorage())"""),format.raw/*38.41*/("""{"""),format.raw/*38.42*/("""
	         		   localStorage["lastGame"] = new Date().getTime();
	         	   """),format.raw/*40.15*/("""}"""),format.raw/*40.16*/("""
	            """),format.raw/*41.14*/("""}"""),format.raw/*41.15*/(""");
            //]]>
            </script>
    </section>
""")))})))}
    }
    
    def render(game:QuizGame): play.api.templates.HtmlFormat.Appendable = apply(game)
    
    def f:((QuizGame) => play.api.templates.HtmlFormat.Appendable) = (game) => apply(game)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sat May 24 20:03:42 CEST 2014
                    SOURCE: C:/Users/Gruim/Bernd/Studium/WebEngineering/befabe/UE4-AG_97_gruppe/lab4/app/views/quiz/quizover.scala.html
                    HASH: d5c6f279ab77f17873353ab53c02c2ce21592c72
                    MATRIX: 810->1|903->20|917->27|962->62|976->69|1021->104|1042->117|1236->17|1265->59|1294->101|1322->281|1360->284|1503->418|1543->420|1776->617|1821->640|1911->694|1946->707|2197->922|2244->947|2409->1076|2425->1083|2457->1093|2578->1178|2627->1204|2719->1259|2733->1263|2778->1285|2973->1444|2989->1451|3021->1461|3142->1546|3191->1572|3283->1627|3297->1631|3342->1653|3432->1707|3447->1713|3482->1739|3522->1741|3619->1802|3663->1824|3717->1846|3882->1983|3911->1984|3981->2026|4010->2027|4119->2108|4148->2109|4191->2124|4220->2125
                    LINES: 27->1|29->2|29->2|29->3|29->3|29->4|29->4|35->1|36->2|37->3|38->9|39->10|41->12|41->12|45->16|45->16|46->17|46->17|51->22|51->22|53->24|53->24|53->24|54->25|54->25|54->25|54->25|54->25|57->28|57->28|57->28|58->29|58->29|58->29|58->29|58->29|60->31|60->31|60->31|60->31|61->32|61->32|62->33|66->37|66->37|67->38|67->38|69->40|69->40|70->41|70->41
                    -- GENERATED --
                */
            