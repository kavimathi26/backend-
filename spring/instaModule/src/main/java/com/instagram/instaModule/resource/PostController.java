package com.instagram.instaModule.resource;

import com.instagram.instaModule.model.Post;
import com.instagram.instaModule.model.User;
import com.instagram.instaModule.repository.PostDetails;
import com.instagram.instaModule.repository.UserDetails;
import com.instagram.instaModule.service.PostService;
import com.instagram.instaModule.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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
        return postDetails.findAll();
    }
    @GetMapping("/profileId/{profileId}")
    public List findAll(@PathVariable String profileId) {
        return postDetails.getPostsByProfileId(profileId);
    }

    @DeleteMapping("/postId/{postId}")
    public String deletePost(@PathVariable String postId) {
        return postService.deletePost(postId);
    }
    @GetMapping("/topPosts")
    public List getTopPosts() {
        return postDetails.getTopPosts();
    }
//    @PostMapping("/postId/{postId}/")
}
