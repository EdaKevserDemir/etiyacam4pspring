package com.etiya.northwind.business.responses.orderDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetOrderDetailByIdResponse {
    private int orderId;
    private int productId;
    private String productName;
    private int quantity;
}
