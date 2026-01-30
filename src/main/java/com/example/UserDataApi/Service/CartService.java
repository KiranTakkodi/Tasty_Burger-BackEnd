package com.example.UserDataApi.Service;

import com.example.UserDataApi.DTO.CartDTO.AddItemDTO;
import com.example.UserDataApi.DTO.CartDTO.CartResponseDTO;

import java.util.List;

public interface CartService {
    CartResponseDTO AddItemsToCart(AddItemDTO addItemDTO);
    List<CartResponseDTO> getAllItems(Long UserId);
    void AddQuantity(Long id);

    void ReduceQuantity(Long id);

    void DeleteItem(Long id);

//    void UpdateFavrites(Long id);
}
