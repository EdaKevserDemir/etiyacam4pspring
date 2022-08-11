package com.etiya.northwind.business.requests.categories;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class UpdateCategoryRequest {
        @NotNull
        private int categoryId;
        @NotNull
        @NotBlank
        @Size(min=2,max=15)
        private String categoryName;

        @Size(min=2,max=15)
        private String description;
}
