package com.etiya.northwind.business.abstracts;

import java.util.List;

import com.etiya.northwind.business.requests.products.CreateProductRequest;
import com.etiya.northwind.business.requests.products.DeleteProductRequest;
import com.etiya.northwind.business.requests.products.UpdateProductRequest;
import com.etiya.northwind.business.responses.products.GetProductByIdResponse;
import com.etiya.northwind.business.responses.products.ProductListResponse;
import com.etiya.northwind.entities.concretes.Product;

public interface ProductService {
	void add(CreateProductRequest createProductRequest);
	void update(UpdateProductRequest updateProductRequest);
	void delete(DeleteProductRequest deleteProductRequest);
	GetProductByIdResponse getById(int id);
	List<ProductListResponse>getAll();

}
