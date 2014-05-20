
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
                    DATE: Tue May 20 10:09:04 CEST 2014
                    SOURCE: /home/bernd/Dropbox/Studium/Web Engineering/befabe/UE4-AG_97_gruppe/lab4/app/views/quiz/quiz.scala.html
                    HASH: 635fec746eb3612bd2140b6ca14a670d4830eb63
                    MATRIX: 806->1|899->19|913->26|958->60|972->67|1017->101|1038->114|1076->141|1097->154|1135->181|1152->190|1210->237|1236->255|1277->285|1300->300|1371->360|1394->375|1445->414|1473->433|1529->477|1556->495|1825->17|1853->58|1881->99|1909->139|1937->179|1965->235|1993->283|2021->358|2049->412|2078->475|2106->734|2143->736|2285->869|2325->871|2512->1022|2561->1049|2666->1118|2701->1131|2798->1192|2847->1225|2887->1227|2971->1275|3018->1300|3056->1302|3079->1303|3148->1335|3172->1336|3219->1346|3272->1376|3330->1402|3459->1495|3494->1508|3591->1569|3640->1602|3680->1604|3764->1652|3811->1677|3849->1679|3872->1680|3941->1712|3965->1713|4012->1723|4065->1753|4123->1779|4250->1870|4297->1895|4343->1905|4385->1924|4536->2040|4551->2046|4611->2097|4651->2099|4746->2158|4793->2183|4867->2221|4891->2236|4932->2255|5012->2299|5089->2360|5129->2362|5219->2416|5242->2417|5304->2443|5319->2449|5349->2457|5412->2483|5436->2484|5487->2498|5511->2499|5551->2502|5567->2508|5609->2527|5666->2552|5792->2642|5816->2657|5846->2665|6015->2798|6066->2827|6108->2838|6264->2958|6308->2980|6385->3021|6437->3051|6639->3217|6690->3246|6729->3249|6786->3284|6950->3420|6979->3421|7041->3447|7065->3462|7100->3475|7540->3887|7569->3888|7728->4019|7757->4020|7902->4129|7953->4158|8160->4337|8189->4338|8224->4346|8252->4347|8286->4354|8314->4355|8399->4411|8429->4412|8673->4627|8703->4628|8779->4675|8809->4676|8990->4828|9020->4829|9103->4883|9133->4884|9168->4891|9197->4892
                    LINES: 27->1|29->2|29->2|29->3|29->3|29->4|29->4|29->5|29->5|29->6|29->6|29->7|29->7|29->8|29->8|29->9|29->9|29->10|29->10|29->11|29->11|36->1|37->2|38->3|39->4|40->5|41->6|42->7|43->8|44->9|45->10|46->17|47->18|49->20|49->20|52->23|52->23|54->25|54->25|56->27|56->27|56->27|57->28|57->28|57->28|57->28|57->28|57->28|57->28|57->28|58->29|62->33|62->33|64->35|64->35|64->35|65->36|65->36|65->36|65->36|65->36|65->36|65->36|65->36|66->37|69->40|69->40|69->40|69->40|76->47|76->47|76->47|76->47|77->48|77->48|78->49|78->49|78->49|80->51|80->51|80->51|81->52|81->52|81->52|81->52|81->52|81->52|81->52|81->52|81->52|81->52|81->52|81->52|82->53|84->55|84->55|84->55|86->57|86->57|87->58|91->62|91->62|92->63|92->63|97->68|97->68|97->68|97->68|103->74|103->74|104->75|104->75|104->75|116->87|116->87|118->89|118->89|120->91|120->91|125->96|125->96|126->97|126->97|127->98|127->98|130->101|130->101|136->107|136->107|138->109|138->109|144->115|144->115|146->117|146->117|147->118|147->118
                    -- GENERATED --
                */
            