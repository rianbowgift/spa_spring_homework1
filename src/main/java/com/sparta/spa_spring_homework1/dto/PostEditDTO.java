package com.sparta.spa_spring_homework1.dto;


import com.sparta.spa_spring_homework1.entity.Homework;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class PostEditDTO {
    private String title;
    private String username;
    private String contents;



    public PostEditDTO(Homework homework) {
        this.title = homework.getTitle();
        this.username = homework.getUsername();
        this.contents = homework.getContents();
    }

}
