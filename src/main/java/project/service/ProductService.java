package project.service;

import project.dto.ProductDto;

import java.util.List;

public interface ProductService {
    ProductDto getById(Long id);

    void create(ProductDto product);

    void update(ProductDto product);

    List<ProductDto> getAll();
}
