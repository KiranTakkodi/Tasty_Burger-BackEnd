package com.example.UserDataApi.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Data
public class LoginResponseDto {
    private String status;
    private Long id;
    private String name;
    private String email;
    private String phonenumber;
    private String address;
}
