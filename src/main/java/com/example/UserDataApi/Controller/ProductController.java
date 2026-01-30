package com.example.UserDataApi.Controller;


import com.example.UserDataApi.DTO.ProductDTO.ProductDataDTO;
import com.example.UserDataApi.Service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/TastyBurgers/Data")
    public ResponseEntity<List<ProductDataDTO>>GettAllBurgers(){
        return  ResponseEntity.ok(productService.getAllBurgers());
    }
}
