package com.instagram.instaModule.model;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Indexed;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString

@Document(collection = "InstaLike")

public class Like {


    Set<Object> hashSetLike = new HashSet<Object>();

    private String postid;
    private String profileId;
    private boolean likedOrNot;
    private long likedTime;

}
