package com.instagram.instaModule.service;

import com.instagram.instaModule.model.Users;
import com.instagram.instaModule.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public Users getUserByProfileId(String userId) {
        return userRepository.getUserByProfileId(userId);
    }
    public Users getUserByProfileName(String userName) {
        return userRepository.getUserByUserName(userName);
    }
    public void createUser(Users users)  {
        userRepository.createUser(users);

    }

    public Users updateUser(String profileId, String name, String description) {
    return userRepository.updateUser(profileId, name, description);
    }


}