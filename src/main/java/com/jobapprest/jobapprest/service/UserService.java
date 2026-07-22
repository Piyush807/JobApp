package com.jobapprest.jobapprest.service;


import com.jobapprest.jobapprest.dto.SignUpDto;
import com.jobapprest.jobapprest.dto.UserDto;
import com.jobapprest.jobapprest.model.User;
import com.jobapprest.jobapprest.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    @Autowired
    private final ModelMapper modelMapper;
    private final UserRepo userRepo;

  //  private final AuthenticationManager authenticationManager;
  //  private final JwtService jwtService;

    private  BCryptPasswordEncoder encoder= new BCryptPasswordEncoder(12);

    public UserDto signUp(SignUpDto signUpDto) {

       User toBeCreated = modelMapper.map(signUpDto, User.class);
       toBeCreated.setPassword(encoder.encode(toBeCreated.getPassword()));
       User savedUser = userRepo.save(toBeCreated);
       return modelMapper.map( savedUser, UserDto.class);


    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepo.findByEmail(username)
                .orElseThrow(()-> new UsernameNotFoundException("user not found"));
    }

//    public String login(LoginDto loginDto){
//        Authentication authentication = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword()));
//        if (authentication.isAuthenticated()){
//           // return jwtService.generateToken(loginDto);
//            return "success";
//        }
//        return "fail";
//
//    }


}
