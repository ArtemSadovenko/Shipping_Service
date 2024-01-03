package project.dto.orderDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import project.enums.OrderStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderInitDto {
    private Long id;
    private Long customerId;

    private Long shopId;

    private Long courierId;

    private String productName;

    private String shippingAddress;

    private Integer amount;

    private OrderStatus orderStatus;
}
