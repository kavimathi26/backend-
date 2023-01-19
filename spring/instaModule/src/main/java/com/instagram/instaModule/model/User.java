package com.instagram.instaModule.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.awt.*;
import java.util.ArrayList;

@Getter
@Setter
@ToString

@Document(collection = "InstaUser")
public class User {
    public User() {
        this.followersCount = 0;
        this.followingCount = 0;
        this.postCount = 0;
    }
    @Id
    private String profileId;
    private String userName;
    private String description;
    private long followersCount;
    private long followingCount;
    private long postCount;
//    private ArrayList<String> posts = new ArrayList<String>();
//    ArrayList<String> list=new ArrayList<String>();
//    private ArrayList posts;
//    private long postCount;

//    private long totalPosts;
//    private long postId;
//    private long likesForEachPost;
//    private String commentsForEachPost;
//    private long commentLikes;
}