package com.mycompany.testverktygserver.services;

import com.mycompany.testverktygserver.models.CompletedTest;
import java.util.List;
import com.mycompany.testverktygserver.models.Student;
import com.mycompany.testverktygserver.repository.StudentRepository;
import com.mycompany.testverktygserver.repository.UserRepository;

public class StudentService {
    
    StudentRepository studentDB;
    UserRepository userRepo;
    
    public StudentService(){
    studentDB = new StudentRepository();
    userRepo = new UserRepository();
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

    public Student login(String userName, String password) {
        return userRepo.loginStudents(userName, password);
    }
}
