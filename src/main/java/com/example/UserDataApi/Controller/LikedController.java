package com.example.UserDataApi.Controller;


import com.example.UserDataApi.DTO.LikedDTO.LikedResponseDto;
import com.example.UserDataApi.DTO.LikedDTO.likedDto;
import com.example.UserDataApi.Service.LikedService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class LikedController {

    private final LikedService likedService;

    @PostMapping("/user/{userId}/like/{productId}")
    public ResponseEntity<LikedResponseDto> toggleLike(
            @PathVariable Long userId,
            @PathVariable Long productId) {

        return ResponseEntity.ok(likedService.toggleLike(userId, productId));
    }

    @GetMapping("/user/favorites/{id}")
    public ResponseEntity<List<likedDto>>Favorites(@PathVariable Long id){
        return ResponseEntity.ok(likedService.getFavourites(id));
    }
}
