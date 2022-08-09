package com.etiya.northwind.business.concretes;


import com.etiya.northwind.business.abstracts.ProductService;
import com.etiya.northwind.business.requests.products.CreateProductRequest;
import com.etiya.northwind.business.requests.products.DeleteProductRequest;
import com.etiya.northwind.business.requests.products.UpdateProductRequest;
import com.etiya.northwind.business.responses.products.GetProductByIdResponse;
import com.etiya.northwind.business.responses.products.ProductListResponse;
import com.etiya.northwind.core.utilities.mapping.ModelMapperService;
import com.etiya.northwind.dataAccess.abstracts.ProductRepository;
import com.etiya.northwind.entities.concretes.Product;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductManager implements ProductService {
	private ProductRepository productRepository;
	private ModelMapperService modelMapperService;

	@Autowired
	public ProductManager(ProductRepository productRepository,ModelMapperService modelMapperService) {
		this.modelMapperService=modelMapperService;
		this.productRepository = productRepository;
	}

	@Override
	public void add(CreateProductRequest createProductRequest) {

	}

	@Override
	public void update(UpdateProductRequest updateProductRequest) {

	}

	@Override
	public void delete(DeleteProductRequest deleteProductRequest) {

	}

	@Override
	public GetProductByIdResponse getById(int id) {
		return null;
	}

	@Override
	public List<ProductListResponse> getAll() {
		List<Product> result = this.productRepository.findAll();
		List<ProductListResponse> response = result.stream().map(product->this.modelMapperService.forResponse().map(product,ProductListResponse.class)).collect(Collectors.toList());

		return response;
	}
}
