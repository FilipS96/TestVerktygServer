package services;

import java.util.List;
import models.Teacher;
import repository.TeacherRepository;

public class TeacherService {
    
    TeacherRepository teacherDB;
    
    public TeacherService(){
    teacherDB = new TeacherRepository();
}
     //Get Teacher
    public Teacher getTeacher(int userId){
        return teacherDB.getTeacher(userId);
    }
    //Get Teachers
    public List<Teacher> getTeachers(String userName, String password){
        return teacherDB.getTeachers();
    }
    
    
    
}
