
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
object registration extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[models.QuizUser],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(form: Form[models.QuizUser]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.31*/("""
"""),_display_(Seq[Any](/*2.2*/main(title = "registration.register",
      pageid = "registerpage",
      navigation = immutable.Map(routes.Authentication.login.url -> "login.login"))/*4.84*/ {_display_(Seq[Any](format.raw/*4.86*/("""
	<section role="main" id="register" aria-labelledby="registerheading">
		<h2 id="registerheading" class="accessibility">"""),_display_(Seq[Any](/*6.51*/Messages("registration.register"))),format.raw/*6.84*/("""</h2>
		"""),_display_(Seq[Any](/*7.4*/helper/*7.10*/.form(routes.Registration.create)/*7.43*/ {_display_(Seq[Any](format.raw/*7.45*/("""
	    	<fieldset>
	        	<legend>"""),_display_(Seq[Any](/*9.20*/Messages("registration.personal-data"))),format.raw/*9.58*/("""</legend>
	        	<label for="firstName">"""),_display_(Seq[Any](/*10.35*/Messages("user.first-name"))),format.raw/*10.62*/(""":</label>
	        	<input id="firstName" name="firstName" type="text" value=""""),_display_(Seq[Any](/*11.70*/form("firstName")/*11.87*/.value)),format.raw/*11.93*/(""""/>
	        	"""),_display_(Seq[Any](/*12.12*/for(error <- form("firstName").errors) yield /*12.50*/ {_display_(Seq[Any](format.raw/*12.52*/("""
	        		<div id="error_msg_firstName" class="error" role="alert">
	        			"""),_display_(Seq[Any](/*14.14*/Messages(error.message))),format.raw/*14.37*/("""
	        		</div>
				""")))})),format.raw/*16.6*/("""
	                
	        	<label for="lastName">"""),_display_(Seq[Any](/*18.34*/Messages("user.last-name"))),format.raw/*18.60*/(""":</label>
	        	<input id="lastName" name="lastName" type="text" value=""""),_display_(Seq[Any](/*19.68*/form("lastName")/*19.84*/.value)),format.raw/*19.90*/(""""/>
	        	"""),_display_(Seq[Any](/*20.12*/for(error <- form("lastName").errors) yield /*20.49*/ {_display_(Seq[Any](format.raw/*20.51*/("""
	        		<div id="error_msg_lastName" class="error" role="alert">
	        			"""),_display_(Seq[Any](/*22.14*/Messages(error.message))),format.raw/*22.37*/("""
	        		</div>
				""")))})),format.raw/*24.6*/("""
	                
	        	<label for="birthDate">"""),_display_(Seq[Any](/*26.35*/Messages("user.birth-date"))),format.raw/*26.62*/(""":</label>
	        	<input id="birthDate" name="birthDate" type="date" value=""""),_display_(Seq[Any](/*27.70*/form("birthDate")/*27.87*/.value)),format.raw/*27.93*/(""""/>
	        	"""),_display_(Seq[Any](/*28.12*/for(error <- form("birthDate").errors) yield /*28.50*/ {_display_(Seq[Any](format.raw/*28.52*/("""
	        		<div id="error_msg_birthDate" class="error" role="alert">
	        			"""),_display_(Seq[Any](/*30.14*/Messages(error.message))),format.raw/*30.37*/("""
	        		</div>
				""")))})),format.raw/*32.6*/("""
	                
	        	<label for="gender">"""),_display_(Seq[Any](/*34.32*/Messages("user.gender"))),format.raw/*34.55*/(""":</label>
	        	<select id="gender" name="gender">
	        		<option value="male">"""),_display_(Seq[Any](/*36.34*/Messages("user.gender.male"))),format.raw/*36.62*/("""</option>
	        		<option value="female">"""),_display_(Seq[Any](/*37.36*/Messages("user.gender.female"))),format.raw/*37.66*/("""</option>
	        	</select>
	       	</fieldset>
	        <fieldset>
	        	<legend>"""),_display_(Seq[Any](/*41.20*/Messages("registration.login-data"))),format.raw/*41.55*/("""</legend>
	        	<label for="userName">"""),_display_(Seq[Any](/*42.34*/Messages("user.name"))),format.raw/*42.55*/("""*:</label>
	        	<input id="userName" name="userName" type="text" required="required" pattern="\w"""),format.raw/*43.91*/("""{"""),format.raw/*43.92*/("""4,8"""),format.raw/*43.95*/("""}"""),format.raw/*43.96*/(""""  value=""""),_display_(Seq[Any](/*43.107*/form("userName")/*43.123*/.value)),format.raw/*43.129*/(""""/>
	        	"""),_display_(Seq[Any](/*44.12*/for(error <- form("userName").errors) yield /*44.49*/ {_display_(Seq[Any](format.raw/*44.51*/("""
	        		<div id="error_msg_username" class="error" role="alert">
	        			"""),_display_(Seq[Any](/*46.14*/Messages(error.message))),format.raw/*46.37*/("""
	        		</div>
				""")))})),format.raw/*48.6*/("""
	                
	        	<label for="password">"""),_display_(Seq[Any](/*50.34*/Messages("user.pwd"))),format.raw/*50.54*/("""*:</label>
	        	<input id="password" name="password" type="password" required="required" pattern="\w"""),format.raw/*51.95*/("""{"""),format.raw/*51.96*/("""4,8"""),format.raw/*51.99*/("""}"""),format.raw/*51.100*/(""""/>
	        	"""),_display_(Seq[Any](/*52.12*/for(error <- form("password").errors) yield /*52.49*/ {_display_(Seq[Any](format.raw/*52.51*/("""
				    <div id="error_msg_password" class="error" role="alert">
	        			"""),_display_(Seq[Any](/*54.14*/Messages(error.message))),format.raw/*54.37*/("""
	        		</div>
				""")))})),format.raw/*56.6*/("""
	        	
	        	<input id="registersubmit" type="submit" value=""""),_display_(Seq[Any](/*58.60*/Messages("registration.register"))),format.raw/*58.93*/(""""/>
	        	<p id="requiredhint">"""),_display_(Seq[Any](/*59.33*/Messages("user.mandatory-info"))),format.raw/*59.64*/("""</p>
	        </fieldset>
	    """)))})),format.raw/*61.7*/("""
	</section>
""")))})))}
    }
    
    def render(form:Form[models.QuizUser]): play.api.templates.HtmlFormat.Appendable = apply(form)
    
    def f:((Form[models.QuizUser]) => play.api.templates.HtmlFormat.Appendable) = (form) => apply(form)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sat May 24 20:03:41 CEST 2014
                    SOURCE: C:/Users/Gruim/Bernd/Studium/WebEngineering/befabe/UE4-AG_97_gruppe/lab4/app/views/registration.scala.html
                    HASH: ecf138738428edaa50a44b3b7fea86307ba67859
                    MATRIX: 822->1|945->30|982->33|1144->187|1183->189|1342->313|1396->346|1440->356|1454->362|1495->395|1534->397|1608->436|1667->474|1748->519|1797->546|1913->626|1939->643|1967->649|2019->665|2073->703|2113->705|2234->790|2279->813|2336->839|2426->893|2474->919|2588->997|2613->1013|2641->1019|2693->1035|2746->1072|2786->1074|2906->1158|2951->1181|3008->1207|3099->1262|3148->1289|3264->1369|3290->1386|3318->1392|3370->1408|3424->1446|3464->1448|3585->1533|3630->1556|3687->1582|3775->1634|3820->1657|3946->1747|3996->1775|4078->1821|4130->1851|4260->1945|4317->1980|4397->2024|4440->2045|4570->2147|4599->2148|4630->2151|4659->2152|4707->2163|4733->2179|4762->2185|4814->2201|4867->2238|4907->2240|5027->2324|5072->2347|5129->2373|5219->2427|5261->2447|5395->2553|5424->2554|5455->2557|5485->2558|5537->2574|5590->2611|5630->2613|5747->2694|5792->2717|5849->2743|5958->2816|6013->2849|6086->2886|6139->2917|6204->2951
                    LINES: 27->1|30->1|31->2|33->4|33->4|35->6|35->6|36->7|36->7|36->7|36->7|38->9|38->9|39->10|39->10|40->11|40->11|40->11|41->12|41->12|41->12|43->14|43->14|45->16|47->18|47->18|48->19|48->19|48->19|49->20|49->20|49->20|51->22|51->22|53->24|55->26|55->26|56->27|56->27|56->27|57->28|57->28|57->28|59->30|59->30|61->32|63->34|63->34|65->36|65->36|66->37|66->37|70->41|70->41|71->42|71->42|72->43|72->43|72->43|72->43|72->43|72->43|72->43|73->44|73->44|73->44|75->46|75->46|77->48|79->50|79->50|80->51|80->51|80->51|80->51|81->52|81->52|81->52|83->54|83->54|85->56|87->58|87->58|88->59|88->59|90->61
                    -- GENERATED --
                */
            