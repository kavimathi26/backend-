package com.instagram.instaModule.service;

import com.instagram.instaModule.repository.FollowerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FollowerService {
    @Autowired
    FollowerRepository followerRepository;
    public void addFollower(String profileId, String profileIdToBeFollowed) {
        followerRepository.addInitialData(profileId);
        followerRepository.addFollower(profileId,profileIdToBeFollowed);
    }
}
