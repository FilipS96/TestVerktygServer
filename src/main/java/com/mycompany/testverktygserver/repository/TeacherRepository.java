package com.mycompany.testverktygserver.repository;

import java.util.List;
import com.mycompany.testverktygserver.models.Student;
import com.mycompany.testverktygserver.models.Teacher;
import org.hibernate.Session;

public class TeacherRepository {
    
    //hämta lärare
    public Teacher getTeacher(int userId) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Teacher teacher = (Teacher) session.get(Teacher.class, userId);
        session.close();
        return teacher;
    }
    
    //hämta fler Lärare
    public List<Teacher> getTeachers(){
        Session session = NewHibernateUtil.getSession();
        session.beginTransaction();
        List<Teacher> teachers = session.createCriteria(Teacher.class).list();
        for(Teacher tName : teachers){
            tName.getUserName();
            tName.getPassword();
        }
        return teachers;
    }
   
}
