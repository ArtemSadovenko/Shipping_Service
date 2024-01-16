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

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public OrderDto findById(Long id) {
        return null;
    }

    @Override
    public List<OrderDto> getAllOrdersDto() {
        return null;
    }

    @Override
    public Order getById(Long id) {
        return null;
    }

    @Override
    public List<Order> getAll() {
        return null;
    }

    @Override
    public void UpdateOrderStatus(OrderStatus status) {

    }
}
