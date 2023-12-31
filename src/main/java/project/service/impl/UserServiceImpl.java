package project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import project.dto.userDto.CustomerDto;
import project.exeption.IrregularData;
import project.mapper.UserMapper;
import project.repository.UserRepository;
import project.service.UserService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public CustomerDto getById(Long id) {
        return userMapper.EntityToDto(userRepository.findById(id).get());
    }

    @Override
    public void create(CustomerDto user) {
        userRepository.save(userMapper.DtoToEntity(user));
    }

    @Override
    public void update(CustomerDto user) {
        if (user.getId() == null) {
            throw new IrregularData("ID expected", HttpStatus.BAD_REQUEST);
        }
        else {
            userRepository.save(userMapper.DtoToEntity(user));
        }
    }

    @Override
    public List<CustomerDto> getAll() {
        return userRepository.findAll().stream()
                .map(e -> userMapper.EntityToDto(e))
                .collect(Collectors.toList());
    }
}
