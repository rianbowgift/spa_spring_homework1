package com.sparta.spa_spring_homework1.controller;


import com.sparta.spa_spring_homework1.dto.CommentRequest;
import com.sparta.spa_spring_homework1.entity.Post;
import com.sparta.spa_spring_homework1.service.CommentService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;



    @PostMapping("/comment/{id}")//코맨트 등록
    public ResponseEntity addComment(@PathVariable Long id,@RequestBody CommentRequest commentRequest, HttpServletRequest request){

        return commentService.comment(id,commentRequest,request);


        //http://localhost:8080/comment/1
        /*
            {
        "contents":"첫번째 글의 첫번쨰 댓글입니다"
            }
         */


    }

    @PutMapping("/editcomment/{id}/{cid}")//코맨트 수정
    public ResponseEntity editComment(@PathVariable Long id,@PathVariable Long cid,@RequestBody CommentRequest commentRequest, HttpServletRequest request){

        return commentService.edit(id,cid,commentRequest,request);
    }

    @DeleteMapping("/delcomment/{id}/{cid}")//코맨트 삭제
    public ResponseEntity delComment(@PathVariable Long id,@PathVariable Long cid,HttpServletRequest request){

        return commentService.delete(id,cid,request);
    }



    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity commentHandler(IllegalArgumentException e){

        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(e.getMessage(),headers,HttpStatus.valueOf(400));
    }



}
