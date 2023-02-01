package com.instagram.instaModule.repository;

import com.instagram.instaModule.model.SignUp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SignUpRepository {
    @Autowired
    MongoTemplate mongoTemplate;
    public void signUpApi(String email, String password, String profileId) {
        SignUp signUp = new SignUp();
        signUp.setEmailId(email);
        signUp.setPassword(password);
        signUp.setProfileId(profileId);
        mongoTemplate.save(signUp);
    }
}
