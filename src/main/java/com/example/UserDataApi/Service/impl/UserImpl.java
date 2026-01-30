package com.example.UserDataApi.Service.impl;

import com.example.UserDataApi.DTO.LoginDTO;
import com.example.UserDataApi.DTO.LoginResponseDto;
import com.example.UserDataApi.DTO.SignUpDTO;
import com.example.UserDataApi.DTO.UpdateProfileDto;
import com.example.UserDataApi.Entity.User;
import com.example.UserDataApi.Repository.UserRepository;
import com.example.UserDataApi.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public String SignUp(SignUpDTO signUpDTO) {
       if(userRepository.findByEmail(signUpDTO.getEmail()).isPresent()){
           throw new IllegalArgumentException("Email Already Exists");
       }

       User newUser=new User();
       newUser.setUsername(signUpDTO.getUsername());
       newUser.setEmail(signUpDTO.getEmail());
       newUser.setPassword(passwordEncoder.encode(signUpDTO.getPassword()));
       userRepository.save(newUser);
       return  "SignUp Successfull";
    }

    @Override
    public LoginResponseDto Login(LoginDTO loginDTO) {

        User user = userRepository.findByEmail(loginDTO.getEmail()).orElseThrow(() -> new IllegalArgumentException("Invalid Email"));

        if (!passwordEncoder.matches(loginDTO.getPassword(),user.getPassword())){
            throw new IllegalArgumentException("Invalid Password");
        }
        return new LoginResponseDto(
                "success",
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getPhonenumber(),
                user.getAddress()
        );
    }

    @Override
    public LoginResponseDto updateProfile(Long id, UpdateProfileDto updateProfileDto) {
        User user=userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Email"));
        user.setEmail(updateProfileDto.getEmail());
        user.setUsername(updateProfileDto.getName());
        user.setPhonenumber(updateProfileDto.getPhonenumber());
        user.setAddress(updateProfileDto.getAddress());
        userRepository.save(user);
        return  new LoginResponseDto(
                "success",
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getPhonenumber(),
                user.getAddress()
        );
    }
}
