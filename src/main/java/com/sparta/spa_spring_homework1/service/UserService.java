package com.sparta.spa_spring_homework1.service;

import com.sparta.spa_spring_homework1.dto.ResponseDTO;
import com.sparta.spa_spring_homework1.dto.UserDTO;
import com.sparta.spa_spring_homework1.entity.User;
import com.sparta.spa_spring_homework1.entity.UserRoleEnum;
import com.sparta.spa_spring_homework1.jwt.JwtUtil;
import com.sparta.spa_spring_homework1.repository.UserRepository;
import jakarta.servlet.http.HttpServletResponse;
import org.aspectj.bridge.Message;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {


    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;
    private final AuthService authService;
    private final ResponseService responseService;

    @Transactional
    public ResponseEntity signup(UserDTO userDTO) {
        String username = userDTO.getUsername();
        String password = userDTO.getPassword();

        

        //아이디,패스워드 정규표현식(양식에 맞는 정보 확인)
        String name_reg =  "^[a-z0-9]{4,10}$";
        String pwd_reg =  "^[A-Za-z0-9]{8,15}$";
        if(!username.matches(name_reg)){//아이디 정규표현식 체크
            throw new IllegalArgumentException("잘못된 형식의 아이디 입니다");
        }
        if(!password.matches(pwd_reg)){
            throw new IllegalArgumentException("잘못된 형식의 패스워드 입니다");
        }



        //중복회원 확인
        Optional<User> found =userRepository.findByUsername(username);
        if(found.isPresent()){  //옵셔널 기능. ==반환값이 있으면
            throw new IllegalArgumentException("중복된 사용자가 존재합니다");
        }

        //중복없으면 가입
        UserRoleEnum role = UserRoleEnum.USER;
        User user = new User(username,password,role);
        userRepository.save(user);

        //반환
        ResponseDTO responseDTO = new ResponseDTO("가입 성공",HttpStatus.OK);
        return responseService.responseMessage(responseDTO);

    }


    @Transactional(readOnly = true)
    public ResponseEntity login(UserDTO userDTO, HttpServletResponse response) {
        String username = userDTO.getUsername();
        String password = userDTO.getPassword();



        //사용자 등록사실 확인
        User user = userRepository.findByUsername(username).orElseThrow(
                () -> new IllegalArgumentException("등록된 사용자가 없습니다.")
        );


        //사용자 등록이 확인됐다면 pw가 맞는지 확인
        if(!user.getPassword().equals(password)){
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다");
        }

        //로그인 유저에게 토큰 전송
        response.addHeader(JwtUtil.AUTHORIZATION_HEADER,jwtUtil.createToken(user.getUsername(),user.getRole()));


        //반환
        ResponseDTO responseDTO = new ResponseDTO("로그인 성공", HttpStatus.OK);
        return responseService.responseMessage(responseDTO);

    }
}
