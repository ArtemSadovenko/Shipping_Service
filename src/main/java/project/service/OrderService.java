package project.service;

import project.dto.orderDto.OrderDto;
import project.dto.orderDto.OrderInitDto;
import project.entity.Order;
import project.enums.OrderStatus;

import java.util.List;

public interface OrderService {

    //All
    void createOrder(OrderInitDto dto);
    void updateOrder(OrderInitDto dto);
    Order findEntityById(Long id);

    List<OrderDto> getAllOrdersDto();
    //Courier
    void UpdateOrderStatus(OrderStatus status);



}
