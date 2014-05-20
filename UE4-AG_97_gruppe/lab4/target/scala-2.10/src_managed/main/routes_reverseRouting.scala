// @SOURCE:/home/bernd/Dropbox/Studium/Web Engineering/befabe/UE4-AG_97_gruppe/lab4/conf/routes
// @HASH:2f2bf6583c725f7cc2e8d48e65c92c354ad2096b
// @DATE:Tue May 20 10:09:03 CEST 2014

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString


// @LINE:22
// @LINE:20
// @LINE:19
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:13
// @LINE:12
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
// @LINE:5
// @LINE:4
package controllers {

// @LINE:22
class ReverseAssets {
    

// @LINE:22
def at(file:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                                                
    
}
                          

// @LINE:8
// @LINE:7
// @LINE:6
// @LINE:5
class ReverseAuthentication {
    

// @LINE:6
def logout(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "logout")
}
                                                

// @LINE:8
def authenticate(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "authenticate")
}
                                                

// @LINE:7
// @LINE:5
def login(): Call = {
   () match {
// @LINE:5
case () if true => Call("GET", _prefix + { _defaultPrefix } + "login")
                                                        
// @LINE:7
case () if true => Call("GET", _prefix + { _defaultPrefix } + "authenticate")
                                                        
   }
}
                                                
    
}
                          

// @LINE:20
// @LINE:19
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:13
// @LINE:12
class ReverseQuiz {
    

// @LINE:16
def roundResult(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "quiz/round")
}
                                                

// @LINE:13
def newGame(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "quiz")
}
                                                

// @LINE:20
def addAnswer(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "quiz/answer")
}
                                                

// @LINE:15
def question(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "quiz/question")
}
                                                

// @LINE:19
def endResult(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "quiz/result")
}
                                                

// @LINE:17
def newRound(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "quiz/round")
}
                                                

// @LINE:12
def index(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "quiz")
}
                                                
    
}
                          

// @LINE:10
// @LINE:9
class ReverseRegistration {
    

// @LINE:10
def create(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "registration")
}
                                                

// @LINE:9
def index(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "registration")
}
                                                
    
}
                          

// @LINE:4
class ReverseApplication {
    

// @LINE:4
def index(): Call = {
   Call("GET", _prefix)
}
                                                
    
}
                          
}
                  


// @LINE:22
// @LINE:20
// @LINE:19
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:13
// @LINE:12
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
// @LINE:5
// @LINE:4
package controllers.javascript {

// @LINE:22
class ReverseAssets {
    

// @LINE:22
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        
    
}
              

// @LINE:8
// @LINE:7
// @LINE:6
// @LINE:5
class ReverseAuthentication {
    

// @LINE:6
def logout : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Authentication.logout",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "logout"})
      }
   """
)
                        

// @LINE:8
def authenticate : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Authentication.authenticate",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "authenticate"})
      }
   """
)
                        

// @LINE:7
// @LINE:5
def login : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Authentication.login",
   """
      function() {
      if (true) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "login"})
      }
      if (true) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "authenticate"})
      }
      }
   """
)
                        
    
}
              

// @LINE:20
// @LINE:19
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:13
// @LINE:12
class ReverseQuiz {
    

// @LINE:16
def roundResult : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Quiz.roundResult",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "quiz/round"})
      }
   """
)
                        

// @LINE:13
def newGame : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Quiz.newGame",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "quiz"})
      }
   """
)
                        

// @LINE:20
def addAnswer : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Quiz.addAnswer",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "quiz/answer"})
      }
   """
)
                        

// @LINE:15
def question : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Quiz.question",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "quiz/question"})
      }
   """
)
                        

// @LINE:19
def endResult : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Quiz.endResult",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "quiz/result"})
      }
   """
)
                        

// @LINE:17
def newRound : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Quiz.newRound",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "quiz/round"})
      }
   """
)
                        

// @LINE:12
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Quiz.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "quiz"})
      }
   """
)
                        
    
}
              

// @LINE:10
// @LINE:9
class ReverseRegistration {
    

// @LINE:10
def create : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Registration.create",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "registration"})
      }
   """
)
                        

// @LINE:9
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Registration.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "registration"})
      }
   """
)
                        
    
}
              

// @LINE:4
class ReverseApplication {
    

// @LINE:4
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + """"})
      }
   """
)
                        
    
}
              
}
        


// @LINE:22
// @LINE:20
// @LINE:19
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:13
// @LINE:12
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
// @LINE:5
// @LINE:4
package controllers.ref {


// @LINE:22
class ReverseAssets {
    

// @LINE:22
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """""", _prefix + """assets/$file<.+>""")
)
                      
    
}
                          

// @LINE:8
// @LINE:7
// @LINE:6
// @LINE:5
class ReverseAuthentication {
    

// @LINE:6
def logout(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Authentication.logout(), HandlerDef(this, "controllers.Authentication", "logout", Seq(), "GET", """""", _prefix + """logout""")
)
                      

// @LINE:8
def authenticate(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Authentication.authenticate(), HandlerDef(this, "controllers.Authentication", "authenticate", Seq(), "POST", """""", _prefix + """authenticate""")
)
                      

// @LINE:5
def login(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Authentication.login(), HandlerDef(this, "controllers.Authentication", "login", Seq(), "GET", """""", _prefix + """login""")
)
                      
    
}
                          

// @LINE:20
// @LINE:19
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:13
// @LINE:12
class ReverseQuiz {
    

// @LINE:16
def roundResult(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Quiz.roundResult(), HandlerDef(this, "controllers.Quiz", "roundResult", Seq(), "GET", """""", _prefix + """quiz/round""")
)
                      

// @LINE:13
def newGame(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Quiz.newGame(), HandlerDef(this, "controllers.Quiz", "newGame", Seq(), "POST", """""", _prefix + """quiz""")
)
                      

// @LINE:20
def addAnswer(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Quiz.addAnswer(), HandlerDef(this, "controllers.Quiz", "addAnswer", Seq(), "POST", """""", _prefix + """quiz/answer""")
)
                      

// @LINE:15
def question(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Quiz.question(), HandlerDef(this, "controllers.Quiz", "question", Seq(), "GET", """""", _prefix + """quiz/question""")
)
                      

// @LINE:19
def endResult(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Quiz.endResult(), HandlerDef(this, "controllers.Quiz", "endResult", Seq(), "GET", """""", _prefix + """quiz/result""")
)
                      

// @LINE:17
def newRound(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Quiz.newRound(), HandlerDef(this, "controllers.Quiz", "newRound", Seq(), "POST", """""", _prefix + """quiz/round""")
)
                      

// @LINE:12
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Quiz.index(), HandlerDef(this, "controllers.Quiz", "index", Seq(), "GET", """""", _prefix + """quiz""")
)
                      
    
}
                          

// @LINE:10
// @LINE:9
class ReverseRegistration {
    

// @LINE:10
def create(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Registration.create(), HandlerDef(this, "controllers.Registration", "create", Seq(), "POST", """""", _prefix + """registration""")
)
                      

// @LINE:9
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Registration.index(), HandlerDef(this, "controllers.Registration", "index", Seq(), "GET", """""", _prefix + """registration""")
)
                      
    
}
                          

// @LINE:4
class ReverseApplication {
    

// @LINE:4
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.index(), HandlerDef(this, "controllers.Application", "index", Seq(), "GET", """""", _prefix + """""")
)
                      
    
}
                          
}
        
    