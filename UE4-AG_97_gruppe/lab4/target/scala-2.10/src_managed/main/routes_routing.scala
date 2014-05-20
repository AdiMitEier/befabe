// @SOURCE:/home/bernd/Dropbox/Studium/Web Engineering/befabe/UE4-AG_97_gruppe/lab4/conf/routes
// @HASH:2f2bf6583c725f7cc2e8d48e65c92c354ad2096b
// @DATE:Tue May 20 10:09:03 CEST 2014


import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString

object Routes extends Router.Routes {

private var _prefix = "/"

def setPrefix(prefix: String) {
  _prefix = prefix
  List[(String,Routes)]().foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" }


// @LINE:4
private[this] lazy val controllers_Application_index0 = Route("GET", PathPattern(List(StaticPart(Routes.prefix))))
        

// @LINE:5
private[this] lazy val controllers_Authentication_login1 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("login"))))
        

// @LINE:6
private[this] lazy val controllers_Authentication_logout2 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("logout"))))
        

// @LINE:7
private[this] lazy val controllers_Authentication_login3 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("authenticate"))))
        

// @LINE:8
private[this] lazy val controllers_Authentication_authenticate4 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("authenticate"))))
        

// @LINE:9
private[this] lazy val controllers_Registration_index5 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("registration"))))
        

// @LINE:10
private[this] lazy val controllers_Registration_create6 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("registration"))))
        

// @LINE:12
private[this] lazy val controllers_Quiz_index7 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("quiz"))))
        

// @LINE:13
private[this] lazy val controllers_Quiz_newGame8 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("quiz"))))
        

// @LINE:15
private[this] lazy val controllers_Quiz_question9 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("quiz/question"))))
        

// @LINE:16
private[this] lazy val controllers_Quiz_roundResult10 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("quiz/round"))))
        

// @LINE:17
private[this] lazy val controllers_Quiz_newRound11 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("quiz/round"))))
        

// @LINE:19
private[this] lazy val controllers_Quiz_endResult12 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("quiz/result"))))
        

// @LINE:20
private[this] lazy val controllers_Quiz_addAnswer13 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("quiz/answer"))))
        

// @LINE:22
private[this] lazy val controllers_Assets_at14 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
        
def documentation = List(("""GET""", prefix,"""controllers.Application.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """login""","""controllers.Authentication.login()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """logout""","""controllers.Authentication.logout()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """authenticate""","""controllers.Authentication.login()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """authenticate""","""controllers.Authentication.authenticate()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """registration""","""controllers.Registration.index()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """registration""","""controllers.Registration.create()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """quiz""","""controllers.Quiz.index()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """quiz""","""controllers.Quiz.newGame()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """quiz/question""","""controllers.Quiz.question()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """quiz/round""","""controllers.Quiz.roundResult()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """quiz/round""","""controllers.Quiz.newRound()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """quiz/result""","""controllers.Quiz.endResult()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """quiz/answer""","""controllers.Quiz.addAnswer()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]] 
}}
      

def routes:PartialFunction[RequestHeader,Handler] = {

// @LINE:4
case controllers_Application_index0(params) => {
   call { 
        invokeHandler(controllers.Application.index(), HandlerDef(this, "controllers.Application", "index", Nil,"GET", """""", Routes.prefix + """"""))
   }
}
        

// @LINE:5
case controllers_Authentication_login1(params) => {
   call { 
        invokeHandler(controllers.Authentication.login(), HandlerDef(this, "controllers.Authentication", "login", Nil,"GET", """""", Routes.prefix + """login"""))
   }
}
        

// @LINE:6
case controllers_Authentication_logout2(params) => {
   call { 
        invokeHandler(controllers.Authentication.logout(), HandlerDef(this, "controllers.Authentication", "logout", Nil,"GET", """""", Routes.prefix + """logout"""))
   }
}
        

// @LINE:7
case controllers_Authentication_login3(params) => {
   call { 
        invokeHandler(controllers.Authentication.login(), HandlerDef(this, "controllers.Authentication", "login", Nil,"GET", """""", Routes.prefix + """authenticate"""))
   }
}
        

// @LINE:8
case controllers_Authentication_authenticate4(params) => {
   call { 
        invokeHandler(controllers.Authentication.authenticate(), HandlerDef(this, "controllers.Authentication", "authenticate", Nil,"POST", """""", Routes.prefix + """authenticate"""))
   }
}
        

// @LINE:9
case controllers_Registration_index5(params) => {
   call { 
        invokeHandler(controllers.Registration.index(), HandlerDef(this, "controllers.Registration", "index", Nil,"GET", """""", Routes.prefix + """registration"""))
   }
}
        

// @LINE:10
case controllers_Registration_create6(params) => {
   call { 
        invokeHandler(controllers.Registration.create(), HandlerDef(this, "controllers.Registration", "create", Nil,"POST", """""", Routes.prefix + """registration"""))
   }
}
        

// @LINE:12
case controllers_Quiz_index7(params) => {
   call { 
        invokeHandler(controllers.Quiz.index(), HandlerDef(this, "controllers.Quiz", "index", Nil,"GET", """""", Routes.prefix + """quiz"""))
   }
}
        

// @LINE:13
case controllers_Quiz_newGame8(params) => {
   call { 
        invokeHandler(controllers.Quiz.newGame(), HandlerDef(this, "controllers.Quiz", "newGame", Nil,"POST", """""", Routes.prefix + """quiz"""))
   }
}
        

// @LINE:15
case controllers_Quiz_question9(params) => {
   call { 
        invokeHandler(controllers.Quiz.question(), HandlerDef(this, "controllers.Quiz", "question", Nil,"GET", """""", Routes.prefix + """quiz/question"""))
   }
}
        

// @LINE:16
case controllers_Quiz_roundResult10(params) => {
   call { 
        invokeHandler(controllers.Quiz.roundResult(), HandlerDef(this, "controllers.Quiz", "roundResult", Nil,"GET", """""", Routes.prefix + """quiz/round"""))
   }
}
        

// @LINE:17
case controllers_Quiz_newRound11(params) => {
   call { 
        invokeHandler(controllers.Quiz.newRound(), HandlerDef(this, "controllers.Quiz", "newRound", Nil,"POST", """""", Routes.prefix + """quiz/round"""))
   }
}
        

// @LINE:19
case controllers_Quiz_endResult12(params) => {
   call { 
        invokeHandler(controllers.Quiz.endResult(), HandlerDef(this, "controllers.Quiz", "endResult", Nil,"GET", """""", Routes.prefix + """quiz/result"""))
   }
}
        

// @LINE:20
case controllers_Quiz_addAnswer13(params) => {
   call { 
        invokeHandler(controllers.Quiz.addAnswer(), HandlerDef(this, "controllers.Quiz", "addAnswer", Nil,"POST", """""", Routes.prefix + """quiz/answer"""))
   }
}
        

// @LINE:22
case controllers_Assets_at14(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        invokeHandler(controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """""", Routes.prefix + """assets/$file<.+>"""))
   }
}
        
}

}
     