package com.bskrobich.promocodesmanager.Model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long productId;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private BigDecimal regularPrice;

    @Column
    private String currency;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(productId, product.productId) && Objects.equals(name, product.name) && Objects.equals(description, product.description) && Objects.equals(regularPrice, product.regularPrice) && Objects.equals(currency, product.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, name, description, regularPrice, currency);
    }
}
