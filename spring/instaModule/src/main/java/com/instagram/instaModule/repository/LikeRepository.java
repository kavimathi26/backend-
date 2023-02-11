package com.instagram.instaModule.repository;

import com.instagram.instaModule.model.Like;
import com.instagram.instaModule.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class LikeRepository {
    @Autowired
    MongoTemplate mongoTemplate;
    @Autowired
    PostRepository postRepository;
    public List<Post> getPostByPostId(String postId) {
        return mongoTemplate.find(Query.query(Criteria.where("postId").is(postId)), Post.class);
    }
    public String getProfileId(String postId) {
      return mongoTemplate.findById(postId,Post.class).getProfileId();
    }
    public List getPost(String postId) {
        System.out.println(getPostByPostId(postId));
        return getPostByPostId(postId);
    }

    public List<Like> getUserByProfileAndPost(String profileId, String postId) {
//        return mongoTemplate.findOne(Query.query(Criteria.where("profileId").is(profileId),("postId").is(postId)), User.class);
//        return mongoTemplate.findOne({"profileId":profileId, "postId":postId},User.class);
        return mongoTemplate.find(Query.query(Criteria.where("profileId").is(profileId).and("postId").is(postId)),Like.class);
    }
    public Like getAndSetPost(String profileId, String postId) {
        Like like = new Like();
        like.setPostId(postId);
        like.setProfileId(getProfileId(postId));
        mongoTemplate.save(like);
        System.out.println(like);
        return like;
    }

    public void setLikesWithProfileIdAndPostId(String profileId, String postId) {
        Query query = new Query().addCriteria(Criteria.where("profileId").is(profileId).and("postId").is(postId));
        if(mongoTemplate.findOne(query, Like.class)==null) {
            Like like = new Like();
            like.setPostId(postId);
            like.setProfileId(profileId);
            like.setLikedOrNot(false);
            like.setLikedTime(0);
            like.setUnlikedTime(0);
            mongoTemplate.save(like);
//            return like;
        }
//        else {
//            return
//        }
    }
    public long countLikes(String postId) {
        Query query = new Query().addCriteria(Criteria.where("postId").is(postId).and("likedOrNot").is(true));
        mongoTemplate.find(query,Like.class);
        long len = mongoTemplate.find(query,Like.class).size();
        return len;
    }
    public Like likePost(String profileId, String postId) {
//        Like like = new Like();
//        like.setPostId(postId);
//        like.setProfileId(profileId);
//        like.setLikedOrNot(true);
//        like.isLikedOrNot();
//        like.setLikedTime(System.currentTimeMillis());
//        System.out.println(like);
//        mongoTemplate.save(like);
//        return like;
        Query query = new Query().addCriteria(Criteria.where("profileId").is(profileId).and("postId").is(postId));
        Update update = new Update();
        update.set("profileId",profileId);
        update.set("postId",postId);
        update.set("unlikedTime",0);
        update.set("likedOrNot",true);
        update.set("likedTime",System.currentTimeMillis());
//        Post post = new Post();
//        post.setProfileId(profileId);
//        postDetails.getPostsByProfileId(profileId);
//        Post post = new Post();
//        post.setProfileId(profileId);
//        post.setLikesCount(countLikes(postId));
//        post.setLikesCount();
//        mongoTemplate.save(update);
//        mongoTemplate.save(post);
        return mongoTemplate.findAndModify(query, update, Like.class);
    }
//    public Like unLikePost(String profileId, String postId) {
//        Like like = new Like();
//        like.setPostid(postId);
//        like.setProfileId(profileId);
//        like.setLikedOrNot(false);
//        like.setLikedTime(System.currentTimeMillis());
//        mongoTemplate.save(like);
//        System.out.println(like);
//        return like;
//    }
//    public Like unLikePost(String profileId, String postId) {
//        Like like = new Like();
//        Query query = new Query().addCriteria(Criteria.where("profileId").is(profileId));
//        Update update = new Update();
//        like.setUnlikedTime(System.currentTimeMillis());
//        update.set("likedOrNot",false);
//        System.out.println(like);
//        mongoTemplate.save(like);
//        return mongoTemplate.findAndModify(query, update, Like.class);
//    }
//    public Like findPostLikedOrNotByTheGivenProfileId(String profileId, String postId){
////        Like like = new Like();
//        Query query = new Query().addCriteria(Criteria.where("profileId").is(profileId).and("postId").is(postId));
//        System.out.println("liked Or not : "+mongoTemplate.findOne(query,Like.class));
//        System.out.println("liked? "+mongoTemplate.findOne(query.isLikedOrNot(),Like.class));
//        return mongoTemplate.findOne(query,Like.class);
////        System.out.println(like);
////        return like;
//    }
    public Like unLikePost(String profileId, String postId) {
//        Like like = new Like();
        Query query = new Query().addCriteria(Criteria.where("profileId").is(profileId).and("postId").is(postId));
        Update update = new Update();
        update.set("profileId",profileId);
        update.set("postId",postId);
        update.set("unlikedTime",System.currentTimeMillis());
        update.set("likedOrNot",false);
        update.set("likedTime",0);
        return mongoTemplate.findAndModify(query, update, Like.class);
    }

}