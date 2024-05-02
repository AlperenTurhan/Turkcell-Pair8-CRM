package com.turkcell.pair8.productservice.services.mappers;

import com.turkcell.pair8.productservice.entities.Category;
import com.turkcell.pair8.productservice.services.dtos.category.requests.AddCategoryRequest;
import com.turkcell.pair8.productservice.services.dtos.category.requests.UpdateCategoryRequest;
import com.turkcell.pair8.productservice.services.dtos.category.responses.AddCategoryResponse;
import org.mapstruct.factory.Mappers;

public interface CategoryMapper {
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);
    Category addCategoryRequest(AddCategoryRequest request);
    Category updateCategoryFromRequest(UpdateCategoryRequest request);
    AddCategoryResponse responseFromAddRequest(Category category);
    AddCategoryResponse addCategoryResponse(Category category);
}
