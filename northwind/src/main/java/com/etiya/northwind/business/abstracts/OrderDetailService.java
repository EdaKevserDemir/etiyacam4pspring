package com.etiya.northwind.business.abstracts;

import com.etiya.northwind.business.requests.orderDetails.CreateOrderDetailRequest;
import com.etiya.northwind.business.requests.orderDetails.DeleteOrderDetailRequest;
import com.etiya.northwind.business.requests.orderDetails.UpdateOrderDetailRequest;
import com.etiya.northwind.business.responses.orderDetails.GetOrderDetailByIdResponse;
import com.etiya.northwind.business.responses.orderDetails.OrderDetailListResponse;

import java.util.List;

public interface OrderDetailService {
    void add(CreateOrderDetailRequest createOrderDetailReqest);
    void update(UpdateOrderDetailRequest updateOrderDetailRequest);
    void delete(DeleteOrderDetailRequest deleteOrderDetailrequest);
    GetOrderDetailByIdResponse getById(int id);
    List<OrderDetailListResponse>getAll();
}
