package project.dto.shopDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import project.dto.ProductDto;
import project.dto.userDto.UserDto;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShopDto {
    private Long id;
    private String name;
    private String address;
    private UserDto admin;
    private List<ProductDto> products;
}
