package com.instagram.instaModule.service;

import com.instagram.instaModule.model.SignUp;
import com.instagram.instaModule.repository.LogInRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogInService {
    @Autowired
    LogInRepository logInRepository;
    public String logIn(String email, String password) {
       return logInRepository.logIn(email,password);
    }
}
