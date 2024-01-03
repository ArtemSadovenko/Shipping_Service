package project.service;

import project.dto.userDto.CustomerDto;
import project.dto.userDto.UserDto;
import project.dto.userDto.UserInitDto;
import project.entity.User;

import java.util.List;

public interface UserService {
    //All
    User getEntityById(Long id);

    List<UserDto> getAll();

    void create(UserInitDto user);

    void update(UserInitDto user);
    //Admin
    List<User> getAllEntity();

    //Customer
    // -//-

    //Courier
    // -//-

}
