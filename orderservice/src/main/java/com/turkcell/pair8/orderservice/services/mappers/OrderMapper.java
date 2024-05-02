package com.turkcell.pair8.orderservice.services.mappers;

import com.turkcell.pair8.orderservice.entities.Order;
import com.turkcell.pair8.orderservice.services.dtos.request.AddOrderRequest;
import com.turkcell.pair8.orderservice.services.dtos.response.AddOrderResponse;
import com.turkcell.pair8.orderservice.services.dtos.response.GetAllOrderResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    @Mapping(source="orderId", target="order.id")
    Order addOrderFromRequest(AddOrderRequest request);
    GetAllOrderResponse dtoFromGetAllRequest(Order order);
    AddOrderResponse dtoFromAddRequest(Order order);
}
