package com.instagram.instaModule.resource;

import com.instagram.instaModule.repository.UserDetails;
import com.instagram.instaModule.service.FollowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/addFollower")
public class FollowerController {
    @Autowired
    UserDetails userDetails;
    @Autowired
    FollowerService followerService;

    @PutMapping("/profileId/{profileId}/follower/{profileIdToBeFollowed}")
    public String addFollower(@PathVariable String profileId, @PathVariable String profileIdToBeFollowed) {
        if (userDetails.getUserByProfileId(profileId) == null || userDetails.getUserByProfileId(profileIdToBeFollowed) == null) {
            return "no Profiles to follow";
        } else {
            followerService.addFollower(profileId, profileIdToBeFollowed);
        }
        return "follower added";
    }
}
