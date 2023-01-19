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

@Document(collection = "InstaPost")

public class Post {

    public Post() {
//        this.postId="jkkjgui";
//        this.profileId="kavi13";
//        this.postsCount=0;
//        this.postsLikes=0;
//        this.commentsForPost="";
//        this.commentsLikes=0;
    }
    private String posts;
    @Id
    private String postId;
    private String profileId;
    private long postUploadedTime;

//    private long postsCount;
//    private long postsLikes;
//    private String commentsForPost;
//    private long commentsLikes;
}
