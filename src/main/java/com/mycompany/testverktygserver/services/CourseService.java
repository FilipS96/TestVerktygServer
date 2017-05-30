package com.mycompany.testverktygserver.services;

import com.mycompany.testverktygserver.models.CompletedTest;
import com.mycompany.testverktygserver.models.Course;
import com.mycompany.testverktygserver.models.Test;
import com.mycompany.testverktygserver.repository.CourseRepository;
import java.util.List;

public class CourseService {
        
    CourseRepository courseDB;
    
    public CourseService(){
        courseDB = new CourseRepository();
    }
    //Hämta lista av Kurser
    public List<Course> getCourses(){
        return courseDB.getCourses();
    }
    //Hämta Test
    public List<Course> getTests(){
        return courseDB.getTests();
    }
    //Skriva nytt Test
    public void addTests(Test test){
        courseDB.addTest(test);
    }
    //Skriva färdigt Test
    public void addCompTest(CompletedTest CompTest){
        courseDB.addCompTest(CompTest);
    }
    
}
