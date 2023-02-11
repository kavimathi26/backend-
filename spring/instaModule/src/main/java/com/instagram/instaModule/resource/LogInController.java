package com.instagram.instaModule.resource;

import com.instagram.instaModule.model.SignUp;
import com.instagram.instaModule.repository.LogInRepository;
import com.instagram.instaModule.service.LogInService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LogInController {

    @Autowired
    LogInService logInService;
//    @Autowired
//    LogInRepository logInRepository;
    @GetMapping("/{email}")
    public String logIn(@PathVariable String email, @RequestParam String password){
           return logInService.logIn(email,password);
    }
}
