package com.bskrobich.promocodesmanager.service;

import com.bskrobich.promocodesmanager.dto.PromoCodeDto;
import com.bskrobich.promocodesmanager.mapper.PromoCodeMapper;
import com.bskrobich.promocodesmanager.model.PromoCode;
import com.bskrobich.promocodesmanager.repository.PromoCodeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.bskrobich.promocodesmanager.mapper.PromoCodeMapper.entityToDto;

@Service
@RequiredArgsConstructor
public class PromoCodeServiceImpl implements PromoCodeService {

    private final PromoCodeRepository repository;

    @Override
    public PromoCodeDto createPromoCode(PromoCodeDto promoCodeDto) {
        PromoCode promoCode = PromoCodeMapper.dtoToEntity(promoCodeDto);
        return entityToDto(repository.save(promoCode));
    }

    @Override
    public List<PromoCodeDto> getAllPromoCodes() {
        List<PromoCode> promoCodes = repository.findAll();
        return promoCodes.stream()
                .map(PromoCodeMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<PromoCodeDto> getPromoCodeByCode(String code) {
        Optional<PromoCode> promoCode = repository.findById(code);
        return promoCode.map(PromoCodeMapper::entityToDto);
    }
}
