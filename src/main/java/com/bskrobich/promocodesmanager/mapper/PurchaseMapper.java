package com.bskrobich.promocodesmanager.mapper;

import com.bskrobich.promocodesmanager.dto.*;
import com.bskrobich.promocodesmanager.model.Purchase;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PurchaseMapper {

    public static PurchaseDto entityToDto(Purchase purchase) {
        return PurchaseDto.builder()
                .purchaseId(purchase.getPurchaseId())
                .dateOfPurchase(purchase.getDateOfPurchase())
                .regularPrice(purchase.getRegularPrice())
                .amountOfDiscount(purchase.getAmountOfDiscount())
                .promoCodeId(purchase.getPromoCodeId())
                .productId(purchase.getProductId())
                .build();
    }

    public static Purchase dtoToEntity(PurchaseRequestDto dto, BigDecimal regularPrice, BigDecimal amountOfDiscount) {
        return Purchase.builder()
                .dateOfPurchase(LocalDate.now())
                .regularPrice(regularPrice)
                .amountOfDiscount(amountOfDiscount)
                .promoCodeId(dto.getPromoCodeId())
                .productId(dto.getProductId())
                .build();
    }
}
