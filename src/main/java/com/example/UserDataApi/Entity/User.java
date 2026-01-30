package com.example.UserDataApi.Entity;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.engine.internal.Cascade;

import java.util.ArrayList;
import java.util.List;


@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;

    @Column(unique = true)
    private String email;
    private String password;

    @Column(length = 15,unique = true)
    private  String phonenumber;

    @Column(length = 500)
    private String Address;

    @OneToMany(mappedBy = "user", cascade=CascadeType.ALL,orphanRemoval = true)
    private List<CartItem>itemsList=new ArrayList<>();

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Orders>OrderList=new ArrayList<>();

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Liked>likedList=new ArrayList<>();
}
