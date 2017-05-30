package com.mycompany.testverktygserver.resources;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.mycompany.testverktygserver.models.Teacher;
import com.mycompany.testverktygserver.services.TeacherService;

@Path("/teacher")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TeacherResource {
    TeacherService teacherService = new TeacherService();
    
    @GET
    @Path("/userId")
    public Teacher getTeacher(@PathParam("userId")int userId){
        return teacherService.getTeacher(userId);
    }
            
    @GET
    @Path("/{user}/{password}")
    public List<Teacher> getTeachers(@PathParam("user")String userName,
            @PathParam("password") String password){
        return teacherService.getTeachers(userName, password);
    };
    
    


}
