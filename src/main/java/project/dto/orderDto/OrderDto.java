package project.dto.orderDto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import project.entity.Product;
import project.entity.Shop;
import project.entity.User;
import project.enums.OrderStatus;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDto {
    private Long id;

    private User customer;

    private Shop shop;

    private User courier;

    private Product product;

    private String shippingAddress;

    private Integer amount;

    private OrderStatus orderStatus;
}
