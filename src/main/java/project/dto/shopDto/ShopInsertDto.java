package project.dto.shopDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import project.dto.userDto.CustomerDto;
import project.dto.userDto.UserDto;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShopInsertDto implements Serializable {
    private Long id;
    private  String name;
    private  String address;
    private  UserDto admin;
}
