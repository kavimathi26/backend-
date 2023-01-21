package com.instagram.instaModule.resource;

import com.instagram.instaModule.model.Like;
import com.instagram.instaModule.repository.LikeDetails;
import com.instagram.instaModule.repository.PostDetails;
import com.instagram.instaModule.repository.UserDetails;
import com.instagram.instaModule.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LikeController {

    @Autowired
    LikeService likeService;
    @Autowired
    LikeDetails likeDetails;
    @Autowired
    UserDetails userDetails;
    @Autowired
    PostDetails postDetails;
    @PutMapping("/like/profileId/{profileId}/postId/{postId}") //post-like
    public String likePost(@PathVariable String profileId, @PathVariable String postId) {
        if(userDetails.getUserByProfileId(profileId)== null) {
            System.out.println(postDetails.getPostByPostId(postId));
            return "no user for the given id";
        } else if (postDetails.getPostByPostId(postId)==null){
            return "no post found";
        }
            return likeService.likePost(profileId,postId);
    }
    @PutMapping("/unlike/profileId/{profileId}/postId/{postId}") //post-unlike
    public String unLikePost(@PathVariable String profileId, @PathVariable String postId) {
        if(userDetails.getUserByProfileId(profileId)== null) {
            System.out.println(postDetails.getPostByPostId(postId));
            return "no user for the given id";
        } else if (postDetails.getPostByPostId(postId)==null){
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
