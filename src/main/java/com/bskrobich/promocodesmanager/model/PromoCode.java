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
public class PromoCode {
    @Id
    @Column
    private String code;

    @Column
    private LocalDate expirationDate;

    @Column
    private BigDecimal discountAmount;

    @Column
    private String currency;

    @Column
    private int maxUsages;

    @Column
    private int numberOfUsages;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PromoCode promoCode = (PromoCode) o;
        return maxUsages == promoCode.maxUsages && numberOfUsages == promoCode.numberOfUsages && Objects.equals(code, promoCode.code) && Objects.equals(expirationDate, promoCode.expirationDate) && Objects.equals(discountAmount, promoCode.discountAmount) && Objects.equals(currency, promoCode.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, expirationDate, discountAmount, currency, maxUsages, numberOfUsages);
    }
}
