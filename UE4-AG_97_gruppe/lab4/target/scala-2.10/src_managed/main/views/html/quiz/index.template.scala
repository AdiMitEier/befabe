
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
object index extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply():play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](_display_(Seq[Any](/*1.2*/main("main.quiz",
      pageid = "welcomepage",
      navigation = immutable.Map(routes.Authentication.logout.url -> "login.logout"))/*3.86*/ {_display_(Seq[Any](format.raw/*3.88*/("""
	<section role="main" id="quiz">
		"""),_display_(Seq[Any](/*5.4*/helper/*5.10*/.form(routes.Quiz.newGame)/*5.36*/ {_display_(Seq[Any](format.raw/*5.38*/("""
			<input id="startgame" type="submit" value=""""),_display_(Seq[Any](/*6.48*/Messages("quiz.start"))),format.raw/*6.70*/(""""/>
		""")))})),format.raw/*7.4*/("""
    </section>
""")))})))}
    }
    
    def render(): play.api.templates.HtmlFormat.Appendable = apply()
    
    def f:(() => play.api.templates.HtmlFormat.Appendable) = () => apply()
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sat May 24 20:03:41 CEST 2014
                    SOURCE: C:/Users/Gruim/Bernd/Studium/WebEngineering/befabe/UE4-AG_97_gruppe/lab4/app/views/quiz/index.scala.html
                    HASH: 66caf2282df8638b913d777751fab58bbd0c6d06
                    MATRIX: 895->1|1038->136|1077->138|1150->177|1164->183|1198->209|1237->211|1321->260|1364->282|1402->290
                    LINES: 30->1|32->3|32->3|34->5|34->5|34->5|34->5|35->6|35->6|36->7
                    -- GENERATED --
                */
            