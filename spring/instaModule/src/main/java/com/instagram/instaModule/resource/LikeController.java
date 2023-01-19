package com.instagram.instaModule.resource;

import com.instagram.instaModule.model.Like;
import com.instagram.instaModule.repository.LikeDetails;
import com.instagram.instaModule.repository.UserDetails;
//import com.instagram.instaModule.service.LikeService;
import com.instagram.instaModule.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/like")
public class LikeController {

    @Autowired
    UserDetails userDetails;
    @Autowired
    PostService postService;
    @Autowired
    LikeDetails likeDetails;
//    @Autowired
//    LikeService likeService;
    @PostMapping("/like/profileId/{profileId}/postId/{postId}")
    public Like likePost(@PathVariable String profileId, @PathVariable String postId) {
//    likeDetails.getPostByPostId(postId);
        return likeDetails.likePost(profileId,postId);
    }
    @PostMapping("/unlike/profileId/{profileId}/postId/{postId}")
    public Like unLikePost(@PathVariable String profileId, @PathVariable String postId) {
        return likeDetails.unLikePost(profileId,postId);
    }
    @GetMapping("/postId/{postId}")
    public List getPost(@PathVariable String postId) {
        return likeDetails.getPost(postId);
    }
}
