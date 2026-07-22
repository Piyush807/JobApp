package com.jobapprest.jobapprest.service;

import com.jobapprest.jobapprest.dto.LoginDto;
import com.jobapprest.jobapprest.model.User;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
   // private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
   // private final ModelMapper modelMapper;
  //  private final JwtService jwtService;
    public String login(User user){
     //   loginDto.setPassword(new BCryptPasswordEncoder(12).toString());

       // User user1 = modelMapper.map(loginDto, User.class);
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));

        if (authentication.isAuthenticated()){
            // return jwtService.generateToken(loginDto);
            return "success";
        }
        return "fail";

    }
}
