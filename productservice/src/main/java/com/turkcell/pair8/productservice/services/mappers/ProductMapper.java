package com.turkcell.pair8.productservice.services.mappers;

import com.turkcell.pair8.productservice.entities.Product;
import com.turkcell.pair8.productservice.services.dtos.product.requests.AddProductRequest;
import com.turkcell.pair8.productservice.services.dtos.product.requests.UpdateProductRequest;
import com.turkcell.pair8.productservice.services.dtos.product.responses.AddProductResponse;
import com.turkcell.pair8.productservice.services.dtos.product.responses.SearchProductResponse;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);
    @Mapping(source ="sellerId",target = "sellerID")
    Product addProductRequest(AddProductRequest request);
    Product updateProductFromRequest(UpdateProductRequest request);
    AddProductResponse responseFromAddProduct(Product product);
    SearchProductResponse responseFromSearchProduct(Iterable<Product> products);
}
