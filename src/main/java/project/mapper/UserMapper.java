package project.mapper;

import org.springframework.stereotype.Component;
import project.dto.UserDto;
import project.entity.User;

@Component
public class UserMapper {

    public UserDto EntityToDto(User entity){
        UserDto dto = new UserDto();

        dto.setId(entity.getId());
        dto.setEmail(entity.getEmail());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setUserRole(entity.getUserRole());
        dto.setPassword(entity.getPassword());

        return dto;
    }

    public User DtoToEntity(UserDto dto){
        User entity = new User();

        entity.setId(dto.getId());
        entity.setEmail(dto.getEmail());
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setUserRole(dto.getUserRole());
        entity.setPassword(dto.getPassword());

        return entity;
    }
}
