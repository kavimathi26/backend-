package com.instagram.instaModule.repository;

import com.instagram.instaModule.model.SignUp;
import com.instagram.instaModule.service.LogInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class LogInRepository {
@Autowired
private MongoTemplate mongoTemplate;
//@Autowired
//    LogInService logInService;
    public String logIn(String email, String password) {
        if(mongoTemplate.findOne(Query.query(Criteria.where("emailId").is(email).and("password").is(password)), SignUp.class)!=null) {
            System.out.println(mongoTemplate.find(Query.query(Criteria.where("emailId").is(email).and("password").is(password)), SignUp.class));
//            return "Logged in to the account "+email;
            return ""+mongoTemplate.findOne(Query.query(Criteria.where("emailId").is(email).and("password").is(password)), SignUp.class);
        }
//        else {
//            return "enter correct credentials";
//        }
        else
        {
            return "invalid credentials";
        }
    }
}
