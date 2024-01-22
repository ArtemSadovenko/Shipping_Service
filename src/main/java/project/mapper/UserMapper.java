package project.mapper;

import org.springframework.stereotype.Component;
import project.dto.userDto.CourierDto;
import project.dto.userDto.CustomerDto;
import project.dto.userDto.UserDto;
import project.dto.userDto.UserInitDto;
import project.entity.User;
import project.enums.UserRole;
import project.security.UserPrincipal;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {


    public static User DtoToEntity(UserInitDto dto){
        var user = new User();

        user.setId(dto.getId());
        user.setUserRole(dto.getUserRole());
        user.setEmail(dto.getEmail());
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setPassword(dto.getPassword());

        return user;
    }

    public static UserDto EntityToUserDto(User user){
        var dto = new UserDto();

        dto.setId(user.getId());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setUserRole(user.getUserRole());

        return dto;
    }

    public static CourierDto EntityToCourierDto(User user){
        var dto = new CourierDto();


        dto.setId(user.getId());
        dto.setUserRole(user.getUserRole());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setCourierOrders(user.getCourierOrders().stream()
                .map(OrderMapper::EntToOrderCourierDto)
                .collect(Collectors.toList()));

        return dto;
    }

    public static CustomerDto EntityToCustomerDto(User user){
        var dto = new CustomerDto();


        dto.setId(user.getId());
        dto.setUserRole(user.getUserRole());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setCustomerOrders(user.getCustomerOrders().stream()
                .map(OrderMapper::EntToOrderCustomerDto)
                .collect(Collectors.toList()));

        return dto;
    }

    public static UserPrincipal UserToPrincipal(User user){
        var principal = UserPrincipal.builder()
                .userId(user.getId())
                .email(user.getEmail())
                .password(user.getPassword())
                .authorities(List.of(
                        UserRole.valueOf(
                                user.getUserRole().getAuthority())
                        )
                )
                .build();

        return principal;
    }
}
