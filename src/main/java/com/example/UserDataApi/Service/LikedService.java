package com.example.UserDataApi.Service;

import com.example.UserDataApi.DTO.LikedDTO.LikedResponseDto;
import com.example.UserDataApi.DTO.LikedDTO.likedDto;

import java.util.List;

public interface LikedService {
    LikedResponseDto toggleLike(Long userId, Long productId);

    List<likedDto> getFavourites(Long id);
}
