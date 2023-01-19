package com.instagram.instaModule.service;

import com.instagram.instaModule.repository.PostDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
