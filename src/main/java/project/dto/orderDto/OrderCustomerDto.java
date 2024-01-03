package project.dto.orderDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import project.dto.ProductDto;
import project.dto.shopDto.ShopInsertDto;
import project.dto.userDto.UserDto;
import project.enums.OrderStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderCustomerDto {
    private Long id;
    private ShopInsertDto shop;
    private UserDto courier;
    private ProductDto product;
    private String shippingAddress;
    private Integer amount;
    private OrderStatus orderStatus;
}
