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
@Document(collection = "InstaFollower")
public class Follower {
    public Follower(String profileId) {
        this.profileId = profileId;
        this.followerList = new ArrayList<>();
    }
    private String profileId;
    private List<String> followerList;
}
