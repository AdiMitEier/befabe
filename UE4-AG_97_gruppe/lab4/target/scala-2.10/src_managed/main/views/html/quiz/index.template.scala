
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
                    DATE: Tue May 20 10:09:04 CEST 2014
                    SOURCE: /home/bernd/Dropbox/Studium/Web Engineering/befabe/UE4-AG_97_gruppe/lab4/app/views/quiz/index.scala.html
                    HASH: 4c545cb10bc68b693ef7483234b6c9e0ad8cee95
                    MATRIX: 895->1|1036->134|1075->136|1146->173|1160->179|1194->205|1233->207|1316->255|1359->277|1396->284
                    LINES: 30->1|32->3|32->3|34->5|34->5|34->5|34->5|35->6|35->6|36->7
                    -- GENERATED --
                */
            