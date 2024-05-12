package com.bskrobich.promocodesmanager.Service;

import com.bskrobich.promocodesmanager.DTO.PromoCodeDto;

import java.util.List;
import java.util.Optional;

public interface PromoCodeService {

    PromoCodeDto createPromoCode(PromoCodeDto promoCodeDto);

    List<PromoCodeDto> getAllPromoCodes();

    Optional<PromoCodeDto> getPromoCodeByCode(String code);

}
