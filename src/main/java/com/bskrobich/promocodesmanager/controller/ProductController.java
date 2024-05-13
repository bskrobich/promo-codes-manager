package com.bskrobich.promocodesmanager.controller;

import com.bskrobich.promocodesmanager.dto.ProductDto;
import com.bskrobich.promocodesmanager.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    @PostMapping
    public ResponseEntity<ProductDto> create(@RequestBody ProductDto productDto) {
        return ResponseEntity.ok().body(service.createProduct(productDto));
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        return ResponseEntity.ok().body(service.getAllProducts());
    }

    @PutMapping("/{productId}")
    public ResponseEntity<ProductDto> update(@PathVariable("productId") final Long productId, @RequestBody ProductDto productDto) {
        return ResponseEntity.ok().body(service.updateProduct(productId, productDto));
    }
}
