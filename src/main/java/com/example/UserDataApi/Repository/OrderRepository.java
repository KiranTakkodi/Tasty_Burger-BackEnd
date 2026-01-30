package com.example.UserDataApi.Repository;

import com.example.UserDataApi.Entity.Orders;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderRepository extends JpaRepository<Orders,Long> {
    List<Orders> findByUserId(Long id);

    @Modifying
    @Query(value = "update Orders set status='DELIVERED' where status='PLACED' and order_date_time<=:cutoff",nativeQuery = true)
    int markDelivered(@Param("cutoff")LocalDateTime cutoff);
}
