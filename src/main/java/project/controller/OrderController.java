package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.dto.orderDto.OrderDto;
import project.dto.orderDto.OrderInitDto;
import project.security.JwtService;
import project.service.OrderService;

import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private JwtService auth;

    @PostMapping("/create")
    public void create(@RequestBody OrderInitDto dto){
        orderService.create(dto);
    }

    @GetMapping("/")
    public List<OrderDto> findAll(){
        return orderService.findAll();
    }

    @GetMapping("/{id}")
    public OrderDto findById(@PathVariable Long id){
        return orderService.findById(id);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody OrderInitDto dto, @PathVariable Long id){
        dto.setId(id);
        orderService.update(dto);
    }

    @DeleteMapping("/{id}")
    public  void deleteById(@PathVariable Long id){
        orderService.delete(id);
    }
}
