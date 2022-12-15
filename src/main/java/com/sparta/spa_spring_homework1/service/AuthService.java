package com.sparta.spa_spring_homework1.service;

import com.sparta.spa_spring_homework1.dto.ResponseDTO;
import com.sparta.spa_spring_homework1.entity.User;
import com.sparta.spa_spring_homework1.jwt.JwtUtil;
import com.sparta.spa_spring_homework1.repository.UserRepository;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;


    public Claims tokenConfirm(HttpServletRequest request){

        //토큰의 유효성을 검사한뒤 반환
        String token = jwtUtil.resolveToken(request);
        Claims claims;

        if(token == null)  {
            throw new IllegalArgumentException("로그인 해주세요 (토큰이 존재하지 않습니다)");
        }else{
            if(jwtUtil.validateToken(token)){//토큰 검사 성공시
                claims = jwtUtil.getUserInfoFromToken(token);//토큰에서 사용자 정보 가저오기
            }else{
                throw new IllegalArgumentException("토큰 에러");
            }
        }

        return claims;

    }




}
