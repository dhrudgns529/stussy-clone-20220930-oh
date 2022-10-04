package com.stussy.stussyclone20220930oh.dto;

import lombok.Data;

@Data
public class RegisterReqDto {
    private String lastName;
    private String FirstName;
    private String email;
    private String password;
}
