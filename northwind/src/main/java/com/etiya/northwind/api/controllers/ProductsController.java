package com.etiya.northwind.api.controllers;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.etiya.northwind.business.abstracts.ProductService;
import com.etiya.northwind.business.requests.products.CreateProductRequest;
import com.etiya.northwind.business.requests.products.DeleteProductRequest;
import com.etiya.northwind.business.requests.products.UpdateProductRequest;
import com.etiya.northwind.business.responses.products.ProductListResponse;
import com.etiya.northwind.business.responses.products.GetProductByIdResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/products")
public class ProductsController {
	private ProductService productService;

	@Autowired
	public ProductsController(ProductService productService) {

		this.productService = productService;
	}

	@PostMapping("/add")
	public void add(@RequestBody CreateProductRequest createProductRequest){
		this.productService.add(createProductRequest);

	}

	@PostMapping("/update")
	public void update(@RequestBody UpdateProductRequest updateProductRequest){
		this.productService.update(updateProductRequest);

	}
	@PostMapping("/delete")
	public void delete(@RequestBody DeleteProductRequest deleteProductRequest){
		this.productService.delete(deleteProductRequest);
	}


	@GetMapping("/getAll")
	public List<ProductListResponse> getAll() {

		return this.productService.getAll();
	}
	@GetMapping("/getbyid")
	public GetProductByIdResponse getById(@RequestParam int id){

		return this.productService.getById(id);
	}

	@GetMapping("/getallpages")
	public Map<String,Object> getAllPages(@RequestParam int pageNumber, @RequestParam int pageSize){

		return this.productService.getAllPages(pageNumber,pageSize);

	}

	@GetMapping("/getallpagesorderbyentity")
	public Map<String,Object> getAllPagesOrderByEntity(@RequestParam int pageNumber,@RequestParam int pageSize,@RequestParam String entity,@RequestParam Optional<String> type){

		return this.productService.getAllPagesOrderByEntity(pageNumber,pageSize, entity,type.orElse(""));

	}
}

