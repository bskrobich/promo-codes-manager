package com.bskrobich.promocodesmanager.service;

import com.bskrobich.promocodesmanager.dto.PromoCodeDto;

import java.util.List;
import java.util.Optional;

public interface PromoCodeService {

    PromoCodeDto createPromoCode(PromoCodeDto promoCodeDto);

    List<PromoCodeDto> getAllPromoCodes();

    Optional<PromoCodeDto> getPromoCodeByCode(String code);

}
