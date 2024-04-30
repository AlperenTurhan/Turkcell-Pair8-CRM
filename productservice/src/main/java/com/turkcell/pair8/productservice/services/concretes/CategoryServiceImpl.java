package com.turkcell.pair8.productservice.services.concretes;

import com.turkcell.pair8.productservice.entities.Cart;
import com.turkcell.pair8.productservice.entities.Category;
import com.turkcell.pair8.productservice.entities.Product;
import com.turkcell.pair8.productservice.repositories.CategoryRepository;
import com.turkcell.pair8.productservice.services.dtos.cart.requests.AddCartRequest;
import com.turkcell.pair8.productservice.services.dtos.cart.requests.UpdateCartRequest;
import com.turkcell.pair8.productservice.services.dtos.category.requests.AddCategoryRequest;
import com.turkcell.pair8.productservice.services.dtos.category.requests.UpdateCategoryRequest;
import com.turkcell.pair8.productservice.services.dtos.category.responses.AddCategoryResponse;
import com.turkcell.pair8.productservice.services.dtos.product.requests.AddProductRequest;
import com.turkcell.pair8.productservice.services.dtos.product.requests.UpdateProductRequest;
import com.turkcell.pair8.productservice.services.mappers.CartMapper;
import com.turkcell.pair8.productservice.services.mappers.CategoryMapper;
import com.turkcell.pair8.productservice.services.mappers.ProductMapper;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Getter
@Setter
@RequiredArgsConstructor
public class CategoryServiceImpl {
    private final CategoryRepository categoryRepository;
    public void update(UpdateCategoryRequest request) {
        Category category = CategoryMapper.INSTANCE.updateCategoryFromRequest(request);
        categoryRepository.save(request);
        //TODO: MESSAGES

    }
    public AddCategoryResponse add(AddCategoryRequest request){
        Category category = CategoryMapper.INSTANCE.addCategoryRequest(request);
        categoryRepository.save(request);

    }


}
