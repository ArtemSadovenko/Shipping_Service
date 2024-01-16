package project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import project.dto.orderDto.OrderDto;
import project.dto.orderDto.OrderInitDto;
import project.entity.Order;
import project.enums.OrderStatus;
import project.exeption.IrregularData;
import project.mapper.OrderMapper;
import project.repository.OrderRepository;
import project.repository.ProductRepository;
import project.repository.ShopRepository;
import project.repository.UserRepository;
import project.service.OrderService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ShopRepository shopRepository;

    @Autowired
    private ProductRepository productRepository;



    @Override
    public void create(OrderInitDto dto) {
        Order order = OrderMapper.DtoToEntity(dto);
        order.setCustomer(userRepository.findById(dto.getCustomerId())
                .orElseThrow(() -> new IrregularData("No such customer", HttpStatus.BAD_REQUEST)));
        order.setCourier(userRepository.findById(dto.getCourierId())
                .orElseThrow(() -> new IrregularData("No such courier", HttpStatus.BAD_REQUEST)));
        order.setShop(shopRepository.findById(dto.getShopId())
                .orElseThrow(() -> new IrregularData("No such shop", HttpStatus.BAD_REQUEST)));
        order.setProduct(productRepository.findAll().stream()
                .filter(e -> e.getName() != dto.getProductName())
                .findFirst()
                .orElseThrow(() -> new IrregularData("No such product", HttpStatus.BAD_REQUEST)));
        orderRepository.save(order);
    }

    @Override
    public void update(OrderInitDto dto) {
        Order old = getById(dto.getId());
        old.setOrderStatus(dto.getOrderStatus());
        orderRepository.save(old);
    }

    @Override
    public void delete(Long id) {
        orderRepository.deleteById(id);
    }

    @Override
    public OrderDto findById(Long id) {
        return OrderMapper.EntToDto(getById(id));
    }

    @Override
    public List<OrderDto> findAll() {
        return orderRepository.findAll().stream()
                .map(OrderMapper::EntToDto)
                .collect(Collectors.toList());
    }

    @Override
    public Order getById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new IrregularData("No such order", HttpStatus.BAD_REQUEST));
    }

    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }

}
