package com.instagram.instaModule.repository;
import com.instagram.instaModule.model.Post;
import com.instagram.instaModule.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PostDetails {
    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    UserDetails userDetails;
    public List<Post> getPostsByProfileId(String profileId) {
        return mongoTemplate.find(Query.query(Criteria.where("profileId").is(profileId)),Post.class);
    }
    public Post getPostByPostId(String postId) {
//        return mongoTemplate.findOne(Query.query(Criteria.where("profileId").is(profileId)), User.class);
        return mongoTemplate.findOne(Query.query(Criteria.where("postId").is(postId)),Post.class);
    }

    public void countOfPosts(String profileId) {
//        User user = new User();
//        Post post = new Post();
//        post.setProfileId(profileId);
//        user.setPostCount(getPostsByProfileId(profileId).size());
//        System.out.println("count of post : "+user.getPostCount());
//        return user.getPostCount();
        User user = userDetails.getUserByProfileId(profileId);
        user.setPostCount(getPostsByProfileId(profileId).size());
        System.out.println(getPostsByProfileId(profileId).size());
        System.out.println(user.getPostCount());
        mongoTemplate.save(user);
    }
    public Post createPost(String profileId, String posts,String caption) { //add-post
    Post post = new Post();
//    post.setPostId(postId);
    post.setProfileId(profileId);
    post.setPosts(posts);
    post.setCaption(caption);
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
    public List getTopPosts(String page, String size) {
        Query query = new Query();
        query.with(Sort.by(Sort.Direction.DESC, "postUploadedTime"));
        query.skip(Integer.parseInt(page) * Integer.parseInt(size)).limit(Integer.parseInt(size));
        return mongoTemplate.find(query,Post.class);
    }
    public List getAllTopPosts() {
        Query query = new Query();
        query.with(Sort.by(Sort.Direction.DESC, "postUploadedTime"));
        return mongoTemplate.find(query,Post.class);
    }

}
