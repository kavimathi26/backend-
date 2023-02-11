package com.instagram.instaModule.model;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.crypto.password.PasswordEncoder;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "InstaSignUP")

public class SignUp {
//    @Autowired
//    PasswordEncoder passwordEncoder;
//    private String emailId;
//    private String profileId;
    private String userName;
//    private String description;
//    private long followersCount;
//    private long followingCount;
//    private long postCount;
    private String password;
    private String roles;
//    private String profileId;
}
