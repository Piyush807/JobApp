package com.jobapprest.jobapprest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JobAppRestApplication {

    public static void main(String[] args) {
        io.github.cdimascio.dotenv.Dotenv dotenv = io.github.cdimascio.dotenv.Dotenv.load();
        dotenv.entries().forEach(entry -> System.setProperty(entry.getKey(), entry.getValue()));
        System.out.println(System.getProperty("GOOGLE_CLIENT_ID"));
        SpringApplication.run(JobAppRestApplication.class, args);
    }

}
