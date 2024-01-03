package project.service;

import project.dto.ProductDto;

import java.util.List;

public interface ProductService {
    //All
    ProductDto getById(Long id);

    List<ProductDto> getAll();
    //Admin
    void create(ProductDto product);

    void update(ProductDto product);



}
