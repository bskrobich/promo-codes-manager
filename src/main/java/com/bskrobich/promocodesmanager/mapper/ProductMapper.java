package com.bskrobich.promocodesmanager.mapper;

import com.bskrobich.promocodesmanager.dto.ProductDto;
import com.bskrobich.promocodesmanager.model.Product;

public class ProductMapper {

    public static ProductDto entityToDto(Product product) {
        return ProductDto.builder()
                .productId(product.getProductId())
                .name(product.getName())
                .description(product.getDescription())
                .regularPrice(product.getRegularPrice())
                .currency(product.getCurrency())
                .build();
    }

    public static Product dtoToEntity(ProductDto productDto) {
        return Product.builder()
                .productId(productDto.getProductId())
                .name(productDto.getName())
                .description(productDto.getDescription())
                .regularPrice(productDto.getRegularPrice())
                .currency(productDto.getCurrency())
                .build();
    }

    public static void updateEntity(Product product, ProductDto productDto) {
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setRegularPrice(productDto.getRegularPrice());
    }
}
