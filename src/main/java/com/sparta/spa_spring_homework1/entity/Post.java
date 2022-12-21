package com.sparta.spa_spring_homework1.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

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
    @OneToMany(mappedBy = "post", cascade = CascadeType.REMOVE, orphanRemoval = true)
    //댓글 의존성무시 같이삭제
    //@OneToMany(mappedBy = "post")
    @OrderBy("id desc") // 댓글 정렬
    private List<Comment> commentList = new ArrayList<>();

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
