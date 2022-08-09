package com.etiya.northwind.business.abstracts;

import com.etiya.northwind.business.requests.orders.CreateOrderRequest;
import com.etiya.northwind.business.requests.orders.DeleteOrderRequest;
import com.etiya.northwind.business.requests.orders.UpdateOrderRequest;
import com.etiya.northwind.business.responses.orderDetails.GetOrderDetailByIdResponse;
import com.etiya.northwind.business.responses.orders.OrderListResponse;

import java.util.List;

public interface OrderService {
    void add(CreateOrderRequest createOrderRequest);
    void update(UpdateOrderRequest updateOrderRequest);
    void delete(DeleteOrderRequest deleteOrderRequest);
    GetOrderDetailByIdResponse getById(int id);
    List<OrderListResponse> getAll();
}
