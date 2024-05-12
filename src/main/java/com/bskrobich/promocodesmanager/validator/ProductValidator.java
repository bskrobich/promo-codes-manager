package com.bskrobich.promocodesmanager.validator;

import com.bskrobich.promocodesmanager.dto.ProductDto;
import com.bskrobich.promocodesmanager.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.NoSuchElementException;

import static java.math.BigDecimal.ZERO;

@Component
@RequiredArgsConstructor
public class ProductValidator {

    private final ProductRepository repository;
    private static final List<String> currencies = List.of("PLN", "GBP", "USD", "EUR", "CHF");

    public void isValidProduct(ProductDto product) {
        if (product.getRegularPrice().compareTo(ZERO) < 0) {
            throw new IllegalArgumentException("Regular price cannot be negative");
        }

        if (!currencies.contains(product.getCurrency())) {
            throw new IllegalArgumentException("Invalid currency");
        }
    }

    public void validateProductExists(Long id) {
        if (!repository.existsById(id)) {
            throw new NoSuchElementException("Product with Id %s does not exist".formatted(id));
        }
    }
}
