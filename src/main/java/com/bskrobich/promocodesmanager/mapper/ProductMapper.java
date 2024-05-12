package com.bskrobich.promocodesmanager.mapper;

import com.bskrobich.promocodesmanager.dto.ProductDto;
import com.bskrobich.promocodesmanager.model.Product;

public class ProductMapper {

    public static ProductDto entityToDto(Product product) {
        return ProductDto.builder()
                .productId(product.getProductId())
                .name(product.getName())
                .regularPrice(product.getRegularPrice())
                .currency(product.getCurrency())
                .build();
    }

    public static Product dtoToEntity(ProductDto productDto) {
        return Product.builder()
                .productId(productDto.getProductId())
                .name(productDto.getName())
                .regularPrice(productDto.getRegularPrice())
                .currency(productDto.getCurrency())
                .build();
    }
}
