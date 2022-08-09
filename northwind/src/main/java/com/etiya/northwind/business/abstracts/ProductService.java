package com.etiya.northwind.business.abstracts;

import java.util.List;

import com.etiya.northwind.business.responses.products.ProductListResponse;
import com.etiya.northwind.entities.concretes.Product;

public interface ProductService {
	List<ProductListResponse>getAll();

}
