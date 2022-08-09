package com.etiya.northwind.business.abstracts;

import com.etiya.northwind.business.requests.employees.CreateEmployeeRequest;
import com.etiya.northwind.business.requests.employees.DeleteEmployeeRequest;
import com.etiya.northwind.business.requests.employees.UpdateEmployeeRequest;
import com.etiya.northwind.business.responses.employees.EmployeeListResponse;
import com.etiya.northwind.business.responses.employees.GetEmployeeByIdResponse;

import java.util.List;

public interface EmployeeService {
    void add(CreateEmployeeRequest createEmployeeRequest);
    void update(UpdateEmployeeRequest updateEmployeeRequest);
    void delete(DeleteEmployeeRequest deleteEmployeeRequest);
    GetEmployeeByIdResponse getById(String id);
    List<EmployeeListResponse>getAll();
}
