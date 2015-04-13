package controllers;

import java.util.Map;

import models.User;
import play.*;
import play.data.Form;
import play.mvc.*;
import play.mvc.Http.*;
import views.html.*;

public class API extends Controller {

    public static Result showUsers() {
        return ok(users.render(User.all(),userForm));
    }

    public static Result showUser(Long id) {
        return ok(user.render(User.findById(id)));
    }

    public static Result newUser() {
    	User user = userForm.bindFromRequest().get();
    	user.save();
    	return redirect(routes.API.showUsers());
    }
    
    public static Result updateUser(Long id) {
        return internalServerError("Not implemented: update user " + id);
    }

    public static Result deleteUser(Long id) {
    	User.delete(id);
        return redirect(routes.API.showUsers());
    }
    
    static Form<User>  	  userForm     = Form.form(User.class);
}
