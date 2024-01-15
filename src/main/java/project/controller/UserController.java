package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.dto.userDto.CustomerDto;
import project.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

//    @GetMapping("/")
//    public List<CustomerDto> getAll(){
//        return userService.getAll();
//    }
//
//    @PostMapping("/create")
//    public void create(@RequestBody CustomerDto user){
//        userService.create(user);
//    }
//
//    @PutMapping("/")
//    public void update(@RequestBody CustomerDto user){
//        userService.update(user);
//    }
//
//    @GetMapping("/{id}")
//    public CustomerDto findById(@PathVariable Long id){
//        return userService.getById(id);
//    }
}