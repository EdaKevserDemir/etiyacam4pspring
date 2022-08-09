package com.etiya.northwind.api.controllers;

import com.etiya.northwind.business.abstracts.EmployeeService;
import com.etiya.northwind.business.requests.employees.CreateEmployeeRequest;
import com.etiya.northwind.business.requests.employees.DeleteEmployeeRequest;
import com.etiya.northwind.business.requests.employees.UpdateEmployeeRequest;

import com.etiya.northwind.business.responses.employees.EmployeeListResponse;
import com.etiya.northwind.business.responses.employees.GetEmployeeByIdResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
public class EmployeesController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeesController(EmployeeService categoryService) {

        this.employeeService = categoryService;
    }

    @PostMapping("/add")
    public void add(@RequestBody CreateEmployeeRequest createEmployeeRequest){
        this.employeeService.add(createEmployeeRequest);

    }

    @PostMapping("/update")
    public void update(@RequestBody UpdateEmployeeRequest updateEmployeeRequest){
        this.employeeService.update(updateEmployeeRequest);

    }
    @PostMapping("/delete")
    public void delete(@RequestBody DeleteEmployeeRequest deleteEmployeeRequest){
        this.employeeService.delete(deleteEmployeeRequest);
    }


    @GetMapping("/getAll")
    public List<EmployeeListResponse> getAll() {

        return this.employeeService.getAll();
    }
    @GetMapping("/getbyid")
    public GetEmployeeByIdResponse getById(@RequestParam int id){

        return this.employeeService.getById(id);
    }

    @GetMapping("/getallpages")
    public Map<String,Object> getAllPages(@RequestParam int pageNumber, @RequestParam int pageSize){

        return this.employeeService.getAllPages(pageNumber,pageSize);

    }

    @GetMapping("/getallpagesorderbyentity")
    public Map<String,Object> getAllPagesOrderByEntity(@RequestParam int pageNumber,@RequestParam int pageSize,@RequestParam String entity,@RequestParam Optional<String> type){

        return this.employeeService.getAllPagesOrderByEntity(pageNumber,pageSize, entity,type.orElse(""));

    }



}
