package com.instagram.instaModule.repository;
import com.instagram.instaModule.model.Post;
import com.instagram.instaModule.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PostDetails {
    @Autowired
    private MongoTemplate mongoTemplate;
    public List<Post> getPostsByProfileId(String profileId) {
        return mongoTemplate.find(Query.query(Criteria.where("profileId").is(profileId)),Post.class);
    }

    public long countOfPosts(String profileId) {
        User user = new User();
        Post post = new Post();
        post.setProfileId(profileId);
        user.setPostCount(getPostsByProfileId(profileId).size());
        System.out.println("count of post : "+user.getPostCount());
        return user.getPostCount();
    }
    public Post createPost(String profileId,String posts) { //add-post
    Post post = new Post();
    post.setProfileId(profileId);
    post.setPosts(posts);
    post.setPostUploadedTime(System.currentTimeMillis());
    System.out.println(post.getPostUploadedTime());
    mongoTemplate.save(post);
    countOfPosts(profileId);
    return post;
    }
    public List<Post> findAll() {
        Query query = new Query();
        return mongoTemplate.find(query, Post.class);
    }
    public void deletePost(String postId) {
        String profileId = mongoTemplate.findById(postId,Post.class).getProfileId();
        mongoTemplate.remove(Query.query(Criteria.where("postId").is(postId)), Post.class);
        System.out.println("after deletion: "+profileId);
        countOfPosts(profileId);
    }
    public List getTopPosts() {
        Query query = new Query();
        query.limit(5);
        query.with(Sort.by(Sort.Direction.DESC, "postUploadedTime"));
        return mongoTemplate.find(query,Post.class);
    }
}
