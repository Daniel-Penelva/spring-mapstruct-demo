package com.api.springmapstructdemo.controller;

import com.api.springmapstructdemo.dto.ProductDto;
import com.api.springmapstructdemo.mapper.ProductMapper;
import com.api.springmapstructdemo.model.Product;
import com.api.springmapstructdemo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private ProductRepository productRepository;
    private ResponseEntity<ProductDto> productDtoResponseEntity;

    // localhost:8080/products/create
    @PostMapping("/products/create")
    public ResponseEntity<Product> save(@RequestBody ProductDto productDto) {
        return new ResponseEntity<>(productRepository.save(productMapper.dtoToModel(productDto)), HttpStatus.CREATED); // salva as propriedades do model Product
    }

    // localhost:8080/products/all
    @GetMapping("/products/all")
    public ResponseEntity<List<ProductDto>> findAll() {
        return new ResponseEntity<>(productMapper.modelsToDtos(productRepository.findAll()), HttpStatus.OK); // busca as propriedades do dto Product
    }

    // localhost:8080/products/search/{id}
    @GetMapping("/products/search/{id}")
    public ResponseEntity<ProductDto> findById(@PathVariable(value = "id") Integer id) {
        return new ResponseEntity<>(productMapper.modelToDto(productRepository.findById(id).get()), HttpStatus.OK); // busca as propriedades do dto Product
    }

    // localhost:8080/products/delete/{id}
    @DeleteMapping("/products/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable(value = "id") Integer id) {
        ProductDto productDto = productMapper.modelToDto(productRepository.findById(id).get());  // busca as propriedades do dto Product
        productRepository.deleteById(productDto.getId());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
