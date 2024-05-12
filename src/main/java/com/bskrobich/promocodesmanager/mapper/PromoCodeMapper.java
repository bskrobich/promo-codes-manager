package com.bskrobich.promocodesmanager.mapper;

import com.bskrobich.promocodesmanager.dto.PromoCodeDto;
import com.bskrobich.promocodesmanager.model.PromoCode;

public class PromoCodeMapper {

    public static PromoCodeDto entityToDto(PromoCode promoCode) {
        return PromoCodeDto.builder()
                .code(promoCode.getCode())
                .expirationDate(promoCode.getExpirationDate())
                .discountAmount(promoCode.getDiscountAmount())
                .currency(promoCode.getCurrency())
                .maxUsages(promoCode.getMaxUsages())
                .numberOfUsages(promoCode.getNumberOfUsages())
                .build();
    }

    public static PromoCode dtoToEntity(PromoCodeDto promoCodeDto) {
        return PromoCode.builder()
                .code(promoCodeDto.getCode())
                .expirationDate(promoCodeDto.getExpirationDate())
                .discountAmount(promoCodeDto.getDiscountAmount())
                .currency(promoCodeDto.getCurrency())
                .maxUsages(promoCodeDto.getMaxUsages())
                .numberOfUsages(promoCodeDto.getNumberOfUsages())
                .build();
    }
}
