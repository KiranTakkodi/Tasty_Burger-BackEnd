package com.example.UserDataApi.Service.impl;

import com.example.UserDataApi.DTO.OrderDTO.OrderHistoryResponseDto;
import com.example.UserDataApi.DTO.OrderDTO.OrderResponseDTO;
import com.example.UserDataApi.DTO.OrderItemDTO.OrderItemResponseDtos;
import com.example.UserDataApi.Entity.CartItem;
import com.example.UserDataApi.Entity.OrderItems;
import com.example.UserDataApi.Entity.Orders;
import com.example.UserDataApi.Entity.User;
import com.example.UserDataApi.Repository.CartRepository;
import com.example.UserDataApi.Repository.OrderRepository;
import com.example.UserDataApi.Repository.UserRepository;
import com.example.UserDataApi.Service.OrderService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class Ordersimpl implements OrderService {

    private final UserRepository userRepository;
    private final CartRepository cartRepository;
    private final OrderRepository orderRepository;
    private final ModelMapper mapper;

    @Transactional
    @Override
    public OrderResponseDTO PlaceOrder(Long id) {
        User user=userRepository.findById(id).orElseThrow(()->new EntityNotFoundException("User Not Found"));
        List<CartItem> cartItemList=cartRepository.findByUserId(id);

        if(cartItemList.isEmpty()){
            throw  new RuntimeException("Cart is Empty");
        }

        Orders order=new Orders();
        order.setUser(user);
        order.setStatus("PLACED");
        order.setOrderDateTime(LocalDateTime.now());

        double total=0;

        List<OrderItems>orderItems=new ArrayList<>();
        for(CartItem cart:cartItemList){
            OrderItems items=new OrderItems();
            items.setOrders(order);
            items.setQuantity(cart.getQuantity());
            items.setPrice(cart.getPrice());
            items.setProductName(cart.getName());

            total+=cart.getQuantity()*cart.getPrice();
            orderItems.add(items);
        }
        order.setTotalAmount(total);
        order.setOrderItems(orderItems);

        orderRepository.save(order);

        cartRepository.deleteByUserId(id);
        return  new OrderResponseDTO(
                order.getId(),
                order.getTotalAmount(),
                order.getStatus()
        );

    }

    @Override
    public List<OrderHistoryResponseDto> GetOrderHistory(Long id) {
        List<Orders>orders=orderRepository.findByUserId(id);
        return orders.stream().map(order->{List<OrderItemResponseDtos>dtos=
                order.getOrderItems()
                        .stream()
                        .map(item->mapper.map(item,OrderItemResponseDtos.class))
                        .toList();
            return new OrderHistoryResponseDto(
                    order.getId(),
                    order.getTotalAmount(),
                    order.getStatus(),
                    dtos
            );
        }).toList();
    }

    @Transactional
    @Override
    public int autoDeliverOrders() {
       LocalDateTime twoMinAgo=LocalDateTime.now().minusMinutes(2);
       return orderRepository.markDelivered(twoMinAgo);
    }
}
