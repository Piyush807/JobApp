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
        System.out.println("GOOGLE_CLIENT_ID = " + System.getenv("GOOGLE_CLIENT_ID"));
        System.out.println("GOOGLE_CLIENT_SECRET = " + System.getenv("GOOGLE_CLIENT_SECRET"));
        System.out.println("GOOGLE_CLIENT_SECRET = " + System.getenv("GITHUB_CLIENT_ID"));
        System.out.println("GOOGLE_CLIENT_SECRET = " + System.getenv("GITHUB_CLIENT_SECRET"));

    }




}
