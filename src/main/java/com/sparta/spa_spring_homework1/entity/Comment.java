package com.sparta.spa_spring_homework1.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sparta.spa_spring_homework1.dto.CommentRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String username; //코맨트.작성자의 정보

    @Column(nullable = false)
    private String contents;

    //1. @ManyToOne(fetch = FetchType.LAZY)
    @ManyToOne
    @JsonIgnore
    private Post post;      //포스트 정보

    public Comment(CommentRequest commentRequest, User user,Post post) {
        this.username = user.getUsername(); //코맨트 작성자 정보
        this.contents = commentRequest.getContents();
        this.post = post;
    }

    public void edit(CommentRequest commentRequest) {
        this.contents = commentRequest.getContents();
    }
}
