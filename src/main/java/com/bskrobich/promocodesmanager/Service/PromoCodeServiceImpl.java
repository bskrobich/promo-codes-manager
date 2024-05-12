package com.bskrobich.promocodesmanager.Service;

import com.bskrobich.promocodesmanager.DTO.PromoCodeDto;
import com.bskrobich.promocodesmanager.Mapper.PromoCodeMapper;
import com.bskrobich.promocodesmanager.Model.PromoCode;
import com.bskrobich.promocodesmanager.Repository.PromoCodeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.bskrobich.promocodesmanager.Mapper.PromoCodeMapper.entityToDto;

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
