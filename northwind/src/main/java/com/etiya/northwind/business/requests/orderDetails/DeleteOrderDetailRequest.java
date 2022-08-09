package com.etiya.northwind.business.requests.orderDetails;

import com.etiya.northwind.entities.concretes.OrderDetail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteOrderDetailRequest {
    private OrderDetail orderDetail;
}
