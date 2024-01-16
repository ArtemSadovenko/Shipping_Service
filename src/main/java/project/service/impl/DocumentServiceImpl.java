package project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import project.dto.DocumentDto;
import project.entity.Document;
import project.exeption.IrregularData;
import project.repository.DocumentRepository;
import project.repository.ProductRepository;
import project.repository.ShopRepository;
import project.service.DocumentService;

import java.util.List;

@Service
public class DocumentServiceImpl implements DocumentService {

    @Autowired
    private DocumentRepository documentRepository;

    @Autowired
    private ShopRepository shopRepository;

    @Autowired
    private ProductRepository productRepository;


    @Override
    public void create(DocumentDto dto) {
        documentRepository.save(
                Document.builder()
                        .shop(shopRepository.findById(dto.getId())
                                .orElseThrow(() -> new IrregularData("No such shop", HttpStatus.BAD_REQUEST)))
                        .product(productRepository.findById(dto.getProductId())
                                .orElseThrow(() -> new IrregularData("No such product", HttpStatus.BAD_REQUEST)))
                        .amount(dto.getAmount())
                        .build()
        );
    }

    @Override
    public void update(DocumentDto dto) {
        Document old = getById(dto.getId());
        old.setAmount(dto.getAmount());
        documentRepository.save(old);
    }

    @Override
    public Document getById(Long id) {
        return documentRepository.findById(id)
                .orElseThrow(() -> new IrregularData("No such doc", HttpStatus.BAD_REQUEST));
    }

    @Override
    public List<Document> getAll() {
        return documentRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        documentRepository.deleteById(id);
    }
}
