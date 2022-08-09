package com.etiya.northwind.business.concretes;


import com.etiya.northwind.business.abstracts.OrderService;
import com.etiya.northwind.business.requests.orders.CreateOrderRequest;
import com.etiya.northwind.business.requests.orders.DeleteOrderRequest;
import com.etiya.northwind.business.requests.orders.UpdateOrderRequest;
import com.etiya.northwind.business.responses.orderDetails.GetOrderDetailByIdResponse;
import com.etiya.northwind.business.responses.orders.OrderListResponse;
import com.etiya.northwind.core.utilities.mapping.ModelMapperService;
import com.etiya.northwind.dataAccess.abstracts.OrderRepository;
import com.etiya.northwind.entities.concretes.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderManager implements OrderService {
    private OrderRepository orderRepository;
    private ModelMapperService modelMapperService;

    @Autowired
    public OrderManager(OrderRepository orderRepository,ModelMapperService modelMapperService) {
        this.modelMapperService=modelMapperService;
        this.orderRepository = orderRepository;
    }

    @Override
    public void add(CreateOrderRequest createOrderRequest) {

    }

    @Override
    public void update(UpdateOrderRequest updateOrderRequest) {

    }

    @Override
    public void delete(DeleteOrderRequest deleteOrderRequest) {

    }

    @Override
    public GetOrderDetailByIdResponse getById(int id) {
        return null;
    }

    @Override
    public List<OrderListResponse> getAll() {
        List<Order> result = this.orderRepository.findAll();
        List<OrderListResponse> responses = result.stream().map(order -> this.modelMapperService.forResponse().map(order,OrderListResponse.class)).collect(Collectors.toList());

        return responses;
    }
}