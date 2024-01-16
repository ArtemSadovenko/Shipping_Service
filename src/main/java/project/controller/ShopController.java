package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.dto.shopDto.ShopDto;
import project.dto.shopDto.ShopInitDto;
import project.repository.ShopRepository;
import project.security.JwtService;
import project.service.ShopService;

import java.util.List;

@RestController
@RequestMapping("/api/shop")
public class ShopController {

    @Autowired
    private ShopService shopService;

    @Autowired
    private JwtService auth;


    @PostMapping("/create")
    public void create(@RequestBody ShopInitDto dto){
        shopService.create(dto);
    }

    @GetMapping("/")
    public List<ShopDto> findAll(){
        return shopService.findAll();
    }

    @GetMapping("/{id}")
    public ShopDto findById(@PathVariable Long id){
        return shopService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        shopService.delete(id);
    }

    @PutMapping("/{id}")
    public void findById(@PathVariable Long id, @RequestBody ShopInitDto dto){
        dto.setId(id);
        shopService.update(dto);
    }

}
