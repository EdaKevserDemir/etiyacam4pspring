package com.etiya.northwind.dataAccess.concretes.responses.carts;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartListResponse {
    private String customerId;
    private int productId;
    private String productName;
    private int unitsInStock;
}
