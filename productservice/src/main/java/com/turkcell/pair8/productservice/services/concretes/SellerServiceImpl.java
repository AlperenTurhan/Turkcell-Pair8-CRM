package com.turkcell.pair8.productservice.services.concretes;

import com.turkcell.pair8.productservice.entities.Seller;
import com.turkcell.pair8.productservice.repositories.SellerRepository;
import com.turkcell.pair8.productservice.services.abstracts.SellerService;
import com.turkcell.pair8.productservice.services.dtos.seller.requests.AddSellerRequest;
import com.turkcell.pair8.productservice.services.dtos.seller.requests.SearchSellerRequest;
import com.turkcell.pair8.productservice.services.dtos.seller.requests.UpdateSellerRequest;
import com.turkcell.pair8.productservice.services.dtos.seller.responses.AddSellerResponse;
import com.turkcell.pair8.productservice.services.dtos.seller.responses.SearchSellerResponse;
import com.turkcell.pair8.productservice.services.mappers.SellerMapper;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@Getter
@Setter
@RequiredArgsConstructor
public class SellerServiceImpl implements SellerService {
    private final SellerRepository sellerRepository;
    public Optional<Seller> getSeller(String sellerID) {
        return sellerRepository.findBySellerID(sellerID);
    }


    public void update(UpdateSellerRequest request) {
        Seller seller = SellerMapper.INSTANCE.updateProductFromRequest(request);
        sellerRepository.save(seller);
        //TODO: MESSAGES

    }

    @Override
    public List<SearchSellerResponse> search(SearchSellerRequest request) {
        List<Seller> sellers = sellerRepository.findAll();
        return SellerMapper.INSTANCE.responseFromSearchProduct(sellers);
    }

    public AddSellerResponse add(AddSellerRequest request){
        Seller seller = SellerMapper.INSTANCE.addProductRequest(request);
        sellerRepository.save(seller);
        return SellerMapper.INSTANCE.responseFromAddProduct(seller);
    }
}
