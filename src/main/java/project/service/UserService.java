package project.service;

import project.dto.userDto.CustomerDto;
import project.dto.userDto.UserDto;
import project.dto.userDto.UserInitDto;
import project.entity.User;

import java.util.List;

public interface UserService {
    //All
    User getById(Long id);

    User getByEmail(String email);

    void delete(Long id);

    UserDto findById(Long id);

    List<UserDto> findAll();

    void create(UserInitDto user);

    void update(UserInitDto user);
    //Admin
    List<User> getAll();

    //Customer
    // -//-

    //Courier
    // -//-

}
