package com.example.UserDataApi.DTO.CartDTO;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor

public class AddItemDTO {
    private Long userid;
    private String name;
    private String image;
    private double price;
    private  double ratings;
    private String about;
    private int quantity;
}
