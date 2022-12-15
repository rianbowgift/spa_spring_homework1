package com.sparta.spa_spring_homework1.dto;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ResponseDTO {

    private String msg;
    private HttpStatus statusCode;


    public ResponseDTO(String msg,HttpStatus http) {
        this.msg = msg;
        this.statusCode = http;

    }



}


