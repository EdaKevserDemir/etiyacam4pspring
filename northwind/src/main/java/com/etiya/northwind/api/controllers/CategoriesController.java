package com.etiya.northwind.api.controllers;

import com.etiya.northwind.business.abstracts.CategoryService;
import com.etiya.northwind.business.requests.categories.CreateCategoryRequest;
import com.etiya.northwind.business.requests.categories.DeleteCategoryRequest;
import com.etiya.northwind.business.requests.categories.UpdateCategoryRequest;
import com.etiya.northwind.business.responses.categories.CategoryListResponse;
import com.etiya.northwind.business.responses.categories.GetCategoryByIdResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoriesController {
    private CategoryService categoryService;

    @Autowired
    public CategoriesController(CategoryService categoryService) {

        this.categoryService = categoryService;
    }

    @PostMapping("/add")
    public void add(@RequestBody CreateCategoryRequest createCategoryRequest){
        this.categoryService.add(createCategoryRequest);

    }

    @PostMapping("/update")
    public void update(@RequestBody UpdateCategoryRequest updateCategoryRequest){
        this.categoryService.update(updateCategoryRequest);

    }
    @PostMapping("/delete")
    public void delete(@RequestBody DeleteCategoryRequest deleteCategoryRequest){
        this.categoryService.delete(deleteCategoryRequest);
    }


    @GetMapping("/getAll")
    public List<CategoryListResponse> getAll() {

        return this.categoryService.getAll();
    }
    @GetMapping("/getbyid")
    public GetCategoryByIdResponse getById(@RequestParam int id){
        return this.categoryService.getById(id);
    }
}