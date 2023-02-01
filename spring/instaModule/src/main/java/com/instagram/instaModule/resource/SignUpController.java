package com.instagram.instaModule.resource;

import com.instagram.instaModule.repository.SignUpRepository;
import com.instagram.instaModule.service.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/signup")
public class SignUpController {
    @Autowired
    SignUpRepository signUpRepository;
    @Autowired
    SignUpService signUpService;
    @PostMapping("/{email}")
    public void signUpApi(@PathVariable String email, @RequestParam String password, @RequestParam String profileId) {
        signUpService.signUpApi(email,password,profileId);
    }
}
