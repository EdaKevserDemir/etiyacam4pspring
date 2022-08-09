package com.etiya.northwind.business.abstracts;
import com.etiya.northwind.business.requests.categories.CreateCategoryRequest;
import com.etiya.northwind.business.requests.customers.CreateCustomerRequest;
import com.etiya.northwind.business.requests.customers.DeleteCustomerRequest;
import com.etiya.northwind.business.requests.customers.UpdateCustomerRequest;
import com.etiya.northwind.business.responses.customers.CustomerListResponse;
import com.etiya.northwind.business.responses.customers.GetCustomerByIdResponse;
import com.etiya.northwind.entities.concretes.Customer;


import java.util.List;

public interface CustomerService {
    void add(CreateCustomerRequest createCustomerRequest);
    void update(UpdateCustomerRequest updateCustomerRequest);
    void delete(DeleteCustomerRequest deleteCustomerRequest);
    GetCustomerByIdResponse getById(int id);
    List<CustomerListResponse> getAll();
}
