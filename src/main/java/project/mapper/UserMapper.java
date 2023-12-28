package project.mapper;

import org.springframework.stereotype.Component;
import project.dto.userDto.CustomerDto;
import project.entity.User;

@Component
public class UserMapper {

    public CustomerDto EntityToDto(User entity){
        CustomerDto dto = new CustomerDto();

//        dto.setId(entity.getId());
//        dto.setEmail(entity.getEmail());
//        dto.setFirstName(entity.getFirstName());
//        dto.setLastName(entity.getLastName());
//        dto.setUserRole(entity.getUserRole());
//        dto.setPassword(entity.getPassword());

        return dto;
    }

    public User DtoToEntity(CustomerDto dto){
        User entity = new User();

//        entity.setId(dto.getId());
//        entity.setEmail(dto.getEmail());
//        entity.setFirstName(dto.getFirstName());
//        entity.setLastName(dto.getLastName());
//        entity.setUserRole(dto.getUserRole());
//        entity.setPassword(dto.getPassword());

        return entity;
    }


}
