package com.bskrobich.promocodesmanager.Service;

import com.bskrobich.promocodesmanager.DTO.ProductDto;
import com.bskrobich.promocodesmanager.Mapper.ProductMapper;
import com.bskrobich.promocodesmanager.Model.Product;
import com.bskrobich.promocodesmanager.Repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        return null;
    }

    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> products = repository.findAll();
        return products.stream().map(ProductMapper::entityToDto).collect(Collectors.toList());
    }

    @Override
    public ProductDto updateProduct(ProductDto productDto) {
        return null;
    }
}
