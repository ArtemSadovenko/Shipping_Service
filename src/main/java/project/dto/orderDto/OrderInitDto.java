package project.dto.orderDto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import project.entity.Product;
import project.entity.Shop;
import project.entity.User;
import project.enums.OrderStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderInitDto {

    private Long customerId;

    private Long shopId;

    private Long courierId;

    private String productName;

    private String shippingAddress;

    private Integer amount;

    private OrderStatus orderStatus;
}
