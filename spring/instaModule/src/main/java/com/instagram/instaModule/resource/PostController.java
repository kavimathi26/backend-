package com.instagram.instaModule.resource;

import com.instagram.instaModule.model.Post;
import com.instagram.instaModule.model.User;
import com.instagram.instaModule.repository.PostDetails;
import com.instagram.instaModule.repository.UserDetails;
import com.instagram.instaModule.service.PostService;
import com.instagram.instaModule.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    PostDetails postDetails;
    @Autowired
    UserDetails userDetails;
    @Autowired
    PostService postService;
    @PostMapping("/{profileId}")
    public String createPost(@PathVariable String profileId,@RequestParam String posts, @RequestParam String caption) {
        if(userDetails.getUserByProfileId(profileId)== null) {
            return "no user for the given id";
        }
        postService.createPost(profileId, posts, caption);
        return "created post for " + profileId;
    }
    @GetMapping
    public List<Post> findAll() {
        return postService.findAll();
    }

    @GetMapping("/topPosts/page/{page}/size/{size}")
    public List<Post> getTopPosts(@PathVariable String page, @PathVariable String size) {
        return postService.getTopPosts(page, size);
    }


    @GetMapping("/profileId/{profileId}")//all small letters
//    Page<Post> persons = postRepository.findByName("Alex", PageRequest.of(0, 100));
    public List findAll(@PathVariable String profileId) {
        return postService.getPostsByProfileId(profileId);
    }

    @DeleteMapping("/postId/{postId}")
    public String deletePost(@PathVariable String postId) {
        return postService.deletePost(postId);
    }
    @GetMapping("/topPosts")
    public List getTopPosts() {
        return postService.getAllTopPosts();
    }

}
