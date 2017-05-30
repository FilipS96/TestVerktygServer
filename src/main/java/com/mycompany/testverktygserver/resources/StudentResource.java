package com.mycompany.testverktygserver.resources;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.mycompany.testverktygserver.models.Student;
import com.mycompany.testverktygserver.services.StudentService;

@Path("/students")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class StudentResource {
    StudentService studentService = new StudentService();
    
    @GET
    @Path("/{studentId}")
    public Student getStudent(@PathParam("studentId")int userId){
        return studentService.getStudent(userId);
    }
            
    @GET
    public List<Student> getStudents(){
      return studentService.getStudents();
    }
    
}
    

