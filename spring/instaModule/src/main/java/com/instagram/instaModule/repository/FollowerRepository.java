package com.instagram.instaModule.repository;
//package com.instagram.instaModule.repository.FollowerRepository;
import com.instagram.instaModule.model.Follower;
import com.instagram.instaModule.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import com.instagram.instaModule.model.User;
@Repository
public class FollowerRepository {
    @Autowired
    MongoTemplate mongoTemplate;
//    @Autowired
//    User user;
    @Autowired
    UserDetails userDetails;
    public Follower getUserByProfileId(String profileId) {
        return mongoTemplate.findOne(Query.query(Criteria.where("profileId").is(profileId)), Follower.class);
    }
    public void addInitialData(String profileId) {

        Query query = new Query().addCriteria(Criteria.where("profileId").is(profileId));
        if (mongoTemplate.findOne(query, Follower.class) == null) {
            System.out.println(mongoTemplate.findOne(query, Follower.class));
            Follower follower = new Follower(profileId);
//            User user = new User();
            follower.setProfileId(profileId);
            mongoTemplate.save(follower);
        }
        User user = userDetails.getUserByProfileId(profileId);
        user.setFollowersCount(getUserByProfileId(profileId).getFollowerList().size());
        System.out.println(getUserByProfileId(profileId).getFollowerList().size());
        System.out.println(user.getFollowersCount());
        mongoTemplate.save(user);
    }
    public void addFollower(String profileId, String profileIdToBeFollowed) {
        Query query = new Query().addCriteria(Criteria.where("profileId").is(profileId));
        Update update = new Update();
        update.set("profileId",profileId);
        update.addToSet("followerList",profileIdToBeFollowed);
        mongoTemplate.findAndModify(query, update, Follower.class);
    }
}
