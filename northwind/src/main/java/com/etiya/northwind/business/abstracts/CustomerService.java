package com.etiya.northwind.business.abstracts;
import com.etiya.northwind.business.requests.customers.CreateCustomerRequest;
import com.etiya.northwind.business.requests.customers.DeleteCustomerRequest;
import com.etiya.northwind.business.requests.customers.UpdateCustomerRequest;
import com.etiya.northwind.dataAccess.concretes.responses.customers.CustomerListResponse;
import com.etiya.northwind.dataAccess.concretes.responses.customers.GetCustomerByIdResponse;
import com.etiya.northwind.core.utilities.results.DataResult;
import com.etiya.northwind.core.utilities.results.Result;


import java.util.List;
import java.util.Map;

public interface CustomerService {
    Result add(CreateCustomerRequest createCustomerRequest);
    Result update(UpdateCustomerRequest updateCustomerRequest);
    Result delete(DeleteCustomerRequest deleteCustomerRequest);

    DataResult<GetCustomerByIdResponse> getById(String id);
    DataResult<List<CustomerListResponse>> getAll();

    Map<String,Object> getAllPages(int pageNumber, int pageSize);

    Map<String,Object>getAllPagesOrderByEntity(int pageNumber, int pageSize,String entity,String type);
}
