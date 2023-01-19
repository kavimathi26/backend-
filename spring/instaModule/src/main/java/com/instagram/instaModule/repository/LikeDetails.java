package com.instagram.instaModule.repository;

import com.instagram.instaModule.model.Like;
import com.instagram.instaModule.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Repository
public class LikeDetails {
    @Autowired
    MongoTemplate mongoTemplate;
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

    public Like getAndSetPost(String profileId, String postId) {
        Like like = new Like();
        like.setPostid(postId);
        like.setProfileId(getProfileId(postId));
//        long c = like.getLikeCount();
//        c += 1;
//        like.setLikeCount(c);
//        return like;
        mongoTemplate.save(like);
        System.out.println(like);
        return like;
    }

    public Like setLikesWithProfileIdAndPostId(String profileId, String postId) {
        Like like = new Like();
        like.setPostid(postId);
        like.setProfileId(profileId);
        return like;
    }
    public Like likePost(String profileId, String postId) {
//        setLikesWithProfileIdAndPostId(profileId,postId);
        Like like = new Like();
        like.setPostid(postId);
        like.setProfileId(profileId);
        like.setLikedOrNot(true);
        like.isLikedOrNot();
        like.setLikedTime(System.currentTimeMillis());
        Set<Object> hashSet = new HashSet<Object>();
//        like = (Object) like;
//        like.setHashSet();
        like.setHashSetLike(hashSet);
        hashSet.add(like.getPostid());
        hashSet.add(like.getProfileId());
        hashSet.add(like.isLikedOrNot());
        System.out.println(like.getClass());
        System.out.println(like.getHashSetLike());
        System.out.println(like);
        mongoTemplate.save(like);
        return like;
    }
    public Like unLikePost(String profileId, String postId) {
        Like like = new Like();
        like.setPostid(postId);
        like.setProfileId(profileId);
        like.setLikedOrNot(false);
        like.setLikedTime(System.currentTimeMillis());
        mongoTemplate.save(like);
        System.out.println(like);
        return like;
    }
}