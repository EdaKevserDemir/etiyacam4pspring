package com.etiya.northwind.api.controllers;

import com.etiya.northwind.business.abstracts.CustomerService;
import com.etiya.northwind.business.requests.customers.CreateCustomerRequest;
import com.etiya.northwind.business.requests.customers.DeleteCustomerRequest;
import com.etiya.northwind.business.requests.customers.UpdateCustomerRequest;
import com.etiya.northwind.business.responses.customers.CustomerListResponse;
import com.etiya.northwind.business.responses.customers.GetCustomerByIdResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/customers")
public class CustomersController {

    private CustomerService customerService;

    @Autowired
    public CustomersController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/add")
    public void add(@RequestBody CreateCustomerRequest createCustomerRequest){
        this.customerService.add(createCustomerRequest);

    }

    @PostMapping("/update")
    public void update(@RequestBody UpdateCustomerRequest updateCustomerRequest){
        this.customerService.update(updateCustomerRequest);

    }
    @PostMapping("/delete")
    public void delete(@RequestBody DeleteCustomerRequest deleteCustomerRequest){
        this.customerService.delete(deleteCustomerRequest);
    }


    @GetMapping("/getAll")
    public List<CustomerListResponse> getAll() {

        return this.customerService.getAll();
    }
    @GetMapping("/getbyid")
    public GetCustomerByIdResponse getById(@RequestParam String id){

        return this.customerService.getById(id);
    }

    @GetMapping("/getallpages")
    public Map<String,Object> getAllPages(@RequestParam int pageNumber, @RequestParam int pageSize){

        return this.customerService.getAllPages(pageNumber,pageSize);

    }

    @GetMapping("/getallpagesorderbyentity")
    public Map<String,Object> getAllPagesOrderByEntity(@RequestParam int pageNumber,@RequestParam int pageSize,@RequestParam String entity,@RequestParam Optional<String> type){

        return this.customerService.getAllPagesOrderByEntity(pageNumber,pageSize, entity,type.orElse(""));

    }

}