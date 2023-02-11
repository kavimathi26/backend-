package com.instagram.instaModule.service;

import com.instagram.instaModule.model.Post;
import com.instagram.instaModule.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    @Autowired
    PostRepository postRepository;
    public void createPost(String profileId, String posts, String caption) {
        postRepository.createPost(profileId,posts,caption);
    }

    public String deletePost(String postId) {
        postRepository.deletePost(postId);
        return "deleted";
    }

    public List getAllTopPosts() {
       return postRepository.getAllTopPosts();
    }

    public List getPostsByProfileId(String profileId) {
        return postRepository.getPostsByProfileId(profileId);
    }

    public List<Post> getTopPosts(String page, String size) {
        return postRepository.getTopPosts(page,size);
    }

    public List<Post> findAll() {
        return postRepository.findAll();
    }
}
