package project.service;

import project.dto.userDto.CustomerDto;

import java.util.List;

public interface UserService {
    CustomerDto getById(Long id);

    void create(CustomerDto user);

    void update(CustomerDto user);

    List<CustomerDto> getAll();

}
