package com.example.UserDataApi.DTO.ProductDTO;


import jakarta.persistence.Column;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductDataDTO {
    private Long id;
    private String name;

    private double price;

    private String about;

    private String image;

    private double rating;
}
