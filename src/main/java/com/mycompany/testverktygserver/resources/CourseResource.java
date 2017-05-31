package com.mycompany.testverktygserver.resources;

import com.mycompany.testverktygserver.models.CompletedTest;
import com.mycompany.testverktygserver.models.Course;
import com.mycompany.testverktygserver.models.Test;
import com.mycompany.testverktygserver.services.CourseService;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/courses")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CourseResource {
    CourseService courseService = new CourseService();
    
    @GET
    public List<Course> getCourses(){
        return courseService.getCourses();
    }
    
    @POST
    @Path("/{courseId}/tests")
    public void addTests(Test test){
        courseService.addTests(test);
    }
}