package com.example.UserDataApi.DTO.OrderItemDTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemResponseDtos {
    private String productName;
    private int quantity;
    private double price;
}
