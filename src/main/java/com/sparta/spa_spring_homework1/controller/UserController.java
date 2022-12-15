package com.sparta.spa_spring_homework1.controller;

import com.sparta.spa_spring_homework1.dto.ResponseDTO;
import com.sparta.spa_spring_homework1.dto.UserDTO;
import com.sparta.spa_spring_homework1.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;


    @PostMapping("/signup")
    public ResponseEntity signup(@RequestBody UserDTO userDTO){
        try{
            return userService.signup(userDTO);
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody UserDTO userDTO, HttpServletResponse response){
        try{
            return userService.login(userDTO,response);
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

}
