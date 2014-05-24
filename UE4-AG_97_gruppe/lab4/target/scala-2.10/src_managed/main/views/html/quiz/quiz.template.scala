
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
object quiz extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[QuizGame,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(game: QuizGame):play.api.templates.HtmlFormat.Appendable = {
        _display_ {
def /*2.2*/player1/*2.9*/ = {{ game.getPlayers().get(0) }};def /*3.2*/player2/*3.9*/ = {{ game.getPlayers().get(1) }};def /*4.2*/nameOfPlayer1/*4.15*/ = {{ player1.getName() }};def /*5.2*/nameOfPlayer2/*5.15*/ = {{ player2.getName() }};def /*6.2*/questions/*6.11*/ = {{ game.getCurrentRound().getQuestions() }};def /*7.2*/maxIndexOfQuestion/*7.20*/ = {{ questions.size() - 1 }};def /*8.2*/currentQuestion/*8.17*/ = {{ game.getCurrentRound().getCurrentQuestion(player1) }};def /*9.2*/currentCategory/*9.17*/ = {{ currentQuestion.getCategory() }};def /*10.2*/currentCategoryName/*10.21*/ = {{ currentCategory.getName(lang.code) }};def /*11.2*/correctOrIncorrect/*11.20*/(questionIndex: Int, player: QuizUser) = {{
	game.getCurrentRound().getAnswer(questionIndex, player) match {
		case null => "unknown"
		case answer if answer.isCorrect() => "correct"
		case answer if !answer.isCorrect() => "incorrect"
	}
}};
Seq[Any](format.raw/*1.18*/("""
"""),format.raw/*2.41*/("""
"""),format.raw/*3.41*/("""
"""),format.raw/*4.40*/("""
"""),format.raw/*5.40*/("""
"""),format.raw/*6.56*/("""
"""),format.raw/*7.48*/("""
"""),format.raw/*8.75*/("""
"""),format.raw/*9.54*/("""
"""),format.raw/*10.63*/("""
"""),format.raw/*17.2*/("""
"""),_display_(Seq[Any](/*18.2*/main("main.quiz",
      pageid = "welcomepage",
      navigation = immutable.Map(routes.Authentication.logout.url -> "login.logout"))/*20.86*/ {_display_(Seq[Any](format.raw/*20.88*/("""
	<section role="main" id="quiz">
		<section id="roundinfo" aria-labelledby="roundinfoheading">
		    <h2 id="roundinfoheading" class="accessibility">"""),_display_(Seq[Any](/*23.56*/Messages("quiz.playerinfo"))),format.raw/*23.83*/("""</h2>
		    <div id="player1info">
		        <span id="player1name">"""),_display_(Seq[Any](/*25.35*/nameOfPlayer1)),format.raw/*25.48*/("""</span>
		        <ul class="playerroundsummary">
		        """),_display_(Seq[Any](/*27.12*/for(i <- 0 to maxIndexOfQuestion) yield /*27.45*/ {_display_(Seq[Any](format.raw/*27.47*/("""
		            <li><span class="accessibility">"""),_display_(Seq[Any](/*28.48*/Messages("quiz.question"))),format.raw/*28.73*/(""" """),_display_(Seq[Any](/*28.75*/i)),format.raw/*28.76*/(""":</span><span id="player1answer"""),_display_(Seq[Any](/*28.108*/i)),format.raw/*28.109*/("""" class=""""),_display_(Seq[Any](/*28.119*/correctOrIncorrect(i, player1))),format.raw/*28.149*/(""""></span></li>
		        """)))})),format.raw/*29.12*/("""
		        </ul>
		    </div>
		    <div id="player2info">
		        <span id="player2name">"""),_display_(Seq[Any](/*33.35*/nameOfPlayer2)),format.raw/*33.48*/("""</span>
		        <ul class="playerroundsummary">
		        """),_display_(Seq[Any](/*35.12*/for(i <- 0 to maxIndexOfQuestion) yield /*35.45*/ {_display_(Seq[Any](format.raw/*35.47*/("""
		            <li><span class="accessibility">"""),_display_(Seq[Any](/*36.48*/Messages("quiz.question"))),format.raw/*36.73*/(""" """),_display_(Seq[Any](/*36.75*/i)),format.raw/*36.76*/(""":</span><span id="player2answer"""),_display_(Seq[Any](/*36.108*/i)),format.raw/*36.109*/("""" class=""""),_display_(Seq[Any](/*36.119*/correctOrIncorrect(i, player2))),format.raw/*36.149*/(""""></span></li>
		        """)))})),format.raw/*37.12*/("""
		        </ul>
		    </div>
		    <div id="currentcategory"><span class="accessibility">"""),_display_(Seq[Any](/*40.62*/Messages("quiz.category"))),format.raw/*40.87*/(""":</span> """),_display_(Seq[Any](/*40.97*/currentCategoryName)),format.raw/*40.116*/("""</div>
		</section>

		<!-- Question -->

		<section id="question" aria-labelledby="questionheading">
		    
		    """),_display_(Seq[Any](/*47.8*/helper/*47.14*/.form(routes.Quiz.addAnswer, 'id -> "questionform")/*47.65*/ {_display_(Seq[Any](format.raw/*47.67*/("""
		        <h2 id="questionheading" class="accessibility">"""),_display_(Seq[Any](/*48.59*/Messages("quiz.question"))),format.raw/*48.84*/("""</h2>
		        <p id="questiontext">"""),_display_(Seq[Any](/*49.33*/currentQuestion/*49.48*/.getText(lang.code))),format.raw/*49.67*/("""</p>
		        <ul id="answers">
		        """),_display_(Seq[Any](/*51.12*/for((choice, i) <- currentQuestion.getChoices().zipWithIndex) yield /*51.73*/ {_display_(Seq[Any](format.raw/*51.75*/("""
		            <li><input name="choices[]" id="option"""),_display_(Seq[Any](/*52.54*/i)),format.raw/*52.55*/("""" type="checkbox" value=""""),_display_(Seq[Any](/*52.81*/choice/*52.87*/.getId())),format.raw/*52.95*/(""""/><label id="labeloption"""),_display_(Seq[Any](/*52.121*/i)),format.raw/*52.122*/("""" for="option"""),_display_(Seq[Any](/*52.136*/i)),format.raw/*52.137*/("""">"""),_display_(Seq[Any](/*52.140*/choice/*52.146*/.getText(lang.code))),format.raw/*52.165*/("""</label></li>
		        """)))})),format.raw/*53.12*/("""
		        </ul>
		        <input id="questionid" name="questionid" type="hidden" value=""""),_display_(Seq[Any](/*55.74*/currentQuestion/*55.89*/.getId())),format.raw/*55.97*/(""""/>
		        <input id="timeleftvalue" name="timeleft" type="hidden" value="100"/>
		        <input id="next" type="submit" value=""""),_display_(Seq[Any](/*57.50*/Messages("quiz.nextquestion"))),format.raw/*57.79*/(""""/>
		    """)))})),format.raw/*58.8*/("""
		</section>

		<section id="timer" aria-labelledby="timerheading">
		    <h2 id="timerheading" class="accessibility">"""),_display_(Seq[Any](/*62.52*/Messages("quiz.timer"))),format.raw/*62.74*/("""</h2>
		    <p><span id="timeleftlabel">"""),_display_(Seq[Any](/*63.36*/Messages("quiz.remainingtime"))),format.raw/*63.66*/(""":</span> <time id="timeleft">00:30</time></p>
		    <meter id="timermeter" min="0" low="20" value="100" max="100"/>
		</section>

		<section id="lastgame">
		    <p>"""),_display_(Seq[Any](/*68.11*/Messages("quiz.previousgame"))),format.raw/*68.40*/(""": """),_display_(Seq[Any](/*68.43*/Messages("quiz.previousgame.never"))),format.raw/*68.78*/("""</p>
		</section>
		<script type="text/javascript">
		    //<![CDATA[
		    
		    // initialize time
		    $(document).ready(function()"""),format.raw/*74.35*/("""{"""),format.raw/*74.36*/("""
		        var maxtime = """),_display_(Seq[Any](/*75.26*/currentQuestion/*75.41*/.getMaxTime())),format.raw/*75.54*/(""";
		        var hiddenInput = $("#timeleftvalue");
		        var meter = $("#timer meter");
		        var timeleft = $("#timeleft");
		        
		        hiddenInput.val(maxtime);
		        meter.val(maxtime);
		        meter.attr('max', maxtime);
		        meter.attr('low', maxtime/100*20);
		        timeleft.text(secToMMSS(maxtime));
		        
		        // set last game
		        if(supportsLocalStorage())"""),format.raw/*87.37*/("""{"""),format.raw/*87.38*/("""
		            var lastGameMillis = parseInt(localStorage['lastGame'])
		            if(!isNaN(parseInt(localStorage['lastGame'])))"""),format.raw/*89.61*/("""{"""),format.raw/*89.62*/("""
		                var lastGame = new Date(lastGameMillis);
		            	$("#lastgame p").replaceWith('<p>"""),_display_(Seq[Any](/*91.50*/Messages("quiz.previousgame"))),format.raw/*91.79*/(""": <time datetime="'
		            			+ lastGame.toUTCString()
		            			+ '">'
		            			+ lastGame.toLocaleString()
		            			+ '</time></p>')
		            """),format.raw/*96.15*/("""}"""),format.raw/*96.16*/("""
		    	"""),format.raw/*97.8*/("""}"""),format.raw/*97.9*/("""
		    """),format.raw/*98.7*/("""}"""),format.raw/*98.8*/(""");
		    
		    // update time
		    function timeStep()"""),format.raw/*101.26*/("""{"""),format.raw/*101.27*/("""
		        var hiddenInput = $("#timeleftvalue");
		        var meter = $("#timer meter");
		        var timeleft = $("#timeleft");
		        
		        var value = $("#timeleftvalue").val();
		        if(value > 0)"""),format.raw/*107.24*/("""{"""),format.raw/*107.25*/("""
		            value = value - 1;   
		        """),format.raw/*109.11*/("""}"""),format.raw/*109.12*/("""
		        
		        hiddenInput.val(value);
		        meter.val(value);
		        timeleft.text(secToMMSS(value));
		        
		        if(value <= 0)"""),format.raw/*115.25*/("""{"""),format.raw/*115.26*/("""
		            $('#questionform').submit();
		        """),format.raw/*117.11*/("""}"""),format.raw/*117.12*/("""
		    """),format.raw/*118.7*/("""}"""),format.raw/*118.8*/("""
		    
		    window.setInterval(timeStep,1000);
		    
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
                    SOURCE: C:/Users/Gruim/Bernd/Studium/WebEngineering/befabe/UE4-AG_97_gruppe/lab4/app/views/quiz/quiz.scala.html
                    HASH: 3348202faa1b27366e0c4579382d484ca9a74836
                    MATRIX: 806->1|899->20|913->27|958->62|972->69|1017->104|1038->117|1076->145|1097->158|1135->186|1152->195|1210->243|1236->261|1277->292|1300->307|1371->368|1394->383|1445->423|1473->442|1529->487|1556->505|1831->17|1860->59|1889->101|1918->142|1947->183|1976->240|2005->289|2034->365|2063->420|2093->484|2122->750|2160->753|2304->888|2344->890|2534->1044|2583->1071|2690->1142|2725->1155|2824->1218|2873->1251|2913->1253|2998->1302|3045->1327|3083->1329|3106->1330|3175->1362|3199->1363|3246->1373|3299->1403|3358->1430|3491->1527|3526->1540|3625->1603|3674->1636|3714->1638|3799->1687|3846->1712|3884->1714|3907->1715|3976->1747|4000->1748|4047->1758|4100->1788|4159->1815|4289->1909|4336->1934|4382->1944|4424->1963|4582->2086|4597->2092|4657->2143|4697->2145|4793->2205|4840->2230|4915->2269|4939->2284|4980->2303|5062->2349|5139->2410|5179->2412|5270->2467|5293->2468|5355->2494|5370->2500|5400->2508|5463->2534|5487->2535|5538->2549|5562->2550|5602->2553|5618->2559|5660->2578|5718->2604|5846->2696|5870->2711|5900->2719|6071->2854|6122->2883|6165->2895|6325->3019|6369->3041|6447->3083|6499->3113|6706->3284|6757->3313|6796->3316|6853->3351|7023->3493|7052->3494|7115->3521|7139->3536|7174->3549|7626->3973|7655->3974|7816->4107|7845->4108|7992->4219|8043->4248|8255->4432|8284->4433|8320->4442|8348->4443|8383->4451|8411->4452|8499->4511|8529->4512|8779->4733|8809->4734|8887->4783|8917->4784|9104->4942|9134->4943|9219->4999|9249->5000|9285->5008|9314->5009
                    LINES: 27->1|29->2|29->2|29->3|29->3|29->4|29->4|29->5|29->5|29->6|29->6|29->7|29->7|29->8|29->8|29->9|29->9|29->10|29->10|29->11|29->11|36->1|37->2|38->3|39->4|40->5|41->6|42->7|43->8|44->9|45->10|46->17|47->18|49->20|49->20|52->23|52->23|54->25|54->25|56->27|56->27|56->27|57->28|57->28|57->28|57->28|57->28|57->28|57->28|57->28|58->29|62->33|62->33|64->35|64->35|64->35|65->36|65->36|65->36|65->36|65->36|65->36|65->36|65->36|66->37|69->40|69->40|69->40|69->40|76->47|76->47|76->47|76->47|77->48|77->48|78->49|78->49|78->49|80->51|80->51|80->51|81->52|81->52|81->52|81->52|81->52|81->52|81->52|81->52|81->52|81->52|81->52|81->52|82->53|84->55|84->55|84->55|86->57|86->57|87->58|91->62|91->62|92->63|92->63|97->68|97->68|97->68|97->68|103->74|103->74|104->75|104->75|104->75|116->87|116->87|118->89|118->89|120->91|120->91|125->96|125->96|126->97|126->97|127->98|127->98|130->101|130->101|136->107|136->107|138->109|138->109|144->115|144->115|146->117|146->117|147->118|147->118
                    -- GENERATED --
                */
            