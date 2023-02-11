package com.instagram.instaModule.repository;

import com.instagram.instaModule.model.Following;
import com.instagram.instaModule.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

@Repository
public class FollowingRepository {
    @Autowired
    UserRepository userRepository;
    @Autowired
    MongoTemplate mongoTemplate;
//    @Autowired
//    User user;
    public Following getProfileByProfileId(String profileId) {
        return mongoTemplate.findOne(Query.query(Criteria.where("profileId").is(profileId)),Following.class);
    }
    public void addInitialData(String profileId) {

        Query query = new Query().addCriteria(Criteria.where("profileId").is(profileId));
        if(mongoTemplate.findOne(query, Following.class)==null) {
            System.out.println(mongoTemplate.findOne(query, Following.class));
            Following following = new Following(profileId);
            following.setProfileId(profileId);
            mongoTemplate.save(following);
        }
        Users users = userRepository.getUserByProfileId(profileId);
        users.setFollowingCount(getProfileByProfileId(profileId).getFollowingList().size());
        mongoTemplate.save(users);
    }

    public void addFollowing(String profileId,String tobefollowprofileid) {
        Query query = new Query().addCriteria(Criteria.where("profileId").is(profileId));
        Update update = new Update();
        update.set("profileId",profileId);
        update.addToSet("followingList",tobefollowprofileid);
        mongoTemplate.findAndModify(query, update, Following.class);
    }

    public void displayFollowing(String profileId) {
        System.out.println(mongoTemplate.find(Query.query(Criteria.where("profileId").is(profileId)), Following.class));
    }


}
