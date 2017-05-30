package services;

import java.util.List;
import models.CompletedTest;
import models.Course;
import models.Test;
import repository.CourseRepository;

public class CourseService {
    
    CourseRepository courseDB;
    
    public CourseService(){
        courseDB = new CourseRepository();
    }
    //Hämta lista av Kurser
    public List<Course> getCourse(){
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
