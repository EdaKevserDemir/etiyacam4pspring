package com.etiya.northwind.dataAccess.concretes.responses.categories;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class GetCategoryByIdResponse {
    private int categoryId;
    private String categoryName;
    private String description;
}
