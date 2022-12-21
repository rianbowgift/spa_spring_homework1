package com.sparta.spa_spring_homework1.controller;

import com.sparta.spa_spring_homework1.dto.AdminUseDTO;
import com.sparta.spa_spring_homework1.dto.ResponseDTO;
import com.sparta.spa_spring_homework1.dto.UserDTO;
import com.sparta.spa_spring_homework1.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;


    @PostMapping("/signup")
    public ResponseEntity signup(@Valid @RequestBody UserDTO userDTO){
        return userService.signup(userDTO);

    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody UserDTO userDTO, HttpServletResponse response){
        return userService.login(userDTO,response);

    }

    @PostMapping("/admin")
    public String adminUse(@RequestBody AdminUseDTO adminUseDTO){
            return userService.adminUse(adminUseDTO);
    }



    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity userHandler(IllegalArgumentException e){

        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(e.getMessage(),headers, HttpStatus.valueOf(400));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity regHandler(MethodArgumentNotValidException e){
//e.getBindingResult()



        
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(e.getMessage(),headers, HttpStatus.valueOf(400));
    }

}
