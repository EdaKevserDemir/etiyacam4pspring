package com.etiya.northwind.business.concretes;

import com.etiya.northwind.business.abstracts.CustomerService;
import com.etiya.northwind.business.requests.categories.CreateCategoryRequest;
import com.etiya.northwind.business.requests.customers.CreateCustomerRequest;
import com.etiya.northwind.business.requests.customers.DeleteCustomerRequest;
import com.etiya.northwind.business.requests.customers.UpdateCustomerRequest;
import com.etiya.northwind.business.responses.customers.CustomerListResponse;
import com.etiya.northwind.business.responses.customers.GetCustomerByIdResponse;
import com.etiya.northwind.core.utilities.mapping.ModelMapperService;
import com.etiya.northwind.dataAccess.abstracts.CustomerRepository;
import com.etiya.northwind.entities.concretes.Category;
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
    public void add(CreateCustomerRequest createCustomerRequest) {

        Customer customer=this.modelMapperService.forResponse().map(createCustomerRequest, Customer.class);
        customerRepository.save(customer);
    }

    @Override
    public void update(UpdateCustomerRequest updateCustomerRequest) {

        Customer customer=this.modelMapperService.forResponse().map(updateCustomerRequest,Customer.class);
    }

    @Override
    public void delete(DeleteCustomerRequest deleteCustomerRequest) {

    }

    @Override
    public GetCustomerByIdResponse getById(int id) {
        return null;
    }

    @Override
    public List<CustomerListResponse> getAll() {
        List<Customer> result = this.customerRepository.findAll();
        List<CustomerListResponse> responses = result.stream().map(customer -> this.modelMapperService.forResponse().
                map(customer, CustomerListResponse.class)).collect(Collectors.toList());

        return responses;
    }
}
