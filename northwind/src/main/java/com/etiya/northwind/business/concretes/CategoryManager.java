package com.etiya.northwind.business.concretes;

import com.etiya.northwind.business.abstracts.CategoryService;
import com.etiya.northwind.business.requests.categories.CreateCategoryRequest;
import com.etiya.northwind.business.requests.categories.DeleteCategoryRequest;
import com.etiya.northwind.business.requests.categories.UpdateCategoryRequest;
import com.etiya.northwind.business.responses.categories.CategoryListResponse;
import com.etiya.northwind.business.responses.categories.GetCategoryByIdResponse;
import com.etiya.northwind.core.utilities.mapping.ModelMapperService;
import com.etiya.northwind.dataAccess.abstracts.CategoryRepository;
import com.etiya.northwind.entities.concretes.Category;
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
      Category category=this.modelMapperService.forRequest().map(updateCategoryRequest,Category.class);
      categoryRepository.save(category);

    }

    @Override
    public void delete(DeleteCategoryRequest deleteCategoryRequest) {
        categoryRepository.deleteById(deleteCategoryRequest.getCategoryId());

    }

    @Override
    public GetCategoryByIdResponse getById(int id) {
        Category category=this.categoryRepository.findById(id);
        GetCategoryByIdResponse getCategoryByIdResponse=this.modelMapperService.forResponse().map(category,GetCategoryByIdResponse.class);
        return getCategoryByIdResponse;
    }

    @Override
    public List<CategoryListResponse> getAll() {
        List<Category> result = this.categoryRepository.findAll();
        List<CategoryListResponse> responses = result.stream().map(category->this.modelMapperService.forResponse()
                .map(category, CategoryListResponse.class)).collect(Collectors.toList());

        return responses;
    }


    @Override
    public Map<String, Object> getAllPages(int pageNumber, int pageSize) {
        Pageable pageable=PageRequest.of(pageNumber-1,pageSize);
        Map<String,Object> response=new HashMap<>();

        Page<Category>categories =categoryRepository.findAll(pageable);
        response.put("totalElements",categories.getTotalElements()) ;
        response.put("totalPages",categories.getTotalPages());
        response.put("currentPage",categories.getNumber()+1);
        response.put("categories",categories.getContent().stream().map(category ->
                this.modelMapperService.forResponse().map(category,CategoryListResponse.class)).collect(Collectors.toList()));

        return response ;
    }

    @Override
    public Map<String, Object> getAllPagesOrderByEntity(int pageNumber, int pageSize,String entity,String type) {
        Pageable pageable=PageRequest.of(pageNumber-1,pageSize,sortType(entity,type));


        Map<String,Object> response=new HashMap<>();
        Page<Category>categories =categoryRepository.findAll(pageable);
        response.put("totalElements",categories.getTotalElements()) ;
        response.put("totalPages",categories.getTotalPages());
        response.put("currentPage",categories.getNumber()+1);
        response.put("categories",categories.getContent().stream().map(category ->
                this.modelMapperService.forResponse().map(category,CategoryListResponse.class)).collect(Collectors.toList()));

        return response ;
    }

    public Sort sortType(String property,String type){
        if(type.equals("desc"))
            return Sort.by(property).descending();
        else return Sort.by(property).ascending() ;

    }
}
