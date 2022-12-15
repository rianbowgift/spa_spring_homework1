package com.sparta.spa_spring_homework1.dto;

import com.sparta.spa_spring_homework1.entity.Post;
import lombok.Getter;

import java.time.LocalDateTime;
@Getter
public class PostSelectDTO {

    private String title;
    private String username;
    private LocalDateTime createdAt;
    private String contents;



    public PostSelectDTO(Post post) {
        this.title = post.getTitle();
        this.username = post.getUsername();
        this.createdAt = post.getCreatedAt();
        this.contents = post.getContents();
    }


}
