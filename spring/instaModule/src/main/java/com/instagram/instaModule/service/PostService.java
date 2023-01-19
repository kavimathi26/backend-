package com.instagram.instaModule.service;

import com.instagram.instaModule.model.Post;
import com.instagram.instaModule.model.User;
import com.instagram.instaModule.repository.PostDetails;
import com.instagram.instaModule.repository.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PostService {
    @Autowired
    PostDetails postDetails;
    public void createPost(String profileId, String posts) {
        postDetails.createPost(profileId,posts);
    }

    public String deletePost(String postId) {
        postDetails.deletePost(postId);
        return "deleted";
    }
}
