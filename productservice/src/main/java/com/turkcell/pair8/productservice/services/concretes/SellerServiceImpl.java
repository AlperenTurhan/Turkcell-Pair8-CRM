package com.turkcell.pair8.productservice.services.concretes;

import com.turkcell.pair8.productservice.entities.Product;
import com.turkcell.pair8.productservice.entities.Seller;
import com.turkcell.pair8.productservice.repositories.SellerRepository;
import com.turkcell.pair8.productservice.services.dtos.product.requests.AddProductRequest;
import com.turkcell.pair8.productservice.services.dtos.product.requests.UpdateProductRequest;
import com.turkcell.pair8.productservice.services.dtos.seller.requests.AddSellerRequest;
import com.turkcell.pair8.productservice.services.dtos.seller.requests.UpdateSellerRequest;
import com.turkcell.pair8.productservice.services.mappers.ProductMapper;
import com.turkcell.pair8.productservice.services.mappers.SellerMapper;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
@Getter
@Setter
@RequiredArgsConstructor
public class SellerServiceImpl {
    private final SellerRepository sellerRepository;
    public Optional<Seller> getSeller(String sellerID) {
        return sellerRepository.findBySellerId(sellerID);
    }


    public void update(UpdateSellerRequest request) {
        Seller seller = SellerMapper.INSTANCE.updateProductFromRequest(request);
        sellerRepository.save(seller);
        //TODO: MESSAGES

    }
    public AddSellerRequest add(AddSellerRequest request){
        Seller seller = SellerMapper.INSTANCE.addProductRequest(request);
        sellerRepository.save(seller);
        return request;
    }
}
