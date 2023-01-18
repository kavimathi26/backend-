package com.instagram.instaModule.service;

import com.instagram.instaModule.repository.UserDetails;
import com.instagram.instaModule.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserDetails userDetails;

    public User getUserByProfileId(String userId) {
        return userDetails.getUserByProfileId(userId);
    }
    public User getUserByProfileName(String userName) {
        return userDetails.getUserByUserName(userName);
    }
    public void createUser(User user)  {
        userDetails.createUser(user);

    }

    public User updateUser(String profileId, String name, String description) {
    return userDetails.updateUser(profileId, name, description);
    }


}