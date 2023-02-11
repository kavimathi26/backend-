package com.instagram.instaModule.repository;

//import com.instagram.instaModule.Entity.UserInfo;
import com.instagram.instaModule.model.SignUp;
import com.instagram.instaModule.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

@Repository
public class SignUpRepository {
    @Autowired
    MongoTemplate mongoTemplate;
//    @Autowired
//    private UserInfoRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public SignUp getUserByUserNameInSignUp(String userName) {
        return mongoTemplate.findOne(Query.query(Criteria.where("userName").is(userName)), SignUp.class);
    }

    public Users getUserByUserName(String userName) {
        return mongoTemplate.findOne(Query.query(Criteria.where("userName").is(userName)), Users.class);
    }

//    public void signUpApi(String email, String password, String profileId, String userName) {
public void signUpApi(SignUp signUp) {
//        signUp.setProfileId(profileId);
        mongoTemplate.save(signUp);
    }
}
