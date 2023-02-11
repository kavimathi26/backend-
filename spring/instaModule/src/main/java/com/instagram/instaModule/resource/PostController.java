package com.instagram.instaModule.resource;

import com.instagram.instaModule.model.Post;
import com.instagram.instaModule.repository.PostRepository;
import com.instagram.instaModule.repository.UserRepository;
import com.instagram.instaModule.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    PostRepository postRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    PostService postService;
    @PostMapping("/{profileId}")
    public String createPost(@PathVariable String profileId,@RequestParam String posts, @RequestParam String caption) {
        if(userRepository.getUserByProfileId(profileId)== null) {
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
