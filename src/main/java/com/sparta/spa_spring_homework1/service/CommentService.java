package com.sparta.spa_spring_homework1.service;

import com.sparta.spa_spring_homework1.dto.*;
import com.sparta.spa_spring_homework1.entity.Comment;
import com.sparta.spa_spring_homework1.entity.Post;
import com.sparta.spa_spring_homework1.entity.User;
import com.sparta.spa_spring_homework1.entity.UserRoleEnum;
import com.sparta.spa_spring_homework1.repository.CommentRepository;
import com.sparta.spa_spring_homework1.repository.PostRepository;
import com.sparta.spa_spring_homework1.repository.UserRepository;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

@Service
@RequiredArgsConstructor
public class CommentService {


    private final CommentRepository commentRepository;
    private final AuthService authService;
    private final UserRepository userRepository;
    private final ResponseService responseService;
    private final PostRepository postRepository;

    @Transactional
    public ResponseEntity comment(Long id,CommentRequest commentRequest, HttpServletRequest request){

        //토큰검사후 사용자정보 반환
        Claims claims =  authService.tokenConfirm(request);


        //레퍼지토리 사용자 검사
        User user = userRepository.findByUsername(claims.getSubject()).orElseThrow(
                () -> new IllegalArgumentException("사용자가 존재하지 않습니다.")
        );

        //글번호 유효성 검사
        Post posts = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 게시글이 존재하지않음")
        );

        //3.댓글 저장
        Comment comment = new Comment(commentRequest,user,posts);
        commentRepository.save(comment);

        //반환
        CommentResponse commentResponse = new CommentResponse(comment);
        return responseService.responseMessage(commentResponse);

    }

    @Transactional
    public ResponseEntity edit(Long id,Long cid,CommentRequest commentRequest, HttpServletRequest request) {


        //토큰검사후 사용자정보 반환
        Claims claims =  authService.tokenConfirm(request);

        //레퍼지토리 사용자 검사
        User user = userRepository.findByUsername(claims.getSubject()).orElseThrow(
                () -> new IllegalArgumentException("사용자가 존재하지 않습니다.")
        );


        //글번호 유효성 검사
        Post posts = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 게시글이 존재하지않음")
        );


        //코맨트 유효성 검사
        Comment comment = commentRepository.findById(cid).orElseThrow(
                () -> new IllegalArgumentException("해당 코맨트가 존재하지않음")
        );


        //토큰유저와 코맨트 작성자가 같거나 관리자인지
        UserRoleEnum userRoleEnum = user.getRole();

        if(userRoleEnum== UserRoleEnum.USER){
            if(!comment.getUsername().equals(user.getUsername())){
                new IllegalArgumentException("본인이 작성한 코맨트만 수정할수 있습니다.");
            }
        }

//        //코맨트 작성자가 equals(토큰유저)와 같은지
//        if(!comment.getUsername().equals(user.getUsername())){
//            new IllegalArgumentException("본인이 작성한 코맨트만 수정할수 있습니다.");
//        }



        //코맨트 수정
        comment.edit(commentRequest);


        //반환
        CommentResponse commentResponse = new CommentResponse(comment);
        return responseService.responseMessage(commentResponse);

    }

    @Transactional
    public ResponseEntity delete(Long id,Long cid,HttpServletRequest request) {
        //토큰검사후 사용자정보 반환
        Claims claims =  authService.tokenConfirm(request);

        //레퍼지토리 사용자 검사
        User user = userRepository.findByUsername(claims.getSubject()).orElseThrow(
                () -> new IllegalArgumentException("작성자만 삭제/수정할 수 있습니다.")
        );


        //글번호 유효성 검사
        Post posts = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 게시글이 존재하지않음")
        );


        //코맨트 유효성 검사
        Comment comment = commentRepository.findById(cid).orElseThrow(
                () -> new IllegalArgumentException("해당 코맨트가 존재하지않음")
        );




        //토큰유저와 코맨트 작성자가 같거나 관리자인지
        UserRoleEnum userRoleEnum = user.getRole();

        if(userRoleEnum== UserRoleEnum.USER){
            if(!comment.getUsername().equals(user.getUsername())){
                new IllegalArgumentException("작성자만 삭제/수정할 수 있습니다.");
            }
        }
//        //코맨트 작성자가 equals(토큰유저)와 같은지
//        if(!comment.getUsername().equals(user.getUsername())){
//            new IllegalArgumentException("본인이 작성한 코맨트만 수정할수 있습니다.");
//        }

        //코맨트 삭제
        commentRepository.deleteById(cid);

        //반환

        //삭제성공 반환
        ResponseDTO responseDTO = new ResponseDTO("코맨트 삭제 성공", HttpStatus.OK);
        return responseService.responseMessage(responseDTO);



    }
}
