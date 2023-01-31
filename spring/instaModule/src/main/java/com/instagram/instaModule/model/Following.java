package com.instagram.instaModule.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@ToString
@Document(collection = "InstaFollowing")
public class Following {
    public Following(String profileId) {
        this.profileId=profileId;
        this.followingList=new ArrayList<>();
    }
    private String profileId;
    private List<String> followingList;
}
