package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.dto.ProductDto;
import project.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService userService;

    @GetMapping("/")
    public List<ProductDto> findAll(){
        return userService.findAll();
    }

    @PostMapping("/create")
    public void create(@RequestBody ProductDto productDto){
        userService.create(productDto);
    }

    @PutMapping("/")
    public void update(@RequestBody ProductDto productDto){
        userService.update(productDto);
    }

    @GetMapping("/{id}")
    public ProductDto findById(@PathVariable Long id){
        return userService.fingById(id);
    }
}
