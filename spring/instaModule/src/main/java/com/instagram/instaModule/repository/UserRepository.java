package com.instagram.instaModule.repository;


import com.instagram.instaModule.model.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public class UserRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    public Users getUserByProfileId(String profileId) {
        return mongoTemplate.findOne(Query.query(Criteria.where("profileId").is(profileId)), Users.class);
    }

    public Users getUserByUserName(String userName) {
        return mongoTemplate.findOne(Query.query(Criteria.where("userName").is(userName)), Users.class);
    }
    public List<Users> findAll() {
        Query query = new Query();
        return mongoTemplate.find(query, Users.class);
    }
//    public List<Post> findAll("post") {
//
//    }

    public Users createUser(Users users) {
        mongoTemplate.save(users);
        return users;
    }
    public Users updateUser(String profileId, String name, String description) {
        Users users = new Users();
        Query query = new Query().addCriteria(Criteria.where("profileId").is(profileId));
        Update update = new Update();
        update.set("userName", name);
        update.set("description",description);
        return mongoTemplate.findAndModify(query, update, Users.class);

    }


    public void deleteById(String profileId) {
        mongoTemplate.remove(Query.query(Criteria.where("profileId").is(profileId)), Users.class);
    }

    public List<Users> deleteByName(String userName) {
        mongoTemplate.remove(Query.query(Criteria.where("userName").is(userName)), Users.class);
        return Collections.emptyList();
    }
}