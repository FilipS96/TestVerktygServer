package repository;

import java.util.List;
import models.Student;
import org.hibernate.Session;

public class StudentRepository {
    
    
    //hämta student
    public Student getStudent(int userId) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Student student = (Student) session.get(Student.class, userId);
        session.close();
        return student;
    }
    
    //hämta Studenter
    public List<Student> getStudents(){
        Session session = NewHibernateUtil.getSession();
        session.beginTransaction();
        List<Student> students = session.createCriteria(Student.class).list();
        for(Student sName : students){
            sName.getUserName();
            sName.getPassword();
        }
        return students;
    }
    
}
