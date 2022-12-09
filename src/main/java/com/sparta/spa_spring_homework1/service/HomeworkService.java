package com.sparta.spa_spring_homework1.service;

import com.sparta.spa_spring_homework1.dto.*;
import com.sparta.spa_spring_homework1.entity.Homework;
import com.sparta.spa_spring_homework1.repository.HomeworkRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.Cache;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HomeworkService {

    private final HomeworkRepository homeworkRepository;


    @Transactional
    public List<PostListDTO> getList() {

        List<Homework> homework = homeworkRepository.findAll();
        List<PostListDTO> postLists = new ArrayList<>();

        for(Homework homes : homework){

            PostListDTO postListDTO = new PostListDTO(homes);
            postLists.add(postListDTO);
        }

        return postLists;



    }
    @Transactional
    //public PostAddDTO addPost(String title, String username, String password, String contents) {
    //public PostAddDTO addPost(PostAddInDTO postAddInDTO){
    public PostAddDTO addPost(Homework homejson){
            Homework homework = new Homework(homejson);
            homeworkRepository.save(homework);

            PostAddDTO postAddDTO = new PostAddDTO(homework);
            return postAddDTO;



    }
    @Transactional
    public PostSelectDTO viewPost(Long id) {


        Homework homework = homeworkRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지않음")
        );

        PostSelectDTO postSelectDTO = new PostSelectDTO(homework);

        return postSelectDTO;
    }
    @Transactional
    public PostEditDTO editPost(Long id, Homework homejson) {

        Homework homework = homeworkRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지않음")
        );


//        if (homework.getPassword().equals(homejson.getPassword())) {
//
//            homework.edit(homejson.getContents());
//            PostEditDTO postEditDTO = new PostEditDTO(homework);
//            return postEditDTO;
//        }else{
//            //return null;
//            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다");
//
//        }
        if (homework.getPassword().equals(homejson.getPassword()))  {

            homework.edit(homejson.getContents());
            PostEditDTO postEditDTO = new PostEditDTO(homework);
            return postEditDTO;
        } throw new IllegalArgumentException("비밀번호가 옳지 않습니다");


    }
    @Transactional
    public String deletePost(Long id, String password) {
        Homework homework = homeworkRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지않음")
        );

        if(homework.getPassword().equals(password)){

            homeworkRepository.deleteById(id);
            return "성공";
        }

        return "비밀번호 오류";

    }
}
