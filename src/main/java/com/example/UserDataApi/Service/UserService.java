package com.example.UserDataApi.Service;

import com.example.UserDataApi.DTO.LoginDTO;
import com.example.UserDataApi.DTO.LoginResponseDto;
import com.example.UserDataApi.DTO.SignUpDTO;
import com.example.UserDataApi.DTO.UpdateProfileDto;

public interface UserService {
    String SignUp(SignUpDTO signUpDTO);
    LoginResponseDto Login(LoginDTO loginDTO);

    LoginResponseDto updateProfile(Long id, UpdateProfileDto updateProfileDto);
}
