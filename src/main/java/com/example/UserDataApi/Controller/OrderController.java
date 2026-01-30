package com.example.UserDataApi.Controller;


import com.example.UserDataApi.DTO.OrderDTO.OrderHistoryResponseDto;
import com.example.UserDataApi.DTO.OrderDTO.OrderResponseDTO;
import com.example.UserDataApi.Service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/user/placeorder/{id}")
    public ResponseEntity<OrderResponseDTO>PlaceOrder(@PathVariable Long id){
        return ResponseEntity.ok(orderService.PlaceOrder(id));
    }

    @GetMapping("/user/OrderHistory/{id}")
    public ResponseEntity<List<OrderHistoryResponseDto>>GetOrderHistory(@PathVariable Long id){
        return ResponseEntity.ok(orderService.GetOrderHistory(id));
    }
}
