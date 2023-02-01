package com.instagram.instaModule.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "InstaSignUP")
@Getter
@Setter
public class LogIn {
    public String email;
    public String password;
}
