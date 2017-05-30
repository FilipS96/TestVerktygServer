package repository;

import java.util.List;
import models.CompletedTest;
import models.Course;
import models.Test;
import org.hibernate.Session;

public class CourseRepository {
    
    //Hämta kurs och prov
    public List<Course> getCourses(){
        Session session = NewHibernateUtil.getSession();
        session.beginTransaction();
        List<Course> courses = session.createCriteria(Course.class).list();
        for(Course cName : courses) {
            cName.getName().toString(); 
            cName.getTests().size(); 
        }
        return courses;
    }
    
    //hämta test
    public List<Course> getTests(){
        Session session = NewHibernateUtil.getSession();
        session.beginTransaction();
        List<Course> courses = session.createCriteria(Course.class).list();
        for(Course cTest : courses) {
            cTest.getTests().size();
        }
        return courses;
    }
    
    //skriva nytt test
    public void addTest(Test test) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(test);
        session.getTransaction().commit();
        session.close();
    }
    
    //skriva färdigt prov
    public void addCompTest(CompletedTest CompTest) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(CompTest);
        session.getTransaction().commit();
        session.close();
    }
    
}
