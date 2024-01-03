package project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import project.dto.ProductDto;
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
    private ProductRepository productRepository;


    @Override
    public ProductDto getById(Long id) {
        return ProductMapper.EntityToDto(productRepository.findById(id).orElseThrow(() -> new IrregularData("No such item", HttpStatus.NOT_FOUND)));
    }

    @Override
    public void create(ProductDto product) {
        productRepository.save(ProductMapper.DtoToEntity(product));
    }

    @Override
    public void update(ProductDto product) {

        if (product.getId() == null) {
            throw new IrregularData("ID expected", HttpStatus.BAD_REQUEST);
        } else {
            productRepository.save(ProductMapper.DtoToEntity(product));
        }
    }

    @Override
    public List<ProductDto> getAll() {
        return productRepository.findAll().stream()
                .map(ProductMapper::EntityToDto)
                .collect(Collectors.toList());
    }
}
