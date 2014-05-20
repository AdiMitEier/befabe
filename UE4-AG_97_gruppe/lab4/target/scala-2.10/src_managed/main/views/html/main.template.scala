
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
object main extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template4[String,String,immutable.Map[String, String],Html,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(title: String, pageid: String, navigation: immutable.Map[String, String] = immutable.Map())(content: Html):play.api.templates.HtmlFormat.Appendable = {
        _display_ {
def /*26.2*/asListOfLinks/*26.15*/(map: immutable.Map[String, String]):play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*26.55*/("""
	<ul>
		"""),_display_(Seq[Any](/*28.4*/map/*28.7*/.map/*28.11*/ {case (link, label) =>_display_(Seq[Any](format.raw/*28.34*/(""" <li><a href=""""),_display_(Seq[Any](/*28.49*/link)),format.raw/*28.53*/("""">"""),_display_(Seq[Any](/*28.56*/Messages(label))),format.raw/*28.71*/("""</a></li> """)))})),format.raw/*28.82*/("""
	<ul>
""")))};
Seq[Any](format.raw/*1.109*/("""
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang=""""),_display_(Seq[Any](/*4.55*/lang/*4.59*/.code)),format.raw/*4.64*/("""" lang=""""),_display_(Seq[Any](/*4.73*/lang/*4.77*/.code)),format.raw/*4.82*/("""">
    <head>
        <meta charset="utf-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>"""),_display_(Seq[Any](/*8.17*/Messages("main.big"))),format.raw/*8.37*/(""" - """),_display_(Seq[Any](/*8.41*/Messages(title))),format.raw/*8.56*/("""</title>
        <link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*9.54*/routes/*9.60*/.Assets.at("stylesheets/main.css"))),format.raw/*9.94*/("""">
        <script src=""""),_display_(Seq[Any](/*10.23*/routes/*10.29*/.Assets.at("javascripts/framework.js"))),format.raw/*10.67*/("""" type="text/javascript"></script>
        <script src=""""),_display_(Seq[Any](/*11.23*/routes/*11.29*/.Assets.at("javascripts/jquery-1.9.0.min.js"))),format.raw/*11.74*/("""" type="text/javascript"></script>
    </head>
    <body id=""""),_display_(Seq[Any](/*13.16*/pageid)),format.raw/*13.22*/("""">
        <header role="banner" aria-labelledby="mainheading">
            <h1 id="mainheading"><span class="accessibility">"""),_display_(Seq[Any](/*15.63*/Messages("main.big"))),format.raw/*15.83*/("""</span> """),_display_(Seq[Any](/*15.92*/Messages("main.quiz"))),format.raw/*15.113*/("""</h1>
        </header>
        <nav role="navigation" aria-labelledby="navheading">
            <h2 id="navheading" class="accessibility">"""),_display_(Seq[Any](/*18.56*/Messages("navigation.heading"))),format.raw/*18.86*/("""</h2>
            """),_display_(Seq[Any](/*19.14*/asListOfLinks(navigation))),format.raw/*19.39*/("""
        </nav>
        """),_display_(Seq[Any](/*21.10*/content)),format.raw/*21.17*/("""
        <footer role="contentinfo">© 2014 """),_display_(Seq[Any](/*22.44*/Messages("main.big-abbrev"))),format.raw/*22.71*/(""" """),_display_(Seq[Any](/*22.73*/Messages("main.quiz"))),format.raw/*22.94*/("""</footer>
    </body>
</html>

"""))}
    }
    
    def render(title:String,pageid:String,navigation:immutable.Map[String, String],content:Html): play.api.templates.HtmlFormat.Appendable = apply(title,pageid,navigation)(content)
    
    def f:((String,String,immutable.Map[String, String]) => (Html) => play.api.templates.HtmlFormat.Appendable) = (title,pageid,navigation) => (content) => apply(title,pageid,navigation)(content)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue May 20 10:09:04 CEST 2014
                    SOURCE: /home/bernd/Dropbox/Studium/Web Engineering/befabe/UE4-AG_97_gruppe/lab4/app/views/main.scala.html
                    HASH: f4bf618800350978d6d25c0f13695bad5dabc2f2
                    MATRIX: 841->1|1026->1322|1048->1335|1169->1375|1214->1385|1225->1388|1238->1392|1299->1415|1350->1430|1376->1434|1415->1437|1452->1452|1495->1463|1543->108|1688->218|1700->222|1726->227|1770->236|1782->240|1808->245|1986->388|2027->408|2066->412|2102->427|2199->489|2213->495|2268->529|2329->554|2344->560|2404->598|2497->655|2512->661|2579->706|2677->768|2705->774|2867->900|2909->920|2954->929|2998->950|3174->1090|3226->1120|3281->1139|3328->1164|3389->1189|3418->1196|3498->1240|3547->1267|3585->1269|3628->1290
                    LINES: 27->1|29->26|29->26|31->26|33->28|33->28|33->28|33->28|33->28|33->28|33->28|33->28|33->28|36->1|39->4|39->4|39->4|39->4|39->4|39->4|43->8|43->8|43->8|43->8|44->9|44->9|44->9|45->10|45->10|45->10|46->11|46->11|46->11|48->13|48->13|50->15|50->15|50->15|50->15|53->18|53->18|54->19|54->19|56->21|56->21|57->22|57->22|57->22|57->22
                    -- GENERATED --
                */
            