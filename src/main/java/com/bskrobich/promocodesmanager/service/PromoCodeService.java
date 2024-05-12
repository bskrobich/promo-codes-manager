package com.bskrobich.promocodesmanager.service;

import com.bskrobich.promocodesmanager.dto.PromoCodeRequestDto;
import com.bskrobich.promocodesmanager.dto.PromoCodeResponseDto;

import java.util.List;
import java.util.Optional;

public interface PromoCodeService {

    PromoCodeResponseDto createPromoCode(PromoCodeRequestDto promoCodeDto);

    List<PromoCodeResponseDto> getAllPromoCodes();

    PromoCodeResponseDto getPromoCodeByCode(String code);

}
