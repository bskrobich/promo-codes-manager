package com.bskrobich.promocodesmanager.service;

import com.bskrobich.promocodesmanager.dto.ProductDto;
import com.bskrobich.promocodesmanager.mapper.ProductMapper;
import com.bskrobich.promocodesmanager.model.Product;
import com.bskrobich.promocodesmanager.repository.ProductRepository;
import com.bskrobich.promocodesmanager.validator.ProductValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static com.bskrobich.promocodesmanager.mapper.ProductMapper.dtoToEntity;
import static com.bskrobich.promocodesmanager.mapper.ProductMapper.entityToDto;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;
    private final ProductValidator validator;

    @Override
    @Transactional
    public ProductDto createProduct(ProductDto productDto) {
        validator.isValidProduct(productDto);
        Product product = dtoToEntity(productDto);
        return entityToDto(repository.save(product));
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductDto> getAllProducts() {
        List<Product> products = repository.findAll();
        return products.stream()
                .map(ProductMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public ProductDto updateProduct(Long id, ProductDto productDto) {
        validator.validateProductExists(id);
        validator.isValidProduct(productDto);
        Product product = repository.findById(id).get();
        ProductMapper.updateEntity(product, productDto);
        return entityToDto(repository.save(product));
    }
}
