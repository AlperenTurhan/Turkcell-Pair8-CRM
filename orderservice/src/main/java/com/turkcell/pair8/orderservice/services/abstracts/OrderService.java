package com.turkcell.pair8.orderservice.services.abstracts;

import com.turkcell.pair8.orderservice.core.Paging.PageInfo;
import com.turkcell.pair8.orderservice.services.dtos.request.AddOrderRequest;
import com.turkcell.pair8.orderservice.services.dtos.response.AddOrderResponse;
import com.turkcell.pair8.orderservice.services.dtos.response.GetAllOrderResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {
    List<GetAllOrderResponse> getAll(PageInfo pageInfo);
    AddOrderResponse add(AddOrderRequest request);
    void delete(int id);
}
