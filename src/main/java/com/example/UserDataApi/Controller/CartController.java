package com.example.UserDataApi.Controller;


import com.example.UserDataApi.DTO.CartDTO.AddItemDTO;
import com.example.UserDataApi.DTO.CartDTO.CartResponseDTO;
import com.example.UserDataApi.Repository.CartRepository;
import com.example.UserDataApi.Service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;

    @PostMapping("/user/AddItems")
    public ResponseEntity<CartResponseDTO>AddItemsToCart(@RequestBody AddItemDTO addItemDTO){
        return ResponseEntity.ok(cartService.AddItemsToCart(addItemDTO));
    }

    @GetMapping("/user/CartItems/{id}")
    public ResponseEntity<List<CartResponseDTO>>GettAllItemsFromCart(@PathVariable Long id){
        return ResponseEntity.ok(cartService.getAllItems(id));
    }

    @PatchMapping("/user/AddQuantity/{id}")
    public ResponseEntity<Void> AddQuantity(@PathVariable Long id){
         cartService.AddQuantity(id);
         return ResponseEntity.ok().build();
    }
    @PatchMapping("/user/ReduceQuantity/{id}")
    public ResponseEntity<Void> ReduceQuantity(@PathVariable Long id){
        cartService.ReduceQuantity(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/user/Delete/{id}")
    public ResponseEntity<Void>DeleteItem(@PathVariable Long id){
        cartService.DeleteItem(id);
        return ResponseEntity.noContent().build();
    }

//    @PatchMapping("/user/Favorites/{id}")
//    public ResponseEntity<Void> Favorites(@PathVariable Long id){
//        cartService.UpdateFavrites(id);
//        return ResponseEntity.ok().build();
//    }
}
