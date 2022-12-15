package com.sparta.spa_spring_homework1.dto;

import com.sparta.spa_spring_homework1.entity.Post;
import lombok.Getter;



@Getter
public class PostAddDTO {

    private String contents;

    public PostAddDTO(Post post) {
        this.contents = post.getContents();
    }
}
