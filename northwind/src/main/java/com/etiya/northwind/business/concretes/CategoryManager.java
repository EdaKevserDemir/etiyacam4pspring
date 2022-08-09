package com.etiya.northwind.business.concretes;

import com.etiya.northwind.business.abstracts.CategoryService;
import com.etiya.northwind.business.requests.categories.CreateCategoryRequest;
import com.etiya.northwind.business.requests.categories.DeleteCategoryRequest;
import com.etiya.northwind.business.requests.categories.UpdateCategoryRequest;
import com.etiya.northwind.business.responses.categories.CategoryListResponse;
import com.etiya.northwind.business.responses.categories.GetCategoryByIdResponse;
import com.etiya.northwind.business.responses.products.ProductListResponse;
import com.etiya.northwind.core.utilities.mapping.ModelMapperService;
import com.etiya.northwind.dataAccess.abstracts.CategoryRepository;
import com.etiya.northwind.entities.concretes.Category;
import com.etiya.northwind.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class CategoryManager implements CategoryService {
    private CategoryRepository categoryRepository;
    private ModelMapperService modelMapperService;

    @Autowired
    public CategoryManager(CategoryRepository categoryRepository,ModelMapperService modelMapperService) {
        this.categoryRepository = categoryRepository;
        this.modelMapperService=modelMapperService;
    }

    @Override
    public void add(CreateCategoryRequest createCategoryRequest) {
        Category category=this.modelMapperService.forRequest().map(createCategoryRequest,Category.class);
        categoryRepository.save(category);
    }

    @Override
    public void update(UpdateCategoryRequest updateCategoryRequest) {
        checkIfExistCategoryId(updateCategoryRequest.getCategoryId());
      Category category=this.modelMapperService.forRequest().map(updateCategoryRequest,Category.class);
      categoryRepository.save(category);

    }

    @Override
    public void delete(DeleteCategoryRequest deleteCategoryRequest) {
        checkIfExistCategoryId(deleteCategoryRequest.getCategoryId());
        categoryRepository.deleteById(deleteCategoryRequest.getCategoryId());

    }

    @Override
    public GetCategoryByIdResponse getById(int id) {
        checkIfExistCategoryId(id);
        return this.modelMapperService.forResponse().map(id,GetCategoryByIdResponse.class);
    }

    @Override
    public List<CategoryListResponse> getAll() {
        List<Category> result = this.categoryRepository.findAll();
        List<CategoryListResponse> responses = result.stream().map(category->this.modelMapperService.forResponse().map(category, CategoryListResponse.class)).collect(Collectors.toList());

        return responses;
    }

    private void checkIfExistCategoryId(int id) {
        Category category=this.categoryRepository.findById(id);
        if(category!=null){
            System.out.println(" exist this category");

        }

    }
}
