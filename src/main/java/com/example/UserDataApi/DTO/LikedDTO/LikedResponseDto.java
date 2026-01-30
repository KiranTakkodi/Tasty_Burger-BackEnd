package com.example.UserDataApi.DTO.LikedDTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LikedResponseDto {
    private Long Productid;
    private boolean liked;
}
