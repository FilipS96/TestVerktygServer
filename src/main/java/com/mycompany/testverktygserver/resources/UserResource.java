package com.mycompany.testverktygserver.resources;

import com.mycompany.testverktygserver.models.Teacher;
import com.mycompany.testverktygserver.services.UserService;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {
    UserService userService;
    
    public UserResource() {
        userService = new UserService();
    }
    
    @GET
    @Path("/{userName}/{password}")
    public Teacher login(@PathParam("userName") String userName, @PathParam("password") String password) {
        System.out.println("wohoo: " + userName + " " + password);
        Teacher teacher = userService.login(userName, password);
        return teacher;
    }
}
