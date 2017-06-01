package com.mycompany.testverktygserver.services;

import com.mycompany.testverktygserver.models.Teacher;
import com.mycompany.testverktygserver.repository.UserRepository;

public class UserService {
    UserRepository userRepo;
    
    public UserService() {
        userRepo = new UserRepository();
    }
    
    public Teacher login(String userName, String password) {
        return userRepo.loginTeachers(userName, password);
    }
    
}
