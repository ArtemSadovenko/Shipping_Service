package project.dto.userDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import project.dto.orderDto.OrderCourierDto;
import project.enums.UserRole;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourierDto {
    private Long id;

    private String firstName;

    private String lastName;

    private UserRole userRole;

    private List<OrderCourierDto> courierOrders;
}
