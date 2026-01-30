package com.example.UserDataApi.Service.impl;

import com.example.UserDataApi.DTO.LikedDTO.LikedResponseDto;
import com.example.UserDataApi.DTO.LikedDTO.likedDto;
import com.example.UserDataApi.Entity.Liked;
import com.example.UserDataApi.Entity.Products;
import com.example.UserDataApi.Entity.User;
import com.example.UserDataApi.Repository.LikedRepository;
import com.example.UserDataApi.Repository.ProductsRepository;
import com.example.UserDataApi.Repository.UserRepository;
import com.example.UserDataApi.Service.LikedService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class Likedimpl implements LikedService {
    private final LikedRepository likedRepository;
    private final UserRepository userRepository;
    private final ProductsRepository productsRepository;

    @Transactional
    @Override
    public LikedResponseDto toggleLike(Long userId, Long productId) {
       if(likedRepository.existsByUserIdAndProductId(userId,productId)){
           likedRepository.deleteByUserIdAndProductId(userId,productId);
           return new LikedResponseDto(productId,false);
       }else{
           User user=userRepository.findById(userId).orElseThrow();
           Products products=productsRepository.findById(productId).orElseThrow();

           Liked liked=new Liked();
           liked.setUser(user);
           liked.setProduct(products);


           likedRepository.save(liked);
           return  new LikedResponseDto(productId,true);
       }
    }

    @Override
    public List<likedDto> getFavourites(Long id) {
       List<Liked>likedList=likedRepository.findByUserId(id);

       return likedList.stream().map(Favorite-> {
           Products p = Favorite.getProduct();
           return new likedDto(
                   p.getName(),
                   p.getImage(),
                   p.getId()
           );
       }).toList();
    }
}
