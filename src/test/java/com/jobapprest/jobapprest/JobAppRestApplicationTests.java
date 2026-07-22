package com.jobapprest.jobapprest;

import com.jobapprest.jobapprest.model.User;
import com.jobapprest.jobapprest.service.JwtService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JobAppRestApplicationTests {
    @Autowired
    private JwtService jwtService;

    @Test
    void contextLoads() {
        User user = new User(5,"Piyush","admin","piyush@mail.com");
        String token = jwtService.generateToken(user);
        System.out.println(token);
        int id = jwtService.getUserIdFromToken(token);
        System.out.println(id);
    }

}
