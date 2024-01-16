package project.dto.orderDto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import project.dto.ProductDto;
import project.dto.shopDto.ShopInsertDto;
import project.dto.userDto.UserDto;
import project.entity.Product;
import project.entity.Shop;
import project.entity.User;
import project.enums.OrderStatus;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class OrderDto {
    private Long id;

    private UserDto customer;

    private ShopInsertDto shop;

    private UserDto courier;

    private ProductDto product;

    private String shippingAddress;

    private Integer amount;

    private OrderStatus orderStatus;
}
