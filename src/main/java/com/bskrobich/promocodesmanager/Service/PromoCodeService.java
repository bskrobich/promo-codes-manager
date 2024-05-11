package com.bskrobich.promocodesmanager.Service;

import com.bskrobich.promocodesmanager.DTO.PromoCodeDto;

import java.util.List;

public interface PromoCodeService {

    PromoCodeDto createPromoCode(PromoCodeDto promoCodeDto);

    List<PromoCodeDto> getAllPromoCodes();

    PromoCodeDto getPromoCodeByCode(String code);

}
