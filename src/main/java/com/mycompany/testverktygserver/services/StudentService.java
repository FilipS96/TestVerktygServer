package com.mycompany.testverktygserver.services;

import com.mycompany.testverktygserver.models.CompletedTest;
import java.util.List;
import com.mycompany.testverktygserver.models.Student;
import com.mycompany.testverktygserver.repository.StudentRepository;

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
    public List<Student> getStudents(){
        return studentDB.getStudents();
    }

    public void addCompletedTest(int userId, CompletedTest completedTest) {
        Student studentToAddTestTo = getStudent(userId);
        studentDB.addCompletedTest(studentToAddTestTo, completedTest);
    }
    
    
}
