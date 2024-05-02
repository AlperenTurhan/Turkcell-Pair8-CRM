package com.turkcell.pair8.orderservice.services.conscretes;

import com.turkcell.pair8.orderservice.core.Paging.PageInfo;
import com.turkcell.pair8.orderservice.entities.Order;
import com.turkcell.pair8.orderservice.repositories.OrderRepository;
import com.turkcell.pair8.orderservice.services.abstracts.OrderService;
import com.turkcell.pair8.orderservice.services.dtos.request.AddOrderRequest;
import com.turkcell.pair8.orderservice.services.dtos.response.AddOrderResponse;
import com.turkcell.pair8.orderservice.services.dtos.response.GetAllOrderResponse;
import com.turkcell.pair8.orderservice.services.mappers.OrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    @Override
    public List<GetAllOrderResponse> getAll(PageInfo pageInfo) {
        PageRequest pageRequest = PageRequest.of(pageInfo.getPage(), pageInfo.getSize());
        List<Order> orders = orderRepository.findAll(pageRequest).getContent();
        return orders.stream().map(OrderMapper.INSTANCE::dtoFromGetAllRequest).collect(Collectors.toList());
    }

    @Override
    public AddOrderResponse add(AddOrderRequest request) {
        Order order = OrderMapper.INSTANCE.addOrderFromRequest(request);
        orderRepository.save(order);
        return request;
    }

    @Override
    public void delete(int id) {

    }
}




