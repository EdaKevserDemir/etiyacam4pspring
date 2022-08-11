package com.etiya.northwind.business.concretes;

import com.etiya.northwind.business.abstracts.EmployeeService;
import com.etiya.northwind.business.requests.employees.CreateEmployeeRequest;
import com.etiya.northwind.business.requests.employees.DeleteEmployeeRequest;
import com.etiya.northwind.business.requests.employees.UpdateEmployeeRequest;
import com.etiya.northwind.dataAccess.concretes.responses.employees.EmployeeListResponse;
import com.etiya.northwind.dataAccess.concretes.responses.employees.GetEmployeeByIdResponse;
import com.etiya.northwind.core.exceptions.BusinessException;
import com.etiya.northwind.core.utilities.mapping.ModelMapperService;
import com.etiya.northwind.core.utilities.results.DataResult;
import com.etiya.northwind.core.utilities.results.Result;
import com.etiya.northwind.core.utilities.results.SuccessDataResult;
import com.etiya.northwind.core.utilities.results.SuccessResult;
import com.etiya.northwind.dataAccess.abstracts.EmployeeRepository;
import com.etiya.northwind.entities.concretes.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    public Result add(CreateEmployeeRequest createEmployeeRequest) {
        checkIfSameReportToPerson(createEmployeeRequest.getReportsTo());
        Employee employee=this.modelMapperService.forRequest().map(createEmployeeRequest,Employee.class);
        employeeRepository.save(employee);
        return new SuccessResult();
    }

    @Override
    public Result update(UpdateEmployeeRequest updateEmployeeRequest) {
        Employee employee=this.modelMapperService.forRequest().map(updateEmployeeRequest,Employee.class);
        employeeRepository.save(employee);

        return new SuccessResult();

    }

    @Override
    public Result delete(DeleteEmployeeRequest deleteEmployeeRequest) {

        this.employeeRepository.deleteById(deleteEmployeeRequest.getEmployeeId());
        return new SuccessResult();
    }

    @Override
    public DataResult<GetEmployeeByIdResponse> getById(int id) {

        Employee employee=this.employeeRepository.findById(id);
        GetEmployeeByIdResponse getEmployeeByIdResponse=this.modelMapperService.forResponse().map(employee,GetEmployeeByIdResponse.class);
        return new SuccessDataResult<>(getEmployeeByIdResponse) ;

    }

    @Override
    public DataResult<List<EmployeeListResponse>> getAll() {
        List<Employee> results = this.employeeRepository.findAll();
        List<EmployeeListResponse> responses = results.stream().map(employee -> this.modelMapperService.forResponse().map(employee,EmployeeListResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<>(responses);
    }

    @Override
    public Map<String, Object> getAllPages(int pageNumber, int pageSize) {
        Pageable pageable= PageRequest.of(pageNumber-1,pageSize);
        Map<String,Object> response=new HashMap<>();

        Page<Employee> employees =employeeRepository.findAll(pageable);
        response.put("totalElements",employees.getTotalElements()) ;
        response.put("totalPages",employees.getTotalPages());
        response.put("currentPage",employees.getNumber()+1);
        response.put("employeers",employees.getContent().stream().map(employee ->
                this.modelMapperService.forResponse().map(employee, EmployeeListResponse.class)).collect(Collectors.toList()));

        return response ;
    }

    @Override
    public Map<String, Object> getAllPagesOrderByEntity(int pageNumber, int pageSize, String entity, String type) {
        Pageable pageable=PageRequest.of(pageNumber-1,pageSize,sortType(entity,type));


        Map<String,Object> response=new HashMap<>();
        Page<Employee>categories =employeeRepository.findAll(pageable);
        response.put("totalElements",categories.getTotalElements()) ;
        response.put("totalPages",categories.getTotalPages());
        response.put("currentPage",categories.getNumber()+1);
        response.put("employeers",categories.getContent().stream().map(employee ->
                this.modelMapperService.forResponse().map(employee,EmployeeListResponse.class)).collect(Collectors.toList()));

        return response ;
    }
    public Sort sortType(String property, String type){
        if(type.equals("desc"))
            return Sort.by(property).descending();
        else return Sort.by(property).ascending() ;

    }

    private void checkIfSameReportToPerson(int reportsTo){
        List<Employee> employees=this.employeeRepository.findEmployeeByReportsTo(reportsTo);
        if(employees.size()>10){
            throw new BusinessException("Limits exceed");
        }
    }
}