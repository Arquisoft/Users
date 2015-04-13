package controllers;

import java.util.Map;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

import models.User;
import play.*;
import play.data.Form;
import play.libs.Json;
import play.mvc.*;
import play.mvc.Http.*;
import views.html.*;

public class API extends Controller {

    public static Result showUsersJson() {
        return ok(Json.toJson(User.all()));
    }

    public static Result showUsersJsonHATEOAS() {
    	JsonNodeFactory factory = JsonNodeFactory.instance;
        ArrayNode result = new ArrayNode(factory);
        for (User user: User.all()) {
          ObjectNode countryJson = Json.newObject();
          countryJson.put("email", user.email);
          countryJson.put("password", user.password);
          ArrayNode links = new ArrayNode(factory);
          ObjectNode self = Json.newObject();
          self.put("rel", "self");
          self.put("href", routes.API.showUserJsonHATEOAS(user.id).absoluteURL(request()));
          
          links.add(self);
          countryJson.put("links", links);
          result.add(countryJson);
        }
        return ok(result);
    }

    public static Result showUserJsonHATEOAS(Long id) {
    	JsonNodeFactory factory = JsonNodeFactory.instance;
    	
    	User user = User.findById(id);
        ObjectNode userJson = Json.newObject();
        userJson.put("email", user.email);
        userJson.put("password", user.password);
        ArrayNode links = new ArrayNode(factory);
        ObjectNode self = Json.newObject();
        self.put("rel", "self");
        self.put("href", routes.API.showUserJsonHATEOAS(user.id).absoluteURL(request()));
        links.add(self);
         
        ObjectNode parent = Json.newObject();
        parent.put("rel", "parent");
        parent.put("href", routes.API.showUsersJsonHATEOAS().absoluteURL(request()));
        links.add(parent);

        userJson.put("links", links);
    	return ok(userJson);
    }
    
    public static Result showUserJson(Long id) {
        return ok(Json.toJson(User.findById(id)));
    }

    public static Result newUser() {
    	User user = userForm.bindFromRequest().get();
    	user.save();
    	return redirect(routes.Application.showUsers());
    }
    
    public static Result updateUser(Long id) {
    	User user = userForm.bindFromRequest().get();
    	User.create(user);
        return redirect(routes.Application.showUsers());
    }

    public static Result deleteUser(Long id) {
    	User.delete(id);
        return redirect(routes.Application.showUsers());
    }
    
    static Form<User>  	  userForm     = Form.form(User.class);
}
