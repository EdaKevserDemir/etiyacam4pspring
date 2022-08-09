package com.etiya.northwind.business.abstracts;


import com.etiya.northwind.business.requests.categories.CreateCategoryRequest;
import com.etiya.northwind.business.requests.categories.DeleteCategoryRequest;
import com.etiya.northwind.business.requests.categories.UpdateCategoryRequest;
import com.etiya.northwind.business.responses.categories.CategoryListResponse;
import com.etiya.northwind.business.responses.categories.GetCategoryByIdResponse;
import com.etiya.northwind.entities.concretes.Category;

import java.util.List;

public interface CategoryService {
    void add(CreateCategoryRequest createCategoryRequest);
    void update(UpdateCategoryRequest updateCategoryRequest);
    void delete(DeleteCategoryRequest deleteCategoryRequest);
    GetCategoryByIdResponse getById(int id);
    List<CategoryListResponse> getAll();
}