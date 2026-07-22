package com.jobapprest.jobapprest.controller;

import com.jobapprest.jobapprest.dto.LoginDto;
import com.jobapprest.jobapprest.dto.SignUpDto;
import com.jobapprest.jobapprest.dto.UserDto;
import com.jobapprest.jobapprest.model.User;
import com.jobapprest.jobapprest.service.AuthService;
import com.jobapprest.jobapprest.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthControlller {

private final UserService userService;
private final AuthService authService;


    @PostMapping("/signup")
    public UserDto signup(@RequestBody SignUpDto signUpDto)
    {
        //UserDto userDto=userService.signUp(signUpDto);
        return userService.signUp(signUpDto);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user ){
        String token = authService.login(user);
        return ResponseEntity.ok(token);
    }
}
