package com.instagram.instaModule.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString
@Document(collection = "InstaSignUP")
public class SignUp {
    private String emailId;
    private String password;
    private String profileId;
}
