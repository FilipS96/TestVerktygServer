package com.mycompany.testverktygserver.resources;

import com.mycompany.testverktygserver.models.Answer;
import com.mycompany.testverktygserver.models.Course;
import com.mycompany.testverktygserver.models.Question;
import com.mycompany.testverktygserver.models.Test;
import com.mycompany.testverktygserver.services.CourseService;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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
    public List<Course> getCourses(){
        return courseService.getCourses();
    }
    
    @POST
    @Path("/{courseId}/tests")
    public void addTests(@PathParam("courseId") int courseId, Test test){
        courseService.addTests(courseId, test);
    }
    
    @DELETE
    @Path("/{courseId}/tests/{testId}")
    public void deleteTest(@PathParam("testId") int testId) {
        courseService.deleteTest(testId);
    }
    
    @POST
    @Path("/{courseId}/tests/{testId}")
    public void addQuestion(@PathParam("testId") int testId, Question question) {
        courseService.addQuestion(testId, question);
    }
    
    @POST
    @Path("/{courseId}/tests/{testId}/{questionId}")
    public void addAnswer(@PathParam("questionId") int questionId, Answer answer) {
        courseService.addAnswer(questionId, answer);
    }
}