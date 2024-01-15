package project.service;

import project.dto.DocumentDto;
import project.entity.Document;

import java.util.List;

public interface DocumentService {

    void create(DocumentDto dto);

    void update(DocumentDto dto);

    Document getById(Long id);

    List<Document> getAll();

    void delete(Long id);
}
