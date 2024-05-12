package com.bskrobich.promocodesmanager.service;

import com.bskrobich.promocodesmanager.dto.ProductDto;

import java.util.List;

public interface ProductService {

    ProductDto createProduct(ProductDto productDto);

    List<ProductDto> getAllProducts();

    ProductDto updateProduct(ProductDto productDto);


}
