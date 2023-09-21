package project.mapper;

import org.springframework.stereotype.Component;
import project.dto.UserDto;
import project.entity.User;

@Component
public class UserMapper {

    public UserDto EntityToDto(User user){
        UserDto result = new UserDto();

        result.setId(user.getId());
        result.setEmail(user.getEmail());
        result.setFirstName(user.getFirstName());
        result.setLastName(user.getLastName());
        result.setUserRole(user.getUserRole());
        result.setPassword(user.getPassword());

        return result;
    }

    public User DtoToEntity(UserDto user){
        User result = new User();

        result.setId(user.getId());
        result.setEmail(user.getEmail());
        result.setFirstName(user.getFirstName());
        result.setLastName(user.getLastName());
        result.setUserRole(user.getUserRole());
        result.setPassword(user.getPassword());

        return result;
    }
}
