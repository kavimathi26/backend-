package com.instagram.instaModule.repository;
//package com.instagram.instaModule.repository.FollowerRepository;
import com.instagram.instaModule.model.Follower;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
@Repository
public class FollowerRepository {
    @Autowired
    MongoTemplate mongoTemplate;
    public void addInitialData(String profileId) {

        Query query = new Query().addCriteria(Criteria.where("profileId").is(profileId));
        if (mongoTemplate.findOne(query, Follower.class) == null) {
            System.out.println(mongoTemplate.findOne(query, Follower.class));
            Follower follower = new Follower(profileId);
            follower.setProfileId(profileId);
            mongoTemplate.save(follower);
        }
    }
    public void addFollower(String profileId, String profileIdToBeFollowed) {
        Query query = new Query().addCriteria(Criteria.where("profileId").is(profileId));
        Update update = new Update();
        update.set("profileId",profileId);
        update.push("followerList",profileIdToBeFollowed);
        mongoTemplate.findAndModify(query, update, Follower.class);
    }
}
