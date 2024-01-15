package project.service;

import project.dto.ProductDto;
import project.entity.Product;

import java.util.List;

public interface ProductService {
    //All
    ProductDto fingById(Long id);

    List<ProductDto> findAll();

    //Admin
    void create(ProductDto product);

    void update(ProductDto product);

    Product getById(Long id);

    List<Product> getAll();

    void delete(Long id);

}
