package com.mycompany.testverktygserver.resources;

import com.mycompany.testverktygserver.models.CompletedTest;
import com.mycompany.testverktygserver.models.Course;
import com.mycompany.testverktygserver.models.Test;
import com.mycompany.testverktygserver.services.CourseService;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/courses")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CourseResource {
    

    CourseService courseService = new CourseService();
    
    @GET
    public List<Course> getCourse(){
        return courseService.getCourse();
    }
    /*    @GET
    public List<Course> getTests(){
        return courseService.getTests();
    }
    */
    
    @POST
    @Path("/test")
    public void addTests(Test test){
        courseService.addTests(test);
    }
    
    @POST
    @Path("/completedTest")
    public void addCompTests(CompletedTest CompTest){
        courseService.addCompTest(CompTest);
    }
    
}