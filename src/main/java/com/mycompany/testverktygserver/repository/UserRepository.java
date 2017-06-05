package com.mycompany.testverktygserver.repository;

import com.mycompany.testverktygserver.models.Student;
import com.mycompany.testverktygserver.models.Teacher;
import org.hibernate.Query;
import org.hibernate.Session;

public class UserRepository {

    public Student loginStudents(String userName, String password) {
        Session session = NewHibernateUtil.getSession();
        session.beginTransaction();
        System.out.println("wohoo: ");
        Query query = session.createQuery("from Student where userName = :userName and password = :password")
                .setParameter("userName", userName).setParameter("password", password);
        Student student = (Student) query.uniqueResult();
        session.getTransaction().commit();
        session.close();
        
        return student;
    }

    public Teacher loginTeachers(String userName, String password) {
        Session session = NewHibernateUtil.getSession();
        session.beginTransaction();
        System.out.println("What?" + userName);
        Query query = session.createQuery("from Teacher where userName = :userName and password = :password")
                .setParameter("userName", userName).setParameter("password", password);
        Teacher teacher = (Teacher) query.uniqueResult();
        System.out.println("more what?" + teacher);
        session.getTransaction().commit();
        session.close();
        
        return teacher;
    }
    
}
