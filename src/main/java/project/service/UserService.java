package project.service;

import org.springframework.stereotype.Service;
import project.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto getById(Long id);

    void create(UserDto user);

    void update(UserDto user);

    List<UserDto> getAll();

}
