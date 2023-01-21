package com.instagram.instaModule.service;

import com.instagram.instaModule.model.Post;
import com.instagram.instaModule.repository.PostDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    @Autowired
    PostDetails postDetails;
    public void createPost(String profileId, String posts, String caption) {
        postDetails.createPost(profileId,posts,caption);
    }

    public String deletePost(String postId) {
        postDetails.deletePost(postId);
        return "deleted";
    }

    public List getAllTopPosts() {
       return postDetails.getAllTopPosts();
    }

    public List getPostsByProfileId(String profileId) {
        return postDetails.getPostsByProfileId(profileId);
    }

    public List<Post> getTopPosts(String page, String size) {
        return postDetails.getTopPosts(page,size);
    }

    public List<Post> findAll() {
        return postDetails.findAll();
    }
}
