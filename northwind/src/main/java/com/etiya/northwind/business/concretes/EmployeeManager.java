package com.etiya.northwind.business.concretes;

import com.etiya.northwind.business.abstracts.EmployeeService;
import com.etiya.northwind.business.requests.employees.CreateEmployeeRequest;
import com.etiya.northwind.business.requests.employees.DeleteEmployeeRequest;
import com.etiya.northwind.business.requests.employees.UpdateEmployeeRequest;
import com.etiya.northwind.business.responses.employees.EmployeeListResponse;
import com.etiya.northwind.business.responses.employees.GetEmployeeByIdResponse;
import com.etiya.northwind.core.utilities.mapping.ModelMapperService;
import com.etiya.northwind.dataAccess.abstracts.EmployeeRepository;
import com.etiya.northwind.entities.concretes.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeManager implements EmployeeService {

    private EmployeeRepository employeeRepository;
    private ModelMapperService modelMapperService;

    @Autowired
    public EmployeeManager(EmployeeRepository employeeRepository,ModelMapperService modelMapperService) {

        this.modelMapperService=modelMapperService;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void add(CreateEmployeeRequest createEmployeeRequest) {

    }

    @Override
    public void update(UpdateEmployeeRequest updateEmployeeRequest) {

    }

    @Override
    public void delete(DeleteEmployeeRequest deleteEmployeeRequest) {

    }

    @Override
    public GetEmployeeByIdResponse getById(String id) {
        return null;
    }

    @Override
    public List<EmployeeListResponse> getAll() {
        List<Employee> results = this.employeeRepository.findAll();
        List<EmployeeListResponse> responses = results.stream().map(employee -> this.modelMapperService.forResponse().map(employee,EmployeeListResponse.class)).collect(Collectors.toList());
        return responses;
    }
}