package com.sparta.spa_spring_homework1.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Homework extends Timestamped{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String contents;

    //public Homework(String title, String username, String password, String contents) {
    public Homework(Homework jsonhome){
        this.title = jsonhome.getTitle();
        this.username = jsonhome.getUsername();
        this.password = jsonhome.getPassword();
        this.contents = jsonhome.getContents();
    }


    public void edit(String contents) {
        this.contents = contents;
    }
}
