package project.mapper;

import org.springframework.stereotype.Component;
import project.dto.orderDto.OrderCourierDto;
import project.dto.orderDto.OrderCustomerDto;
import project.dto.orderDto.OrderInitDto;
import project.entity.Order;
import project.enums.OrderStatus;

@Component
public class OrderMapper {

    public static Order DtoToEntity(OrderInitDto dto){
        var order = new Order();
        //shop set manual
        //courier set manual
        //customer set manual
        order.setAmount(dto.getAmount());
        order.setOrderStatus(OrderStatus.OPEN);
        order.setShippingAddress(dto.getShippingAddress());

        return order;
    }




    public static OrderCourierDto EntToOrderCourierDto(Order order){
        var dto = new  OrderCourierDto();

        dto.setId(order.getId());
        dto.setOrderStatus(order.getOrderStatus());
        dto.setAmount(order.getAmount());
        dto.setShippingAddress(order.getShippingAddress());
        dto.setProduct(ProductMapper
                .EntityToDto(order.getProduct()));
        dto.setShop(ShopMapper
                .EntToShopInsertDto(order.getShop()));
        dto.setCustomer(UserMapper
                .EntityToUserDto(order.getCustomer()));

        return dto;
    }

    public static OrderCustomerDto EntToOrderCustomerDto(Order order){
        var dto = new  OrderCustomerDto();

        dto.setId(order.getId());
        dto.setOrderStatus(order.getOrderStatus());
        dto.setAmount(order.getAmount());
        dto.setShippingAddress(order.getShippingAddress());
        dto.setProduct(ProductMapper
                .EntityToDto(order.getProduct()));
        dto.setShop(ShopMapper
                .EntToShopInsertDto(order.getShop()));
        dto.setCourier(UserMapper
                .EntityToUserDto(order.getCourier()));

        return dto;
    }


}
