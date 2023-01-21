package com.instagram.instaModule.model;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Indexed;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString

@Document(collection = "InstaLike")

public class Like {
//@Id
    private String postId;
    private String profileId;
    private boolean likedOrNot;
    private long likedTime;
    private long unlikedTime;

}
