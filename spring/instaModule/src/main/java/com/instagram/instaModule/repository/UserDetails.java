package com.instagram.instaModule.repository;


import com.instagram.instaModule.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

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
    public User updateUser(String profileId, String name, String description) {
        User user = new User();
        Query query = new Query().addCriteria(Criteria.where("profileId").is(profileId));
        Update update = new Update();
        update.set("userName", name);
        update.set("description",description);
        return mongoTemplate.findAndModify(query, update, User.class);

    }

    public User createPost(User user) { //add-post
        System.out.println(user.getPostCount());
        user.getPosts().add("new post");
        long c = user.getPostCount();
        c += user.getPosts().size();
        user.setPostCount(c);
        mongoTemplate.save(user);
        return user;
    }
    public void deleteById(String profileId) {
        mongoTemplate.remove(Query.query(Criteria.where("profileId").is(profileId)), User.class);
    }

    public List<User> deleteByName(String userName) {
        mongoTemplate.remove(Query.query(Criteria.where("userName").is(userName)), User.class);
        return Collections.emptyList();
    }
}