package com.etiya.northwind.api.controllers;

import com.etiya.northwind.business.abstracts.OrderService;

import com.etiya.northwind.business.requests.orders.CreateOrderRequest;
import com.etiya.northwind.business.requests.orders.DeleteOrderRequest;
import com.etiya.northwind.business.requests.orders.UpdateOrderRequest;

import com.etiya.northwind.business.responses.orders.GetOrderByIdResponse;
import com.etiya.northwind.business.responses.orders.OrderListResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/orders")
public class OrdersController {
    private OrderService orderService;

    @Autowired
    public OrdersController(OrderService orderService) {

        this.orderService = orderService;
    }

    @PostMapping("/add")
    public void add(@RequestBody CreateOrderRequest createOrderRequest){
        this.orderService.add(createOrderRequest);

    }

    @PostMapping("/update")
    public void update(@RequestBody UpdateOrderRequest updateOrderRequest){
        this.orderService.update(updateOrderRequest);

    }
    @PostMapping("/delete")
    public void delete(@RequestBody DeleteOrderRequest deleteOrderRequest){
        this.orderService.delete(deleteOrderRequest);
    }


    @GetMapping("/getAll")
    public List<OrderListResponse> getAll() {

        return this.orderService.getAll();
    }
    @GetMapping("/getbyid")
    public GetOrderByIdResponse getById(@RequestParam int id){

        return this.orderService.getById(id);
    }

    @GetMapping("/getallpages")
    public Map<String,Object> getAllPages(@RequestParam int pageNumber, @RequestParam int pageSize){

        return this.orderService.getAllPages(pageNumber,pageSize);

    }

    @GetMapping("/getallpagesorderbyentity")
    public Map<String,Object> getAllPagesOrderByEntity(@RequestParam int pageNumber,@RequestParam int pageSize,@RequestParam String entity,@RequestParam Optional<String> type){

        return this.orderService.getAllPagesOrderByEntity(pageNumber,pageSize, entity,type.orElse(""));

    }

}