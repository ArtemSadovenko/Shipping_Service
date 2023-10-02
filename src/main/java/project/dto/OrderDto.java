package project.dto;

import lombok.Data;
import project.enums.OrderStatus;

import java.io.Serializable;

@Data
public class OrderDto implements Serializable {
    private final Long id;
    private final UserDto customer;
    private final ShopDto shop;
    private final UserDto courier;
    private final ProductDto product;
    private final String shippingAddress;
    private final Integer amount;
    private final OrderStatus orderStatus;
}
