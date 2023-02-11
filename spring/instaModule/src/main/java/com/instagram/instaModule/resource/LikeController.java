package com.instagram.instaModule.resource;

import com.instagram.instaModule.repository.LikeRepository;
import com.instagram.instaModule.repository.PostRepository;
import com.instagram.instaModule.repository.UserRepository;
import com.instagram.instaModule.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LikeController {

    @Autowired
    LikeService likeService;
    @Autowired
    LikeRepository likeDetails;
    @Autowired
    UserRepository userRepository;
    @Autowired
    PostRepository postRepository;
    @PutMapping("/like/profileId/{profileId}/postId/{postId}") //post-like
    public String likePost(@PathVariable String profileId, @PathVariable String postId) {
        if(userRepository.getUserByProfileId(profileId)== null) {
            System.out.println(postRepository.getPostByPostId(postId));
            return "no user for the given id";
        } else if (postRepository.getPostByPostId(postId)==null){
            return "no post found";
        }
            return likeService.likePost(profileId,postId);
    }
    @PutMapping("/unlike/profileId/{profileId}/postId/{postId}") //post-unlike
    public String unLikePost(@PathVariable String profileId, @PathVariable String postId) {
        if(userRepository.getUserByProfileId(profileId)== null) {
            System.out.println(postRepository.getPostByPostId(postId));
            return "no user for the given id";
        } else if (postRepository.getPostByPostId(postId)==null){
            return "no post found";
        }
        return likeService.unLikePost(profileId,postId);
//        System.out.println(likeDetails.getUserByProfileAndPost(profileId,postId));
//        return "unliked";
    }

    @GetMapping("/postId/{postId}")
    public List getPost(@PathVariable String postId) {
        return likeService.getPost(postId);
    }
}
