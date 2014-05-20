
package views.html

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
object authentication extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(form: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.21*/("""
"""),_display_(Seq[Any](/*2.2*/main(title = "login.login",
      pageid = "loginpage",
      navigation = immutable.Map(routes.Registration.index.url -> "registration.to-registration"))/*4.99*/ {_display_(Seq[Any](format.raw/*4.101*/("""
	<section role="main">
		"""),_display_(Seq[Any](/*6.4*/if(flash.contains("registration.successful"))/*6.49*/ {_display_(Seq[Any](format.raw/*6.51*/("""
		    <p class="registration.successful">
		        """),_display_(Seq[Any](/*8.12*/Messages(flash.get("registration.successful")))),format.raw/*8.58*/("""
		    </p>
		""")))})),format.raw/*10.4*/("""
		<section id="login" aria-labelledby="loginheading">
			"""),_display_(Seq[Any](/*12.5*/helper/*12.11*/.form(routes.Authentication.authenticate)/*12.52*/ {_display_(Seq[Any](format.raw/*12.54*/("""
				<fieldset>
					<legend id="loginheading">"""),_display_(Seq[Any](/*14.33*/Messages("login.login"))),format.raw/*14.56*/("""</legend>
					<label for="userName">"""),_display_(Seq[Any](/*15.29*/Messages("user.name"))),format.raw/*15.50*/(""":</label>
					<input id="userName" name="userName" type="text" required="required" value=""""),_display_(Seq[Any](/*16.83*/form("userName")/*16.99*/.value)),format.raw/*16.105*/(""""/>
					<label for="password">"""),_display_(Seq[Any](/*17.29*/Messages("user.pwd"))),format.raw/*17.49*/(""":</label>
					<input id="password" name="password" type="password" required="required"/>
					<input id="loginsubmit" type="submit" value=""""),_display_(Seq[Any](/*19.52*/Messages("login.do-login"))),format.raw/*19.78*/(""""/>
				</fieldset>
				"""),_display_(Seq[Any](/*21.6*/if(form.hasGlobalErrors)/*21.30*/ {_display_(Seq[Any](format.raw/*21.32*/("""
				   	<p class="error">
				       	"""),_display_(Seq[Any](/*23.14*/Messages(form.globalError.message))),format.raw/*23.48*/("""
				   	</p>
				""")))})),format.raw/*25.6*/("""
			""")))})),format.raw/*26.5*/("""
		</section>
		<section id="register" aria-labelledby="registerheading">
		    <h2 id="registerheading" class="accessibility">"""),_display_(Seq[Any](/*29.55*/Messages("registration.registration"))),format.raw/*29.92*/("""</h2>
		    <p>"""),_display_(Seq[Any](/*30.11*/Messages("registration.not-registered"))),format.raw/*30.50*/("""</p>
			<a href=""""),_display_(Seq[Any](/*31.14*/routes/*31.20*/.Registration.index)),format.raw/*31.39*/("""">"""),_display_(Seq[Any](/*31.42*/Messages("registration.to-registration"))),format.raw/*31.82*/("""</a>
		</section>
	</section>
""")))})),format.raw/*34.2*/("""
"""))}
    }
    
    def render(form:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(form)
    
    def f:((DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (form) => apply(form)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue May 20 10:09:04 CEST 2014
                    SOURCE: /home/bernd/Dropbox/Studium/Web Engineering/befabe/UE4-AG_97_gruppe/lab4/app/views/authentication.scala.html
                    HASH: 9d167b1e1fc22760770cf1ea5b6f2c0f4c1448cf
                    MATRIX: 814->1|927->20|963->22|1125->176|1165->178|1226->205|1279->250|1318->252|1407->306|1474->352|1520->367|1614->426|1629->432|1679->473|1719->475|1803->523|1848->546|1922->584|1965->605|2093->697|2118->713|2147->719|2215->751|2257->771|2434->912|2482->938|2542->963|2575->987|2615->989|2691->1029|2747->1063|2797->1082|2833->1087|2997->1215|3056->1252|3108->1268|3169->1307|3223->1325|3238->1331|3279->1350|3318->1353|3380->1393|3442->1424
                    LINES: 27->1|30->1|31->2|33->4|33->4|35->6|35->6|35->6|37->8|37->8|39->10|41->12|41->12|41->12|41->12|43->14|43->14|44->15|44->15|45->16|45->16|45->16|46->17|46->17|48->19|48->19|50->21|50->21|50->21|52->23|52->23|54->25|55->26|58->29|58->29|59->30|59->30|60->31|60->31|60->31|60->31|60->31|63->34
                    -- GENERATED --
                */
            