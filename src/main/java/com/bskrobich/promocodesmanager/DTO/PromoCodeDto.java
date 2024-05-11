package com.bskrobich.promocodesmanager.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PromoCodeDto {
    private String code;
    private LocalDate expirationDate;
    private BigDecimal discountAmount;
    private String currency;
    private int maxUsages;
    private int numberOfUsages;
}
