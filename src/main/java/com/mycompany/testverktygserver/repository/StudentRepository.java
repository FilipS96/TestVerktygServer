package com.mycompany.testverktygserver.repository;

import com.mycompany.testverktygserver.models.CompletedTest;
import java.util.List;
import com.mycompany.testverktygserver.models.Student;
import org.hibernate.Session;

public class StudentRepository {
    
    public Student getStudent(int userId) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Student student = (Student) session.get(Student.class, userId);
        return student;
    }
    
    public List<Student> getStudents(){
        Session session = NewHibernateUtil.getSession();
        session.beginTransaction();
        List<Student> students = session.createCriteria(Student.class).list();
        return students;
    }

    public void addCompletedTest(Student studentToAddTestTo, CompletedTest completedTest) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        completedTest.setStudent(studentToAddTestTo);
        session.save(completedTest);
        session.getTransaction().commit();
        session.close();
    }
    
}
