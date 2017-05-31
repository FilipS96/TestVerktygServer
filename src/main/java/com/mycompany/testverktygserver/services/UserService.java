package com.mycompany.testverktygserver.services;

import com.mycompany.testverktygserver.models.Student;
import com.mycompany.testverktygserver.models.Teacher;
import com.mycompany.testverktygserver.models.User;
import com.mycompany.testverktygserver.repository.UserRepository;

public class UserService {
    UserRepository userRepo;
    
    public UserService() {
        userRepo = new UserRepository();
    }
    
    public User login(String userName, String password) {
        Student student = userRepo.loginStudents(userName, password);
        if (student != null) {
            return student;
        }
        Teacher teacher = userRepo.loginTeachers(userName, password);
        return teacher;
    }
    
}
