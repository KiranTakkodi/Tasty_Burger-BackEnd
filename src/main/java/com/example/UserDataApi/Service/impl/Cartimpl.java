package com.example.UserDataApi.Service.impl;

import com.example.UserDataApi.DTO.CartDTO.AddItemDTO;
import com.example.UserDataApi.DTO.CartDTO.CartResponseDTO;
import com.example.UserDataApi.Entity.CartItem;
import com.example.UserDataApi.Entity.User;
import com.example.UserDataApi.Repository.CartRepository;
import com.example.UserDataApi.Repository.UserRepository;
import com.example.UserDataApi.Service.CartService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class Cartimpl implements CartService {
    private final CartRepository cartRepository;
    private final ModelMapper mapper;
    private final UserRepository userRepository;

    @Override
    public CartResponseDTO AddItemsToCart(AddItemDTO addItemDTO) {
        User user = userRepository.findById(addItemDTO.getUserid())
                .orElseThrow(() -> new RuntimeException("User not found"));

        // 2. Check if item already exists for this user
        Optional<CartItem> optionalItem = cartRepository.findByUserIdAndName(user.getId(), addItemDTO.getName());

        CartItem item;

        if (optionalItem.isPresent()) {
            // 3. Increase quantity
            item = optionalItem.get();
            item.setQuantity(item.getQuantity() + 1);
        } else {
            // 4. Create new cart item
            item = mapper.map(addItemDTO, CartItem.class);
            item.setUser(user);        // IMPORTANT
            item.setQuantity(1);
            user.getItemsList().add(item);
        }

        // 5. Save item
        CartItem savedItem = cartRepository.save(item);

        // 6. Return response
        return new CartResponseDTO(
                savedItem.getId(),
                savedItem.getName(),
                savedItem.getImage(),
                savedItem.getPrice(),
                savedItem.getRatings(),
                savedItem.getAbout(),
                savedItem.getQuantity()
        );
    }

    @Override
    public List<CartResponseDTO> getAllItems(Long UserId) {

        return cartRepository.findByUserId(UserId)
                .stream()
                .map(item -> new CartResponseDTO(
                        item.getId(),
                        item.getName(),
                        item.getImage(),
                        item.getPrice(),
                        item.getRatings(),
                        item.getAbout(),
                        item.getQuantity()
                ))
                .toList();
    }

    @Transactional
    @Override
    public void AddQuantity(Long id) {
        CartItem item = cartRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Item Not Found"));
        item.setQuantity(item.getQuantity() + 1);
    }

    @Transactional
    @Override
    public void ReduceQuantity(Long id) {
        CartItem item = cartRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Item Not Found"));
        if (item.getQuantity() == 0) {
            return;
        }
        item.setQuantity(item.getQuantity() - 1);
    }

    @Transactional
    @Override
    public void DeleteItem(Long id) {
        CartItem item = cartRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Item Not Found"));
        cartRepository.delete(item);
    }


}
