package com.example.UserDataApi.Service;

import com.example.UserDataApi.DTO.ProductDTO.ProductDataDTO;

import java.util.List;

public interface ProductService {
    List<ProductDataDTO> getAllBurgers();
}
