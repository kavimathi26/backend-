package com.instagram.instaModule.resource;

import com.instagram.instaModule.service.UserService;
import com.instagram.instaModule.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.instagram.instaModule.repository.UserDetails;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    UserDetails userDetails;
    @GetMapping("/userId/{userId}")
    public User getUserById(@PathVariable String userId) throws Exception {
        return userService.getUserByProfileId(userId);
    }
    @GetMapping("/userName/{userName}")
    public User getUserByName(@PathVariable String userName) throws Exception {
        return userService.getUserByProfileName(userName);
    }
    @GetMapping
    public List<User> findAll() {
        return userDetails.findAll();
    }
    @PostMapping
    public String createUser(@RequestBody User user) throws Exception {
        userService.createUser(user);
        return "User with user-id " + user.getProfileId() + " created";
    }

}