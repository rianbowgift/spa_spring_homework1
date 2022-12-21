package com.sparta.spa_spring_homework1.service;

import com.sparta.spa_spring_homework1.dto.*;
import com.sparta.spa_spring_homework1.entity.Comment;
import com.sparta.spa_spring_homework1.entity.Post;
import com.sparta.spa_spring_homework1.entity.User;
import com.sparta.spa_spring_homework1.entity.UserRoleEnum;
import com.sparta.spa_spring_homework1.jwt.JwtUtil;
import com.sparta.spa_spring_homework1.repository.CommentRepository;
import com.sparta.spa_spring_homework1.repository.PostRepository;
import com.sparta.spa_spring_homework1.repository.UserRepository;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final AuthService authService;
    private final ResponseService responseService;
    private final CommentRepository commentRepository;

    @Transactional
    public List<PostListDTO> getList() {

        //문법만 익혀둘것
//        List<Post> posts = postRepository.findAllByOrderByModifiedAtDesc();

        List<Post> posts = postRepository.findAll();
        List<PostListDTO> postLists = new ArrayList<>();

        for(Post post : posts){

            PostListDTO postListDTO = new PostListDTO(post);
            postLists.add(postListDTO);
        }

        //반환
        return postLists;



    }


    @Transactional
    public ResponseEntity addPost(Post post, HttpServletRequest request){



        //토큰검사후 사용자정보 반환
        Claims claims =  authService.tokenConfirm(request);


        //레퍼지토리 사용자 검사
        User user = userRepository.findByUsername(claims.getSubject()).orElseThrow(
                () -> new IllegalArgumentException("사용자가 존재하지 않습니다.")
        );


        //게시글 저장
        Post posts = new Post(post,user);
        postRepository.save(posts);


        //반환
        PostAddDTO postAddDTO = new PostAddDTO(post);
        return responseService.responseMessage(postAddDTO);

    }
    @Transactional
    public ResponseEntity viewPost(Long id) {

        //글번호 유효성 검사. 유효시 id 값의 게시글 반환
        Post posts = findByPostId(id);

        //반환
        PostSelectDTO postSelectDTO = new PostSelectDTO(posts);
        return responseService.responseMessage(postSelectDTO);
    }
    @Transactional
    public ResponseEntity editPost(Long id, Post post,HttpServletRequest request) {

        //글번호 유효성 검사. 유효시 id 값의 게시글 반환
        Post posts = findByPostId(id);

        //토큰검사후 사용자정보 반환
        Claims claims =  authService.tokenConfirm(request);

        //토큰값의 사용자 정보 조회
        User user = userRepository.findByUsername(claims.getSubject()).orElseThrow(
                () -> new IllegalArgumentException("사용자 정보가 올바르지 않습니다.")
        );


        //토큰유저와 게시글 작성자가 같거나 관리자인지
        UserRoleEnum userRoleEnum = user.getRole();

        if(userRoleEnum== UserRoleEnum.USER){
            if(!(posts.getUsername().equals(user.getUsername()))){
                throw new IllegalArgumentException("작성자만 삭제/수정할 수 있습니다.");
            }
        }
//        //사용자 정보와 게시글의 작성자 정보 비교
//        if(!(posts.getUsername().equals(user.getUsername()))){
//            throw new IllegalArgumentException("다른 사람의 게시글입니다");
//        }

        //글 수정
        posts.edit(post);

        //반환
        PostEditDTO postEditDTO = new PostEditDTO(post);
        return responseService.responseMessage(postEditDTO);

    }
    @Transactional
    public ResponseEntity deletePost(Long id, HttpServletRequest request) {

        //글번호 유효성 검사. 유효시 id 값의 게시글 반환
        Post posts = findByPostId(id);

        //토큰검사후 사용자정보 반환
        Claims claims =  authService.tokenConfirm(request);

        //토큰값의 사용자 정보 조회
        User user = userRepository.findByUsername(claims.getSubject()).orElseThrow(
                () -> new IllegalArgumentException("사용자 정보가 올바르지 않습니다.")
        );


        //토큰유저와 게시글 작성자가 같거나 관리자인지
        UserRoleEnum userRoleEnum = user.getRole();

        if(userRoleEnum== UserRoleEnum.USER){
            if(!(posts.getUsername().equals(user.getUsername()))){
                throw new IllegalArgumentException("작성자만 삭제/수정할 수 있습니다.");
            }
        }
//        //사용자 정보와 게시글의 작성자 정보 비교
//        if(!(posts.getUsername().equals(user.getUsername()))){
//            throw new IllegalArgumentException("다른 사람의 게시글입니다");
//        }

        //삭제
        postRepository.deleteById(id);

        //반환
        ResponseDTO responseDTO = new ResponseDTO("게시글 삭제 성공",HttpStatus.OK);
        return responseService.responseMessage(responseDTO);

    }



    public Post findByPostId(Long id){
        //글번호 유효성 검사
        Post posts = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 게시글이 존재하지않음")
        );

        return posts;
    }
}
