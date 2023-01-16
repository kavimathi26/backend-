package com.instagram.instaModule.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

@Document(collection = "InstaUser")
public class User {
    @Id
    private String profileId;
    private String userName;
    private String description;
    private long followersCount;
    private long followingCount;
//    private long totalPosts;
//    private long postId;
//    private long likesForEachPost;
//    private String commentsForEachPost;
//    private long commentLikes;
}