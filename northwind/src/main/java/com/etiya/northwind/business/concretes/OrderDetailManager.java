package com.etiya.northwind.business.concretes;

import com.etiya.northwind.business.abstracts.OrderDetailService;
import com.etiya.northwind.business.requests.orderDetails.CreateOrderDetailRequest;
import com.etiya.northwind.business.requests.orderDetails.DeleteOrderDetailRequest;
import com.etiya.northwind.business.requests.orderDetails.UpdateOrderDetailRequest;
import com.etiya.northwind.business.responses.orderDetails.GetOrderDetailByIdResponse;
import com.etiya.northwind.business.responses.orderDetails.OrderDetailListResponse;
import com.etiya.northwind.core.utilities.mapping.ModelMapperService;
import com.etiya.northwind.dataAccess.abstracts.OrderDetailRepository;
import com.etiya.northwind.entities.concretes.Order;
import com.etiya.northwind.entities.concretes.OrderDetail;
import com.etiya.northwind.entities.concretes.OrderDetailId;
import com.etiya.northwind.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    public void add(CreateOrderDetailRequest createOrderDetailReqest) {

        OrderDetail orderDetail=this.modelMapperService.forRequest().map(createOrderDetailReqest,OrderDetail.class);
        this.orderDetailRepository.save(orderDetail);

    }

    @Override
    public void update(UpdateOrderDetailRequest updateOrderDetailRequest) {
        OrderDetail orderDetail=this.modelMapperService.forRequest().map(updateOrderDetailRequest,OrderDetail.class);
        this.orderDetailRepository.save(orderDetail);
    }

    @Override
    public void delete(DeleteOrderDetailRequest deleteOrderDetailrequest) {

     //   this.orderDetailRepository.deleteById(deleteOrderDetailrequest.getOrderDetail().);
    }

    @Override
    public GetOrderDetailByIdResponse getById(int id) {



        return null;
    }

    @Override
    public List<OrderDetailListResponse> getAll() {
        List<OrderDetail> result=this.orderDetailRepository.findAll();
        List<OrderDetailListResponse> responses = result.stream().map(orderDetail -> this.modelMapperService.forResponse().map(orderDetail,OrderDetailListResponse.class)).collect(Collectors.toList());

        return responses;
    }

    @Override
    public Map<String, Object> getAllPages(int pageNumber, int pageSize) {
        Pageable pageable= PageRequest.of(pageNumber-1,pageSize);
        return pageableMap(pageable);
    }

    @Override
    public Map<String, Object> getAllPagesOrderByEntity(int pageNumber, int pageSize, String entity, String type) {
        Pageable pageable=PageRequest.of(pageNumber-1,pageSize,sortType(entity,type));
        return   pageableMap(pageable);

    }

    private Map<String, Object> pageableMap(Pageable pageable){
        Map<String,Object> response=new HashMap<>();
        Page<OrderDetail> orderDetails =orderDetailRepository.findAll(pageable);
        response.put("totalElements",orderDetails.getTotalElements()) ;
        response.put("totalPages",orderDetails.getTotalPages());
        response.put("currentPage",orderDetails.getNumber()+1);
        response.put("orderDetail",orderDetails.getContent().stream().map(orderDetail ->
                this.modelMapperService.forResponse().map(orderDetail, OrderDetailListResponse.class)).collect(Collectors.toList()));

        return response ;
    }
    public Sort sortType(String property, String type){
        if(type.equals("desc"))
            return Sort.by(property).descending();
        else return Sort.by(property).ascending() ;

    }
}