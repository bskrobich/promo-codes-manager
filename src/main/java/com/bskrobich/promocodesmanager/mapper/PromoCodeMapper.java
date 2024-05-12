package com.bskrobich.promocodesmanager.mapper;

import com.bskrobich.promocodesmanager.dto.PromoCodeRequestDto;
import com.bskrobich.promocodesmanager.dto.PromoCodeResponseDto;
import com.bskrobich.promocodesmanager.model.PromoCode;

public class PromoCodeMapper {

    public static PromoCodeResponseDto entityToDto(PromoCode promoCode) {
        return PromoCodeResponseDto.builder()
                .code(promoCode.getCode())
                .expirationDate(promoCode.getExpirationDate())
                .discountAmount(promoCode.getDiscountAmount())
                .currency(promoCode.getCurrency())
                .maxUsages(promoCode.getMaxUsages())
                .numberOfUsages(promoCode.getNumberOfUsages())
                .build();
    }

    public static PromoCode dtoToEntity(PromoCodeRequestDto promoCodeDto) {
        return PromoCode.builder()
                .code(promoCodeDto.getCode())
                .expirationDate(promoCodeDto.getExpirationDate())
                .discountAmount(promoCodeDto.getDiscountAmount())
                .currency(promoCodeDto.getCurrency())
                .maxUsages(promoCodeDto.getMaxUsages())
                .numberOfUsages(0)
                .build();
    }
}
