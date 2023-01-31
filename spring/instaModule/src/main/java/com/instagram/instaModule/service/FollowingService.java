package com.instagram.instaModule.service;

import com.instagram.instaModule.repository.FollowingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FollowingService {
    @Autowired
    FollowingRepository followingRepository;
    public void addFollowing(String profileId,String tobefollowprofileid) {
        followingRepository.addInitialData(profileId);
        followingRepository.addFollowing(profileId,tobefollowprofileid);
    }

    public void displayFollowing(String profileid) {
        followingRepository.displayFollowing(profileid);
    }
}
