package com.sparta.spa_spring_homework1.controller;

import com.sparta.spa_spring_homework1.dto.*;
import com.sparta.spa_spring_homework1.entity.Post;
import com.sparta.spa_spring_homework1.service.PostService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class PostController {


    private final PostService homeworkService;


    @GetMapping("/api/allList")
    public List<PostListDTO> getList(){
        return homeworkService.getList();
    }


    @PostMapping("/api/addPost")
    public ResponseEntity addPost(@RequestBody Post post, HttpServletRequest request){
        return homeworkService.addPost(post,request);

    }

    @GetMapping("/api/viewPost/{id}")
    public ResponseEntity viewPost(@PathVariable Long id){
        return homeworkService.viewPost(id);
    }



    @PutMapping("/api/editPost/{id}")
    public ResponseEntity editPost(@PathVariable Long id,@RequestBody Post post,HttpServletRequest request){
        return homeworkService.editPost(id, post,request);

    }


    @DeleteMapping("/api/deletePost/{id}")
    public ResponseEntity deletePost(@PathVariable Long id, HttpServletRequest request){
        return homeworkService.deletePost(id, request);

    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity postHandler(IllegalArgumentException e){

        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(e.getMessage(),headers,HttpStatus.valueOf(400));
    }




}











//테스트코드

//1.비 로그인 게시글 생성 POST
//http://localhost:8080/api/addPost
/*

{
        "title":"첫번째 글 제목",  "contents":"첫번쨰 글 내용"
        }

*/


//2.신규 유저 추가 POST
//http://localhost:8080/user/signup
/*
        {
        "username":"kims",
        "password":"12345678"
        }
*/


//3.신규 유저 로그인 POST
//http://localhost:8080/user/login
/*
        {
        "username":"kims",
        "password":"12345678"
        }
*/


//4.게시글 생성 POST
//http://localhost:8080/api/addPost
/*

{
        "title":"첫번째 글 제목",  "contents":"첫번쨰 글 내용"
        }

*/
//http://localhost:8080/api/addPost
/*

{
        "title":"두번째 글 제목",  "contents":"두번쨰 글 내용"
        }
*/

//5.전체 글 검색 GET
//http://localhost:8080/api/allList


//6.특정 글 검색 GET
//http://localhost:8080/api/viewPost/2




//7.글수정 성공 PUT
//http://localhost:8080/api/editPost/1
/*
{
        "title":"수정된제목",
        "contents":"내용을바꿨어요"
        }

 */




//8.글삭제 성공 DELETE
//http://localhost:8080/api/deletePost/1
/*



 */


//9.글삭제 실패 DELETE
//http://localhost:8080/api/deletePost/1
/*



 */


//10.글수정 실패 PUT(게시글이 없음)
//http://localhost:8080/api/editPost/1
/*
{
        "title":"수정된제목",
        "contents":"내용을바꿨어요"
        }

 */



//11.신규 유저 추가 POST
//http://localhost:8080/user/signup
/*
        {
        "username":"park",
        "password":"987654321"
        }
*/


//12.신규 유저 로그인 POST
//http://localhost:8080/user/login
/*
        {
        "username":"park",
        "password":"987654321"
        }
*/



//13.전체 글 검색 GET
//http://localhost:8080/api/allList



//14.글수정 실패 PUT
//http://localhost:8080/api/editPost/2
/*
{
        "title":"PARK의 수정글",
        "contents":"park이 글을 수정하였습니다"
        }

 */




//15.글삭제 실패 DELETE
//http://localhost:8080/api/deletePost/2
/*



 */



//16.전체 글 검색 GET
//http://localhost:8080/api/allList