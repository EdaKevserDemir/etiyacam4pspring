package com.etiya.northwind.business.concretes;

import com.etiya.northwind.business.abstracts.OrderDetailService;
import com.etiya.northwind.business.responses.orderDetails.OrderDetailListResponse;
import com.etiya.northwind.core.utilities.mapping.ModelMapperService;
import com.etiya.northwind.dataAccess.abstracts.OrderDetailRepository;
import com.etiya.northwind.entities.concretes.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderDetailManager implements OrderDetailService {

    private OrderDetailRepository orderDetailRepository;
    private ModelMapperService modelMapperService;

    @Autowired
    public OrderDetailManager(OrderDetailRepository orderDetailRepository,ModelMapperService modelMapperService) {
        this.orderDetailRepository = orderDetailRepository;
        this.modelMapperService=modelMapperService;
    }

    @Override
    public List<OrderDetailListResponse> getAll() {
        List<OrderDetail> result=this.orderDetailRepository.findAll();
        List<OrderDetailListResponse> responses = result.stream().map(orderDetail -> this.modelMapperService.forResponse().map(orderDetail,OrderDetailListResponse.class)).collect(Collectors.toList());

        return responses;
    }
}