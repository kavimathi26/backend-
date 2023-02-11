package com.instagram.instaModule.resource;

import com.instagram.instaModule.repository.UserRepository;
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
    UserRepository userRepository;
    @Autowired
    FollowerService followerService;

    @PutMapping("/profileId/{profileId}/follower/{profileIdToBeFollowed}")
    public String addFollower(@PathVariable String profileId, @PathVariable String profileIdToBeFollowed) {
        if (userRepository.getUserByProfileId(profileId) == null || userRepository.getUserByProfileId(profileIdToBeFollowed) == null) {
            return "no Profiles to follow";
        } else {
            followerService.addFollower(profileId, profileIdToBeFollowed);
        }
        return "follower added";
    }
}
