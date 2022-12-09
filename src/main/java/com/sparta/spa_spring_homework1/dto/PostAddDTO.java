package com.sparta.spa_spring_homework1.dto;

import com.sparta.spa_spring_homework1.entity.Homework;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
public class PostAddDTO {

    private String contents;

    public PostAddDTO(Homework homework) {
        this.contents = homework.getContents();
    }
}
