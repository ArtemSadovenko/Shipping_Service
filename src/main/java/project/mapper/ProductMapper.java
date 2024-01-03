package project.mapper;

import org.springframework.stereotype.Component;
import project.dto.ProductDto;
import project.entity.Product;

@Component
public class ProductMapper {

    public static Product DtoToEntity(ProductDto dto){
        Product entity = new Product();

        entity.setId(dto.getId());
        entity.setDescription(dto.getDescription());
        entity.setPrice(dto.getPrice());
        entity.setName(dto.getName());

        return entity;
    }

    public static ProductDto EntityToDto(Product entity){
        ProductDto dto = new ProductDto();

        dto.setId(entity.getId());
        dto.setDescription(entity.getDescription());
        dto.setPrice(entity.getPrice());
        dto.setName(entity.getName());

        return dto;
    }
}
