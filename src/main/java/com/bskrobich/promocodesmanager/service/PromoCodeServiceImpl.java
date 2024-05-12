package com.bskrobich.promocodesmanager.service;

import com.bskrobich.promocodesmanager.dto.PromoCodeRequestDto;
import com.bskrobich.promocodesmanager.dto.PromoCodeResponseDto;
import com.bskrobich.promocodesmanager.mapper.PromoCodeMapper;
import com.bskrobich.promocodesmanager.model.PromoCode;
import com.bskrobich.promocodesmanager.repository.PromoCodeRepository;
import com.bskrobich.promocodesmanager.validator.PromoCodeValidator;
import jakarta.persistence.NoResultException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import static com.bskrobich.promocodesmanager.mapper.PromoCodeMapper.entityToDto;

@Service
@RequiredArgsConstructor
public class PromoCodeServiceImpl implements PromoCodeService {

    private final PromoCodeRepository repository;
    private final PromoCodeValidator validator;

    @Override
    public PromoCodeResponseDto createPromoCode(PromoCodeRequestDto promoCodeDto) {
        validator.isValidPromoCode(promoCodeDto);
        PromoCode promoCode = PromoCodeMapper.dtoToEntity(promoCodeDto);
        return entityToDto(repository.save(promoCode));
    }

    @Override
    public List<PromoCodeResponseDto> getAllPromoCodes() {
        List<PromoCode> promoCodes = repository.findAll();
        return promoCodes.stream()
                .map(PromoCodeMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public PromoCodeResponseDto getPromoCodeByCode(String code) {
        return repository.findById(code)
                .map(PromoCodeMapper::entityToDto)
                .orElseThrow(NoSuchElementException::new);
    }
}
