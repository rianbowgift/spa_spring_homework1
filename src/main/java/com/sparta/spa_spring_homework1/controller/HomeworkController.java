package com.sparta.spa_spring_homework1.controller;

import com.sparta.spa_spring_homework1.dto.*;
import com.sparta.spa_spring_homework1.entity.Homework;
import com.sparta.spa_spring_homework1.service.HomeworkService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class HomeworkController {


    private final HomeworkService homeworkService;


    @GetMapping("/api/allList")
    public List<PostListDTO> getList(){
        return homeworkService.getList();
    }


//    @PostMapping("/api/addPost/{title}/{username}/{password}/{contents}")
    @PostMapping("/api/addPost")
    //public PostAddDTO addPost(@PathVariable String title, @PathVariable String username, @PathVariable String password, @PathVariable String contents){
    //public PostAddDTO addPost(@RequestBody PostAddInDTO postAddInDTO){
    public PostAddDTO addPost(@RequestBody Homework homework){
        return homeworkService.addPost(homework);
        //return homeworkService.addPost(title,username,password,contents);
    }

    @GetMapping("/api/viewPost/{id}")
    public PostSelectDTO viewPost(@PathVariable Long id){
        return homeworkService.viewPost(id);
    }

    //@PutMapping("/api/editPost/{id}/{contents}/{password}")
    @PutMapping("/api/editPost/{id}")
    //public PostEditDTO editPost(@PathVariable Long id,@PathVariable String contents,@PathVariable String password){
    public PostEditDTO editPost(@PathVariable Long id,@RequestBody Homework homework){
        return homeworkService.editPost(id,homework);
        //return homeworkService.editPost(homework);
        //return homeworkService.editPost(id,contents,password);
    }

    //@DeleteMapping("/api/deletePost/{id}/{password}")
    @DeleteMapping("/api/deletePost/{id}")
    //public String deletePost(@PathVariable Long id,@PathVariable String password){
    public String deletePost(@PathVariable Long id,@RequestBody Homework homework){
        return homeworkService.deletePost(id,homework.getPassword());
        //return homeworkService.deletePost(id,password);
    }






}











//테스트코드
//1.사용자 생성 두명 POST
//http://localhost:8080/api/addPost
/*

{
        "title":"hi", "username":"kim", "password":"12", "contents":"bye"
        }

*/
//http://localhost:8080/api/addPost
/*

{
        "title":"안녕하세요", "username":"song", "password":"1234", "contents":"반가워요"
        }

*/

//2.전체 글 검색 GET
//http://localhost:8080/api/allList


//3.특정 글 검색 GET
//http://localhost:8080/api/viewPost/2


//4.글수정 실패  PUT
//http://localhost:8080/api/editPost/1
/*

{
        "password":"1234", "contents":"반가워요"
        }

 */



//5.글수정 성공 PUT
//http://localhost:8080/api/editPost/1
/*
{

        "password":"12", "contents":"반가워요"
        }

 */


//6.글삭제 실패 DELETE
//http://localhost:8080/api/deletePost/1
/*

{
        "password":"1234"
        }

 */

//7.글삭제 성공 DELETE
//http://localhost:8080/api/deletePost/1
/*

{
        "password":"12"
        }

 */