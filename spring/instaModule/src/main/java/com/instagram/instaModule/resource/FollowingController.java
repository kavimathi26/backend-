package com.instagram.instaModule.resource;

import com.instagram.instaModule.repository.UserRepository;
import com.instagram.instaModule.service.FollowingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/addFollowing")
public class FollowingController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    FollowingService followingService;
    @PutMapping("/profileId/{profileId}/following/{tobefollowprofileid}")
    public String addFollowing(@PathVariable String profileId, @PathVariable String tobefollowprofileid){
        if(userRepository.getUserByProfileId(profileId)!=null && userRepository.getUserByProfileId(tobefollowprofileid)!=null)
        {
            followingService.addFollowing(profileId,tobefollowprofileid);
        }
        else {
            return "No profile found for the given id to follow";
        }
        return "Follower added";
    }
    @GetMapping("/profileid/{profileid}")
    public String displayFollowing(@PathVariable String profileid) {
        if(userRepository.getUserByProfileId(profileid)==null) {
            return "no profile found";
        }
        followingService.displayFollowing(profileid);
        return "The following list is: ";
    }
}
