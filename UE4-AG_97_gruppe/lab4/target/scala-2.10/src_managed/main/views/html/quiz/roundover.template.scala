
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
object roundover extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[QuizGame,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(game: QuizGame):play.api.templates.HtmlFormat.Appendable = {
        _display_ {
def /*2.2*/player1/*2.9*/ = {{ game.getPlayers().get(0) }};def /*3.2*/player2/*3.9*/ = {{ game.getPlayers().get(1) }};def /*4.2*/questions/*4.11*/ = {{ game.getCurrentRound().getQuestions() }};def /*5.2*/maxIndexOfQuestion/*5.20*/ = {{ questions.size() - 1 }};def /*6.2*/roundWinnerMessage/*6.20*/ = {{
    game.getCurrentRound().getRoundWinner() match {
        case null => Messages("quiz.round.tie", game.getCurrentRoundCount())
        case winner: QuizUser => Messages("quiz.round.winner", winner.getName(), game.getCurrentRoundCount())
    }
}};def /*12.2*/correctOrIncorrect/*12.20*/(questionIndex: Int, player: QuizUser) = {{
    game.getCurrentRound().getAnswer(questionIndex, player) match {
        case null => "unknown"
        case answer if answer.isCorrect() => "correct"
        case answer if !answer.isCorrect() => "incorrect"
    }
}};def /*19.2*/correctOrIncorrectMessage/*19.27*/(questionIndex: Int, player: QuizUser) = {{
    game.getCurrentRound().getAnswer(questionIndex, player) match {
        case null => Messages("quiz.answer.unknown")
        case answer if answer.isCorrect() => Messages("quiz.answer.correct")
        case answer if !answer.isCorrect() => Messages("quiz.answer.incorrect")
    }
}};
Seq[Any](format.raw/*1.18*/("""
"""),format.raw/*2.41*/("""
"""),format.raw/*3.41*/("""
"""),format.raw/*4.56*/("""
"""),format.raw/*5.48*/("""
"""),format.raw/*11.2*/("""
"""),format.raw/*18.2*/("""
"""),format.raw/*25.2*/("""
"""),_display_(Seq[Any](/*26.2*/main("main.quiz",
      pageid = "winnerpage",
      navigation = immutable.Map(routes.Authentication.logout.url -> "login.logout"))/*28.86*/ {_display_(Seq[Any](format.raw/*28.88*/("""
	<section role="main">
		<!-- winner message -->
        <section id="roundwinner" aria-labelledby="roundwinnerheading">
            <h2 id="roundwinnerheading" class="accessibility">"""),_display_(Seq[Any](/*32.64*/Messages("quiz.intermediateresult"))),format.raw/*32.99*/("""</h2>
            <p class="roundwinnermessage">"""),_display_(Seq[Any](/*33.44*/roundWinnerMessage)),format.raw/*33.62*/("""</p>
        </section>
    
        <!-- round info -->    
        <section id="roundinfo" aria-labelledby="roundinfoheading">
            <h2 id="roundinfoheading" class="accessibility">"""),_display_(Seq[Any](/*38.62*/Messages("quiz.gameinfo"))),format.raw/*38.87*/("""</h2>
            <div id="player1info" class="playerinfo">
            	<span id="player1name" class="playername">"""),_display_(Seq[Any](/*40.57*/player1/*40.64*/.getName())),format.raw/*40.74*/("""</span>
                <ul class="playerroundsummary">
                """),_display_(Seq[Any](/*42.18*/for(i <- 0 to maxIndexOfQuestion) yield /*42.51*/ {_display_(Seq[Any](format.raw/*42.53*/("""
                    <li>
                        <span class="accessibility">Frage """),_display_(Seq[Any](/*44.60*/i)),format.raw/*44.61*/(""":</span><span id="player1answer"""),_display_(Seq[Any](/*44.93*/i)),format.raw/*44.94*/("""" class=""""),_display_(Seq[Any](/*44.104*/correctOrIncorrect(i, player1))),format.raw/*44.134*/("""">
                            """),_display_(Seq[Any](/*45.30*/correctOrIncorrectMessage(i, player1))),format.raw/*45.67*/("""
                        </span>
                    </li>
                """)))})),format.raw/*48.18*/("""
                </ul>
                <p id="player1roundcounter" class="playerroundcounter">"""),_display_(Seq[Any](/*50.73*/Messages("quiz.wonrounds"))),format.raw/*50.99*/(""": <span id="player1wonrounds" class="playerwonrounds">"""),_display_(Seq[Any](/*50.154*/game/*50.158*/.getWonRounds(player1))),format.raw/*50.180*/("""</span></p>
            </div>
            <div id="player2info" class="playerinfo">
            	<span id="player2name" class="playername">"""),_display_(Seq[Any](/*53.57*/player2/*53.64*/.getName())),format.raw/*53.74*/("""</span>
                <ul class="playerroundsummary">
                """),_display_(Seq[Any](/*55.18*/for(i <- 0 to maxIndexOfQuestion) yield /*55.51*/ {_display_(Seq[Any](format.raw/*55.53*/("""
                    <li>
                        <span class="accessibility">Frage """),_display_(Seq[Any](/*57.60*/i)),format.raw/*57.61*/(""":</span><span id="player2answer"""),_display_(Seq[Any](/*57.93*/i)),format.raw/*57.94*/("""" class=""""),_display_(Seq[Any](/*57.104*/correctOrIncorrect(i, player2))),format.raw/*57.134*/("""">
                            """),_display_(Seq[Any](/*58.30*/correctOrIncorrectMessage(i, player2))),format.raw/*58.67*/("""
                        </span>
                    </li>
                """)))})),format.raw/*61.18*/("""
                </ul>
                <p id="player2roundcounter" class="playerroundcounter">"""),_display_(Seq[Any](/*63.73*/Messages("quiz.wonrounds"))),format.raw/*63.99*/(""": <span id="player2wonrounds" class="playerwonrounds">"""),_display_(Seq[Any](/*63.154*/game/*63.158*/.getWonRounds(player2))),format.raw/*63.180*/("""</span></p>
            </div>
            """),_display_(Seq[Any](/*65.14*/helper/*65.20*/.form(routes.Quiz.newRound)/*65.47*/ {_display_(Seq[Any](format.raw/*65.49*/("""
                <input id="next" type="submit" value=""""),_display_(Seq[Any](/*66.56*/Messages("quiz.next"))),format.raw/*66.77*/(""""/>
            """)))})),format.raw/*67.14*/("""
        </section>
    </section>
""")))})))}
    }
    
    def render(game:QuizGame): play.api.templates.HtmlFormat.Appendable = apply(game)
    
    def f:((QuizGame) => play.api.templates.HtmlFormat.Appendable) = (game) => apply(game)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue May 20 10:09:04 CEST 2014
                    SOURCE: /home/bernd/Dropbox/Studium/Web Engineering/befabe/UE4-AG_97_gruppe/lab4/app/views/quiz/roundover.scala.html
                    HASH: bc993a31292173799e8bb3e9b28ef680e653995f
                    MATRIX: 811->1|904->19|918->26|963->60|977->67|1022->101|1039->110|1097->157|1123->175|1164->205|1190->223|1456->477|1483->495|1760->760|1794->785|2153->17|2181->58|2209->99|2237->155|2265->203|2293->475|2321->758|2349->1114|2386->1116|2527->1248|2567->1250|2788->1435|2845->1470|2930->1519|2970->1537|3196->1727|3243->1752|3395->1868|3411->1875|3443->1885|3552->1958|3601->1991|3641->1993|3762->2078|3785->2079|3853->2111|3876->2112|3923->2122|3976->2152|4044->2184|4103->2221|4211->2297|4342->2392|4390->2418|4482->2473|4496->2477|4541->2499|4718->2640|4734->2647|4766->2657|4875->2730|4924->2763|4964->2765|5085->2850|5108->2851|5176->2883|5199->2884|5246->2894|5299->2924|5367->2956|5426->2993|5534->3069|5665->3164|5713->3190|5805->3245|5819->3249|5864->3271|5944->3315|5959->3321|5995->3348|6035->3350|6127->3406|6170->3427|6219->3444
                    LINES: 27->1|29->2|29->2|29->3|29->3|29->4|29->4|29->5|29->5|29->6|29->6|34->12|34->12|40->19|40->19|47->1|48->2|49->3|50->4|51->5|52->11|53->18|54->25|55->26|57->28|57->28|61->32|61->32|62->33|62->33|67->38|67->38|69->40|69->40|69->40|71->42|71->42|71->42|73->44|73->44|73->44|73->44|73->44|73->44|74->45|74->45|77->48|79->50|79->50|79->50|79->50|79->50|82->53|82->53|82->53|84->55|84->55|84->55|86->57|86->57|86->57|86->57|86->57|86->57|87->58|87->58|90->61|92->63|92->63|92->63|92->63|92->63|94->65|94->65|94->65|94->65|95->66|95->66|96->67
                    -- GENERATED --
                */
            