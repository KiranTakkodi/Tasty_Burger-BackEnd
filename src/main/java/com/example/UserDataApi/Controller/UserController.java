package com.example.UserDataApi.Controller;

import com.example.UserDataApi.DTO.LoginDTO;
import com.example.UserDataApi.DTO.LoginResponseDto;
import com.example.UserDataApi.DTO.SignUpDTO;
import com.example.UserDataApi.DTO.UpdateProfileDto;
import com.example.UserDataApi.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/User/SignUp")
    public ResponseEntity<String>SignUp(@RequestBody SignUpDTO signUpDTO){
        return ResponseEntity.ok(userService.SignUp(signUpDTO));
    }
    @PostMapping("/User/Login")
    public ResponseEntity<LoginResponseDto>Login(@RequestBody LoginDTO loginDTO){
        return ResponseEntity.ok(userService.Login(loginDTO));
    }

    @PutMapping("/User/Update-Profile/{id}")
    public ResponseEntity<LoginResponseDto>UpdateProfile(@PathVariable Long id, @RequestBody UpdateProfileDto updateProfileDto){
        return ResponseEntity.ok(userService.updateProfile(id,updateProfileDto));
    }
}
