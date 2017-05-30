package services;

import java.util.List;
import models.Student;
import repository.StudentRepository;

public class StudentService {
    
    StudentRepository studentDB;
    
    public StudentService(){
    studentDB = new StudentRepository();
}
    //Get Student
    public Student getStudent(int userId){
        return studentDB.getStudent(userId);
    }
    //Get Students
    public List<Student> getStudents(String userName, String password){
        return studentDB.getStudents();
    }
    
    
}
