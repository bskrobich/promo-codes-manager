package com.bskrobich.promocodesmanager.service;

import com.bskrobich.promocodesmanager.dto.ProductDto;
import com.bskrobich.promocodesmanager.mapper.ProductMapper;
import com.bskrobich.promocodesmanager.model.Product;
import com.bskrobich.promocodesmanager.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.bskrobich.promocodesmanager.mapper.ProductMapper.dtoToEntity;
import static com.bskrobich.promocodesmanager.mapper.ProductMapper.entityToDto;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        Product product = dtoToEntity(productDto);
        return entityToDto(repository.save(product));
    }

    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> products = repository.findAll();
        return products.stream()
                .map(ProductMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto updateProduct(ProductDto productDto) {
        Product product = dtoToEntity(productDto);
        return entityToDto(repository.save(product));
    }
}
