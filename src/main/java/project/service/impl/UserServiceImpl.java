package project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import project.dto.userDto.UserDto;
import project.dto.userDto.UserInitDto;
import project.entity.User;
import project.exeption.InvalidData;
import project.mapper.UserMapper;
import project.repository.UserRepository;
import project.service.UserService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository repository;

    @Override
    public User getById(Long id) {
        return repository.findById(id).orElseThrow(() -> new InvalidData("No such user", HttpStatus.BAD_REQUEST));//OrElseException("No such user", HttpStatus.BAD_REQUEST));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public UserDto findById(Long id) {
        return UserMapper.EntityToUserDto(getById(id));
    }

    @Override
    public List<UserDto> findAll() {
        return repository.findAll().stream()
                .map(UserMapper::EntityToUserDto)
                .collect(Collectors.toList());
    }

    @Override
    public void create(UserInitDto user) {
        repository.save(UserMapper.DtoToEntity(user));
    }

    @Override
    public void update(UserInitDto user) {
        repository.save(UserMapper.DtoToEntity(user));
    }

    @Override
    public List<User> getAll() {
        return repository.findAll();
    }
}
