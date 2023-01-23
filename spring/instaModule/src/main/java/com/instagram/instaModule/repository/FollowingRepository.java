package com.instagram.instaModule.repository;

import com.instagram.instaModule.model.Following;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class FollowingRepository {
    @Autowired
    UserDetails userDetails;
    @Autowired
    MongoTemplate mongoTemplate;
    public void addFollowing(String profileId) {
    userDetails.getUserByProfileId(profileId).setFollowersCount(1);

    }

    public void displayFollowing(String profileid) {
//        Following following = new Following();
        System.out.println(mongoTemplate.find(Query.query(Criteria.where("profileid").is(profileid)), Following.class));
    }
}
