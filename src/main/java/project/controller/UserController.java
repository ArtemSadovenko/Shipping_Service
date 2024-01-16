package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.dto.userDto.CustomerDto;
import project.dto.userDto.UserDto;
import project.dto.userDto.UserInitDto;
import project.security.JwtService;
import project.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtService auth;

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

    @GetMapping("/test")
    public ResponseEntity<String> test(){
        return new ResponseEntity<>("Hi", HttpStatusCode.valueOf(200));
    }

    @PostMapping("/create")
    public void create(@RequestBody UserInitDto dto){
        userService.create(dto);
    }

    @GetMapping("/")
    public List<UserDto> findAll(){
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public UserDto findById(@PathVariable Long id){
        return userService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        userService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody UserInitDto dto){
        dto.setId(id);
        userService.update(dto);
    }

}