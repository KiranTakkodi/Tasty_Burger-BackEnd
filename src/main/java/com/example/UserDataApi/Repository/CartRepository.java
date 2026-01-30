package com.example.UserDataApi.Repository;

import com.example.UserDataApi.Entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Collection;
import java.util.Optional;
import  java.util.List;

public interface CartRepository extends JpaRepository<CartItem,Long> {
//    Optional<CartItem>findByName(String name);
    Optional<CartItem> findByUserIdAndName(Long userId, String name);

    List<CartItem> findByUserId(Long id);

    void deleteByUserId(Long id);
//    List<CartItem>findByUserId(Long id);
}
