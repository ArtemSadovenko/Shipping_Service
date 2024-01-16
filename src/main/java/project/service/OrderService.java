package project.service;

import project.dto.orderDto.OrderDto;
import project.dto.orderDto.OrderInitDto;
import project.entity.Order;

import java.util.List;

public interface OrderService {

    //All
    void create(OrderInitDto dto);
    void update(OrderInitDto dto);
    void delete(Long id);

    OrderDto findById(Long id);

    List<OrderDto> findAll();
    //Admin
    Order getById(Long id);

    List<Order> getAll();
    //Courier




}
