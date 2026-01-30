package com.example.UserDataApi.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Data
@Getter
@Setter
public class UpdateProfileDto {
    private String name;
    private  String email;
    private String address;
    private String phonenumber;
}
