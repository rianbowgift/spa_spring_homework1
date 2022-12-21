package com.sparta.spa_spring_homework1.dto;

import com.sparta.spa_spring_homework1.entity.Comment;
import lombok.Getter;

@Getter
public class CommentResponse {



    private String contents;

    public CommentResponse(Comment comment) {
        this.contents = comment.getContents();
    }

}
