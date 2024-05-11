package com.bskrobich.promocodesmanager.Service;

import com.bskrobich.promocodesmanager.DTO.ProductDto;

import java.util.List;

public interface ProductService {

    ProductDto createProduct(ProductDto productDto);

    List<ProductDto> getAllProducts();

    ProductDto updateProduct(ProductDto productDto);


}
