package com.etiya.northwind.business.responses.products;

import com.etiya.northwind.entities.concretes.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetProductByIdResponse {
    private int productId;

    private String productName;

    private double unitPrice;

    private int unitsInStock;

    private Category categoryId;

    private Category categoryName;
}
