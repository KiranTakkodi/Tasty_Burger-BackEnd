package com.example.UserDataApi.DTO.CartDTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
@Getter
@Setter
public class CartResponseDTO {
    private Long id;
    private String name;
    private String image;
    private double price;
    private  double ratings;
    private String about;
    private int quantity;
}
