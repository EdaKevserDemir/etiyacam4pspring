package com.etiya.northwind.dataAccess.abstracts;

import com.etiya.northwind.entities.concretes.Cart;
import com.etiya.northwind.entities.concretes.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart,Integer> {
    Cart findByCartId(int cartId);

    Cart findCustomerByCartId(String customerId);
    List<Cart> findCartByCartId(int cartId);
}
