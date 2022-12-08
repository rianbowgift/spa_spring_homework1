package com.sparta.spa_spring_homework1.dto;

import com.sparta.spa_spring_homework1.entity.Homework;

public class PostAddDTO {

    private String contents;

    public PostAddDTO(Homework homework) {
        this.contents = homework.getContents();
    }
}
