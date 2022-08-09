package com.etiya.northwind.business.concretes;

import com.etiya.northwind.business.abstracts.CustomerService;
import com.etiya.northwind.business.responses.customers.CustomerListResponse;
import com.etiya.northwind.core.utilities.mapping.ModelMapperService;
import com.etiya.northwind.dataAccess.abstracts.CustomerRepository;
import com.etiya.northwind.entities.concretes.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerManager implements CustomerService {

    private CustomerRepository customerRepository;
    private ModelMapperService modelMapperService;

    @Autowired
    public CustomerManager(CustomerRepository customerRepository,ModelMapperService modelMapperService) {

        this.modelMapperService=modelMapperService;
        this.customerRepository = customerRepository;
    }

    @Override
    public List<CustomerListResponse> getAll() {
        List<Customer> result = this.customerRepository.findAll();
        List<CustomerListResponse> responses = result.stream().map(customer->this.modelMapperService.forResponse().map(customer,CustomerListResponse.class)).collect(Collectors.toList());

        return responses;
    }
}