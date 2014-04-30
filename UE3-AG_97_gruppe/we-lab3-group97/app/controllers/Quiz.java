package controllers;

import play.*;
import play.mvc.*;
import views.html.*;

public class Quiz extends Controller {

    public static Result authentication() {
        return ok(authentication.render());
    }

}
