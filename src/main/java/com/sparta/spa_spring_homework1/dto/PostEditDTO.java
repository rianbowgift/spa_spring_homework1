package com.sparta.spa_spring_homework1.dto;


import com.sparta.spa_spring_homework1.entity.Post;
import lombok.Getter;


@Getter
public class PostEditDTO {
    private String title;
    private String contents;



    public PostEditDTO(Post post) {
        this.title = post.getTitle();
        this.contents = post.getContents();
    }

}
