package com.turkcell.pair8.productservice.controllers;

import com.turkcell.pair8.productservice.services.abstracts.CategoryService;
import com.turkcell.pair8.productservice.services.dtos.category.requests.AddCategoryRequest;
import com.turkcell.pair8.productservice.services.dtos.category.requests.UpdateCategoryRequest;
import com.turkcell.pair8.productservice.services.dtos.category.responses.AddCategoryResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/category")
@AllArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;
    @PostMapping("add")
    @ResponseStatus(HttpStatus.CREATED)
    public AddCategoryResponse add(@Valid @RequestBody AddCategoryRequest request) {
        return categoryService.add(request);
    }

    @PutMapping("updateCategory")
    @ResponseStatus(HttpStatus.OK)
    public void update(@RequestBody @Valid UpdateCategoryRequest request) {
        categoryService.update(request);
    }
}