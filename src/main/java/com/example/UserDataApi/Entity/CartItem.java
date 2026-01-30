package com.example.UserDataApi.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String image;
    private double price;
    private  double ratings;
    @Column(length = 100)
    private String about;
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
