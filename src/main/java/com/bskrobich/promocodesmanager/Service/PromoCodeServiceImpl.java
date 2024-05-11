package com.bskrobich.promocodesmanager.Service;

import com.bskrobich.promocodesmanager.DTO.PromoCodeDto;
import com.bskrobich.promocodesmanager.Repository.PromoCodeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PromoCodeServiceImpl implements PromoCodeService {

    private final PromoCodeRepository repository;

    @Override
    public PromoCodeDto createPromoCode(PromoCodeDto promoCodeDto) {
        return null;
    }

    @Override
    public List<PromoCodeDto> getAllPromoCodes() {
        return List.of();
    }

    @Override
    public PromoCodeDto getPromoCodeByCode(String code) {
        return null;
    }
}
