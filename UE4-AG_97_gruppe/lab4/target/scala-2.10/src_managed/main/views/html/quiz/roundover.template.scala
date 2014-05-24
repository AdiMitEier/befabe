
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
                    DATE: Sat May 24 20:03:42 CEST 2014
                    SOURCE: C:/Users/Gruim/Bernd/Studium/WebEngineering/befabe/UE4-AG_97_gruppe/lab4/app/views/quiz/roundover.scala.html
                    HASH: 6fec806e938c69def3ef9db1aa8b5ec4e8414351
                    MATRIX: 811->1|904->20|918->27|963->62|977->69|1022->104|1039->113|1097->161|1123->179|1164->210|1190->228|1461->488|1488->506|1771->778|1805->803|2170->17|2199->59|2228->101|2257->158|2286->207|2315->485|2344->775|2373->1138|2411->1141|2554->1275|2594->1277|2819->1466|2876->1501|2962->1551|3002->1569|3233->1764|3280->1789|3434->1907|3450->1914|3482->1924|3593->1999|3642->2032|3682->2034|3805->2121|3828->2122|3896->2154|3919->2155|3966->2165|4019->2195|4088->2228|4147->2265|4258->2344|4391->2441|4439->2467|4531->2522|4545->2526|4590->2548|4770->2692|4786->2699|4818->2709|4929->2784|4978->2817|5018->2819|5141->2906|5164->2907|5232->2939|5255->2940|5302->2950|5355->2980|5424->3013|5483->3050|5594->3129|5727->3226|5775->3252|5867->3307|5881->3311|5926->3333|6008->3379|6023->3385|6059->3412|6099->3414|6192->3471|6235->3492|6285->3510
                    LINES: 27->1|29->2|29->2|29->3|29->3|29->4|29->4|29->5|29->5|29->6|29->6|34->12|34->12|40->19|40->19|47->1|48->2|49->3|50->4|51->5|52->11|53->18|54->25|55->26|57->28|57->28|61->32|61->32|62->33|62->33|67->38|67->38|69->40|69->40|69->40|71->42|71->42|71->42|73->44|73->44|73->44|73->44|73->44|73->44|74->45|74->45|77->48|79->50|79->50|79->50|79->50|79->50|82->53|82->53|82->53|84->55|84->55|84->55|86->57|86->57|86->57|86->57|86->57|86->57|87->58|87->58|90->61|92->63|92->63|92->63|92->63|92->63|94->65|94->65|94->65|94->65|95->66|95->66|96->67
                    -- GENERATED --
                */
            