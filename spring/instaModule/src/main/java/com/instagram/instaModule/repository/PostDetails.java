package com.instagram.instaModule.repository;
import com.instagram.instaModule.model.Post;
import com.instagram.instaModule.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

@Repository
public class PostDetails {
    @Autowired
    private MongoTemplate mongoTemplate;
    public List<Post> getPostsByProfileId(String profileId) {
        return mongoTemplate.find(Query.query(Criteria.where("profileId").is(profileId)),Post.class);
    }
    public Post createPost(String profileId,String posts) { //add-post
    Post post = new Post();
    User user = new User();
    post.setProfileId(profileId);
    post.setPosts(posts);
    post.setPostUploadedTime(System.currentTimeMillis());
    System.out.println(post.getPostUploadedTime());
    mongoTemplate.save(post);
    user.setPostCount(getPostsByProfileId(profileId).stream().count());
//    user.setPostCount(getPostsByProfileId(profileId).size());
    System.out.println(user.getPostCount());
    return post;
    }
    public List<Post> findAll() {
        Query query = new Query();
        return mongoTemplate.find(query, Post.class);
    }
    public void deletePost(String postId) {
        mongoTemplate.remove(Query.query(Criteria.where("postId").is(postId)), Post.class);
    }
    public List getTopPosts() {
        Query query = new Query();
        query.with(Sort.by(Sort.Direction.DESC, "postUploadedTime"));
        return mongoTemplate.find(query,Post.class);
    }
}
