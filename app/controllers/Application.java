package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render("Hola"));
    }

    public static Result greeting(String name) {
        return ok(index.render(name));
    }

}
