package project.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.dto.DocumentDto;
import project.entity.Document;
import project.security.JwtService;
import project.service.DocumentService;

import java.util.List;

@RestController
@RequestMapping("/api/doc")
//@RequiredArgsConstructor
public class DocumentController {
    @Autowired
    DocumentService documentService;

    @Autowired
    JwtService auth;

    @GetMapping("/{id}")
    public Document getById(@PathVariable Long id){
        return documentService.getById(id);
    }

    @GetMapping("/")
    public List<Document> getAll(){
        return documentService.getAll();
    }

    //Only for COURIER
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        documentService.delete(id);
    }

    //Only for CUSTOMER
    @PutMapping("/{id}")
    public void update(@RequestBody DocumentDto dto, @PathVariable Long id){
        dto.setId(id);
        documentService.update(dto);
    }

    //for CUSTOMER and COURIER
    @PostMapping("/create")
    public void create(@RequestBody DocumentDto dto){
        documentService.create(dto);
    }
}

