package com.etiya.northwind.business.abstracts;

import com.etiya.northwind.business.requests.suppliers.CreateSupplierRequest;
import com.etiya.northwind.business.requests.suppliers.DeleteSupplierRequest;
import com.etiya.northwind.business.requests.suppliers.UpdateSupplierRequest;
import com.etiya.northwind.business.responses.suppliers.GetSupplierByIdResponse;
import com.etiya.northwind.business.responses.suppliers.SupplierListResponse;

import java.util.List;

public interface SupplierService {
    void add(CreateSupplierRequest createSupplierRequest);
    void update(UpdateSupplierRequest updateSupplierRequest);
    void delete(DeleteSupplierRequest deleteSupplierRequest);
    GetSupplierByIdResponse getById(int id);
    List<SupplierListResponse>getAll();
}
