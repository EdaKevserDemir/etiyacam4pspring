package com.etiya.northwind.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cartProductDetails")

public class CartProductDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cart_product_detail_id")
    private int cartProductDetailId;

    @OneToMany(mappedBy = "cartProductDetail")
    private List<Product>products;

    @OneToMany(mappedBy = "cartProductDetail")
    private List<Cart>carts;



}
