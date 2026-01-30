package com.example.UserDataApi.Repository;


import com.example.UserDataApi.Entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepository extends JpaRepository<Products,Long> {
}
