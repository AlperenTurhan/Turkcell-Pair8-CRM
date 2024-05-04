package com.turkcell.pair8.productservice.services.concretes;

import com.turkcell.pair8.productservice.entities.Category;
import com.turkcell.pair8.productservice.repositories.CategoryRepository;
import com.turkcell.pair8.productservice.services.abstracts.CategoryService;
import com.turkcell.pair8.productservice.services.dtos.category.requests.AddCategoryRequest;
import com.turkcell.pair8.productservice.services.dtos.category.requests.UpdateCategoryRequest;
import com.turkcell.pair8.productservice.services.dtos.category.responses.AddCategoryResponse;
import com.turkcell.pair8.productservice.services.mappers.CategoryMapper;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Service
@Getter
@Setter
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public void update(UpdateCategoryRequest request) {
        Category category = CategoryMapper.INSTANCE.updateCategoryFromRequest(request);
        categoryRepository.save(category);

    }
    public AddCategoryResponse add(AddCategoryRequest request){
        Category category = CategoryMapper.INSTANCE.addCategoryRequest(request);
        categoryRepository.save(category);
        return CategoryMapper.INSTANCE.addCategoryResponse(category);
    }
}
