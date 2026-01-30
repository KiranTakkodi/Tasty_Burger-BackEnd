package com.example.UserDataApi.Service.impl;


import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderScheduler {
    private  final Ordersimpl ordersimpl;

    @Transactional
    @Scheduled(fixedRate = 30000)
    public  void Deliver(){
        ordersimpl.autoDeliverOrders();
    }
}
