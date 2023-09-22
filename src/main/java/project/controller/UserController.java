package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.dto.UserDto;
import project.enums.UserRole;
import project.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public List<UserDto> getAll(){
        return userService.getAll();
    }

    @PostMapping("/create")
    public void create(@RequestBody UserDto user){
        userService.create(user);
    }

    @PutMapping("/")
    public void update(@RequestBody UserDto user){
        userService.update(user);
    }

}