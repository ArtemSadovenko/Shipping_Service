package project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import project.dto.ProductDto;
import project.entity.Product;
import project.exeption.IrregularData;
import project.exeption.OrElseException;
import project.mapper.ProductMapper;
import project.repository.ProductRepository;
import project.service.ProductService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repository;


    @Override
    public ProductDto fingById(Long id) {
        return ProductMapper.EntityToDto(getById(id));
    }

    @Override
    public List<ProductDto> findAll() {
        return repository.findAll().stream()
                .map(ProductMapper::EntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void create(ProductDto product) {
        repository.save(ProductMapper.DtoToEntity(product));
    }

    @Override
    public void update(ProductDto product) {
        repository.save(ProductMapper.DtoToEntity(product));
    }

    @Override
    public Product getById(Long id) {
        return repository.findById(id).orElseThrow(()->new IrregularData("No such product", HttpStatus.BAD_REQUEST));
    }

    @Override
    public List<Product> getAll() {
        return repository.findAll();
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
