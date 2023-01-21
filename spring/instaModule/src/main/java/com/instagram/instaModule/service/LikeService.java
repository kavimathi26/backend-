package com.instagram.instaModule.service;

import com.instagram.instaModule.model.Like;
import com.instagram.instaModule.repository.LikeDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeService {
    @Autowired
    LikeDetails likeDetails;
    public String likePost(String profileId, String postId) {
//        if((likeDetails.getAndSetPost(profileId,postId).isLikedOrNot()==false)) {
        likeDetails.setLikesWithProfileIdAndPostId(profileId,postId);
            likeDetails.likePost(profileId, postId);
//            return "hi";
//        }
//        else {
            return "liked";
//        }
    }

    public String unLikePost(String profileId, String postId) {
//        if((likeDetails.getAndSetPost(profileId,postId).isLikedOrNot()==false)){
//            return "You haven't liked this post to unlike it";
//        }
//        else {
//        likeDetails.getUserByProfileAndPost(profileId,postId);
                   likeDetails.unLikePost(profileId, postId);
        return "Unliked";

//            return "Post unliked";
//        }
    }

    public List getPost(String postId) {
        return likeDetails.getPost(postId);
    }
}
