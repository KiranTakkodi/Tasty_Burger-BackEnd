package com.example.UserDataApi.DTO.OrderDTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
@Getter
@Setter
public class OrderResponseDTO {
    private Long orderId;
    private double total;
    private String status;
}
