package com.example.UserDataApi.Service;

import com.example.UserDataApi.DTO.OrderDTO.OrderHistoryResponseDto;
import com.example.UserDataApi.DTO.OrderDTO.OrderResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface OrderService {
    OrderResponseDTO PlaceOrder(Long id);

    List<OrderHistoryResponseDto>GetOrderHistory(Long id);

    int autoDeliverOrders();
}
