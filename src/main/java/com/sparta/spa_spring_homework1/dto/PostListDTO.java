package com.sparta.spa_spring_homework1.dto;

import com.sparta.spa_spring_homework1.entity.Post;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostListDTO {


    private String title;
    private String username;
    private String contents;
    private LocalDateTime createdAt;



    public PostListDTO(Post post) {
        this.title = post.getTitle();
        this.username = post.getUsername();
        this.contents = post.getContents();
        this.createdAt = post.getCreatedAt();
    }



}
