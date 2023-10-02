package project.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ShopDto implements Serializable {
    private final Long id;
    private final String name;
    private final String address;
    private final UserDto user;
}
