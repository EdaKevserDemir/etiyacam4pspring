package com.etiya.northwind.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="carts")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cart_id")
    private int cartId;

    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;

    @OneToOne
    @JoinColumn(name = "customer_id",unique = true)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name="cart_product_detail_id")
    private CartProductDetail cartProductDetail;

    @Column(name="unit_price")
    private double unitPrice;

    @Column(name="quantity")
    private int quantity;

}

