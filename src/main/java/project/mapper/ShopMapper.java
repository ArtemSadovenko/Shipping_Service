package project.mapper;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import project.dto.shopDto.ShopDto;
import project.dto.shopDto.ShopInitDto;
import project.dto.shopDto.ShopInsertDto;
import project.entity.Shop;

import java.util.stream.Collectors;

@Component
public class ShopMapper {

    public static ShopDto EntToShopDto(Shop shop){
        var dto = new ShopDto();

        dto.setAddress(shop.getAddress());
        dto.setAdmin(UserMapper
                .EntityToUserDto(shop.getUser()));
        dto.setName(shop.getName());
        dto.setProducts(shop.getProducts().stream()
                .map(ProductMapper::EntityToDto)
                .collect(Collectors.toList()));
        dto.setId(shop.getId());

        return dto;
    }

    public static ShopInsertDto EntToShopInsertDto(Shop shop){
        var dto = new ShopInsertDto();


        dto.setId(shop.getId());
        dto.setAddress(shop.getAddress());
        dto.setAdmin(UserMapper
                .EntityToUserDto(shop.getUser()));
        dto.setName(shop.getName());

        return dto;
    }


    public static ShopInitDto EntToShopInitDto(Shop shop){
        var dto = new ShopInitDto();

        // set admin manually from outside
        dto.setId(shop.getId());
        dto.setAddress(shop.getAddress());
        dto.setName(shop.getName());

        return dto;
    }


    public static Shop DtoToEntity(ShopInitDto dto){
        var shop = new Shop();

        shop.setAddress(dto.getAddress());
        shop.setName(dto.getName());
        shop.setId(dto.getId());
        //not implements admin set. Necessary to set admin from outside

        return shop;
    }
}
