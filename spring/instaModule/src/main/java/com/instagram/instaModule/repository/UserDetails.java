package com.instagram.instaModule.repository;


import com.instagram.instaModule.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public class UserDetails {

    @Autowired
    private MongoTemplate mongoTemplate;

    public User getUserByProfileId(String profileId) {
        return mongoTemplate.findOne(Query.query(Criteria.where("profileId").is(profileId)), User.class);
    }

    public User getUserByUserName(String userName) {
        return mongoTemplate.findOne(Query.query(Criteria.where("userName").is(userName)), User.class);
    }
    public List<User> findAll() {
        Query query = new Query();
//        query.addCriteria(Criteria.where("profileId"));
        return mongoTemplate.find(query, User.class);
    }

    public User createUser(User user) {
        mongoTemplate.save(user);
        return user;
    }

    public User update(User user) {
        Query query = new Query();
        query.addCriteria(Criteria.where("profileId").is(user.getProfileId()));
        Update update = new Update();
        update.set("name", user.getUserName());
        update.set("description", user.getDescription());
        return mongoTemplate.findAndModify(Query.query(Criteria.where("profileId").is(user.getProfileId())),
                update, User.class);
    }

    public void deleteById(String profileId) {
        mongoTemplate.remove(Query.query(Criteria.where("profileId").is(profileId)), User.class);
    }

    public List<User> deleteByName(String userName) {
        mongoTemplate.remove(Query.query(Criteria.where("profileId").is(userName)), User.class);
        return Collections.emptyList();
    }
}