package com.instagram.instaModule.service;

//import com.instagram.instaModule.Entity.UserInfo;
import com.instagram.instaModule.dto.SignUpRequest;
import com.instagram.instaModule.model.SignUp;
import com.instagram.instaModule.repository.SignUpRepository;
//import com.instagram.instaModule.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SignUpService {
    @Autowired
    SignUpRepository signUpRepository;
//    @Autowired
//    private UserInfoRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    public void signUpApi(SignUp signUp) {
        signUp.setPassword(passwordEncoder.encode(signUp.getPassword()));
        signUpRepository.signUpApi(signUp);
    }
//    public void signUpApi(String email, String password, String profileId, String profileName) {
//        signUpRepository.signUpApi(email,password,profileId,profileName);
//    }

//    public void addUser(UserInfo userInfo) {
//        signUpRepository.addUser(userInfo);
//    }
}
