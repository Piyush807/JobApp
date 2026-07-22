package com.jobapprest.jobapprest.dto;

import lombok.Data;
import lombok.Setter;

@Data
@Setter
public class LoginDto {
    private String email;
    private String password;
}
