package com.example.UserDataApi.Service.impl;

import com.example.UserDataApi.DTO.ProductDTO.ProductDataDTO;
import com.example.UserDataApi.Entity.Products;
import com.example.UserDataApi.Repository.ProductsRepository;
import com.example.UserDataApi.Service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class Productsimpl implements ProductService {
    private final ProductsRepository productsRepository;
    @Override
    public List<ProductDataDTO> getAllBurgers() {
        List<Products>products=productsRepository.findAll();
        return products.stream().map(p->new ProductDataDTO(
                p.getId(),
                p.getName(),
                p.getPrice(),
                p.getAbout(),
                p.getImage(),
                p.getRating()
        )).toList();
    }
}
