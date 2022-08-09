package com.etiya.northwind.api.controllers;


import com.etiya.northwind.business.abstracts.SupplierService;

import com.etiya.northwind.business.requests.suppliers.CreateSupplierRequest;
import com.etiya.northwind.business.requests.suppliers.DeleteSupplierRequest;
import com.etiya.northwind.business.requests.suppliers.UpdateSupplierRequest;

import com.etiya.northwind.business.responses.suppliers.GetSupplierByIdResponse;
import com.etiya.northwind.business.responses.suppliers.SupplierListResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/suppliers")
public class SuppliersController {
    private SupplierService supplierService;

    @Autowired
    public SuppliersController(SupplierService supplierService) {

        this.supplierService = supplierService;
    }

    @PostMapping("/add")
    public void add(@RequestBody CreateSupplierRequest createSupplierRequest){
        this.supplierService.add(createSupplierRequest);

    }

    @PostMapping("/update")
    public void update(@RequestBody UpdateSupplierRequest updateSupplierRequest){
        this.supplierService.update(updateSupplierRequest);

    }
    @PostMapping("/delete")
    public void delete(@RequestBody DeleteSupplierRequest deleteSupplierRequest){
        this.supplierService.delete(deleteSupplierRequest);
    }


    @GetMapping("/getAll")
    public List<SupplierListResponse> getAll() {

        return this.supplierService.getAll();
    }
    @GetMapping("/getbyid")
    public GetSupplierByIdResponse getById(@RequestParam int id){

        return this.supplierService.getById(id);
    }

    @GetMapping("/getallpages")
    public Map<String,Object> getAllPages(@RequestParam int pageNumber, @RequestParam int pageSize){

        return this.supplierService.getAllPages(pageNumber,pageSize);

    }

    @GetMapping("/getallpagesorderbyentity")
    public Map<String,Object> getAllPagesOrderByEntity(@RequestParam int pageNumber,@RequestParam int pageSize,@RequestParam String entity,@RequestParam Optional<String> type){

        return this.supplierService.getAllPagesOrderByEntity(pageNumber,pageSize, entity,type.orElse(""));

    }

}