package com.bskrobich.promocodesmanager.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Purchase {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long purchaseId;

    @Column
    private LocalDate dateOfPurchase;

    @Column
    private BigDecimal regularPrice;

    @Column
    private BigDecimal amountOfDiscount;

    @Column
    private String promoCodeId;

    @Column
    private Long productId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Purchase purchase = (Purchase) o;
        return Objects.equals(purchaseId, purchase.purchaseId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(purchaseId);
    }
}
