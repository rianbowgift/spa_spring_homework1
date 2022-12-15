package com.sparta.spa_spring_homework1.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Post extends Timestamped{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String contents;

    @Column(nullable = false)
    private  String username;


    public Post(Post post, User user){
        this.title = post.getTitle();
        this.contents = post.getContents();
        this.username = user.getUsername();
    }


    public void edit(Post post) {
        this.title = post.getTitle();
        this.contents = post.getContents();
    }
}
