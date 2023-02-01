package com.instagram.instaModule.service;

import com.instagram.instaModule.repository.SignUpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignUpService {
    @Autowired
    SignUpRepository signUpRepository;
    public void signUpApi(String email, String password, String profileId) {
        signUpRepository.signUpApi(email,password,profileId);
    }
}
