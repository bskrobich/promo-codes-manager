package com.bskrobich.promocodesmanager.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
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
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PurchaseDto {
    private Long purchaseId;
    private LocalDate dateOfPurchase;
    private BigDecimal regularPrice;
    private BigDecimal amountOfDiscount;
    private String promoCodeId;
    private Long productId;
}
