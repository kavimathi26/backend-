package com.instagram.instaModule.resource;

import com.instagram.instaModule.service.PostService;
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
    PostService postService;
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
        if(userDetails.getUserByProfileId(user.getProfileId())!=null) {
            return "user exists";
        }
        else {
            userService.createUser(user);
            return user.getProfileId() + "id created";
        }
    }
//    @PutMapping("/profileId/{profileId}")
//    public User updateUser(@PathVariable User user) throws Exception {
//        return userService.updateUser(user.getProfileId());
////        return user;
//    }
@PutMapping("/profileId/{profileId}/name/{name}/description/{description}")
public User updateUser(@PathVariable String profileId, @PathVariable String name, @PathVariable String description) throws Exception {
    userService.updateUser(profileId, name, description);
    return getUserById(profileId);
}
}