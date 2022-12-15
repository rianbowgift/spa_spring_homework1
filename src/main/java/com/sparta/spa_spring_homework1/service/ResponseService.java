package com.sparta.spa_spring_homework1.service;


import com.sparta.spa_spring_homework1.dto.ResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ResponseService {


    public ResponseEntity responseMessage(Object DTO){

        //출력할 메세지와 스테이터스를 담아서 ResponseEntity 형태로 반환
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Object>(DTO,headers,HttpStatus.valueOf(200));
    }


}
