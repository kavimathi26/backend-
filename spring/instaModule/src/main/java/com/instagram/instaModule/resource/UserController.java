package com.instagram.instaModule.resource;

import com.instagram.instaModule.model.Users;
import com.instagram.instaModule.service.PostService;
import com.instagram.instaModule.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import com.instagram.instaModule.repository.UserRepository;

import java.util.List;

@RestController
@RequestMapping("user")
@CrossOrigin("*")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    PostService postService;
    @Autowired

    UserRepository userRepository;
    Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/userId/{userId}")
    public Users getUserById(@PathVariable String userId) throws Exception {
        logger.trace("Log level: TRACE");
        logger.info("Log leve   l: INFO");
        logger.debug("Log level: DEBUG");
        logger.error("Log level: ERROR");
        logger.warn("Log level: WARN");
        return userService.getUserByProfileId(userId);
    }
    @GetMapping("/userName/{userName}")
//    @PreAuthorize("hasAuthority('ROLE_USER')")
    public Users getUserByName(@PathVariable String userName) throws Exception {
        return userService.getUserByProfileName(userName);
    }
    @GetMapping
//    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<Users> findAll() {
        return userRepository.findAll();
    }
    @PostMapping
    public String createUser(@RequestBody Users users) throws Exception {
        if(userRepository.getUserByProfileId(users.getProfileId())!=null) {
            return "user exists";
        }
        else {
            userService.createUser(users);
            return users.getProfileId() + "id created";
        }
    }

//    @PutMapping("/profileId/{profileId}")
//    public User updateUser(@PathVariable User user) throws Exception {
//        return userService.updateUser(user.getProfileId());
////        return user;
//    }
@PutMapping("/profileId/{profileId}/name/{name}/description/{description}")
public Users updateUser(@PathVariable String profileId, @PathVariable String name, @PathVariable String description) throws Exception {
    userService.updateUser(profileId, name, description);
    return getUserById(profileId);
}
}