package com.sparta.spa_spring_homework1.dto;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class UserDTO {

    @Pattern(regexp = "^[a-z0-9]*$",message = "잘못된 형식의 아이디 입니다")
    @Size(min=4,max=10)
    private String username;

    //@Pattern(regexp = "^.*(?=^.$)(?=.*\\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$",message = "잘못된 형식의 패스워드 입니다")
    @Pattern(regexp = "^[a-zA-Z0-9]*$",message = "잘못된 형식의 패스워드 입니다")
    @Size(min=8,max=15)
    private String password;
}

