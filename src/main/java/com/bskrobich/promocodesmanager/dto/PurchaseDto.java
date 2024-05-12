package com.bskrobich.promocodesmanager.dto;

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
public class PurchaseDto {
    private Long purchaseId;
    private LocalDate dateOfPurchase;
    private BigDecimal regularPrice;
    private BigDecimal amountOfDiscount;
    private String promoCodeId;
    private int productId;
}
