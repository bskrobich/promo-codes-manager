package com.bskrobich.promocodesmanager.mapper;

import com.bskrobich.promocodesmanager.dto.PurchaseDto;
import com.bskrobich.promocodesmanager.model.Purchase;

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

    public static Purchase dtoToEntity(PurchaseDto dto) {
        return Purchase.builder()
                .purchaseId(dto.getPurchaseId())
                .dateOfPurchase(dto.getDateOfPurchase())
                .regularPrice(dto.getRegularPrice())
                .amountOfDiscount(dto.getAmountOfDiscount())
                .promoCodeId(dto.getPromoCodeId())
                .productId(dto.getProductId())
                .build();
    }
}
