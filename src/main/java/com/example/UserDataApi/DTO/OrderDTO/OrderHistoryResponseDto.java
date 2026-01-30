package com.example.UserDataApi.DTO.OrderDTO;

import com.example.UserDataApi.DTO.OrderItemDTO.OrderItemResponseDtos;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor

public class OrderHistoryResponseDto {
    private Long orderId;
    private double total;
    private String status;
    private List<OrderItemResponseDtos> allitems;
}
