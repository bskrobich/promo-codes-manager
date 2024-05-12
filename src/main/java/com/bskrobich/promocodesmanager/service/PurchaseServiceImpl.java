package com.bskrobich.promocodesmanager.service;

import com.bskrobich.promocodesmanager.dto.*;
import com.bskrobich.promocodesmanager.mapper.ProductMapper;
import com.bskrobich.promocodesmanager.mapper.PurchaseMapper;
import com.bskrobich.promocodesmanager.model.Product;
import com.bskrobich.promocodesmanager.model.PromoCode;
import com.bskrobich.promocodesmanager.model.Purchase;
import com.bskrobich.promocodesmanager.repository.ProductRepository;
import com.bskrobich.promocodesmanager.repository.PromoCodeRepository;
import com.bskrobich.promocodesmanager.repository.PurchaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

import static com.bskrobich.promocodesmanager.mapper.PromoCodeMapper.updateNumberOfUsages;
import static com.bskrobich.promocodesmanager.mapper.PurchaseMapper.dtoToEntity;

@Service
@RequiredArgsConstructor
public class PurchaseServiceImpl implements PurchaseService {

    private final PurchaseRepository purchaseRepository;
    private final ProductRepository productRepository;
    private final PromoCodeRepository promoCodeRepository;
    private final DiscountService discountService;

    @Override
    @Transactional
    public PurchaseDto simulatePurchase(String promoCode, Long productId) {

        DiscountDto discountDto = discountService.getDiscount(productId, promoCode);
        Product product = productRepository.findById(productId).get();
        ProductDto productDto = ProductMapper.entityToDto(product);

        PurchaseRequestDto requestDto = PurchaseRequestDto.builder()
                .productId(productId)
                .promoCodeId(promoCode)
                .build();

        Purchase purchase;
        if (Objects.equals(discountDto.getDiscountPrice(), productDto.getRegularPrice())) {
            purchase = dtoToEntity(
                    requestDto, productDto.getRegularPrice(), null
            );
        } else {
            PromoCode promoCodeEntity = promoCodeRepository.findById(promoCode).get();
            purchase = dtoToEntity(
                    requestDto, productDto.getRegularPrice(), promoCodeEntity.getDiscountAmount()
            );
            updateNumberOfUsages(promoCodeEntity);
            promoCodeRepository.save(promoCodeEntity);
        }
        return PurchaseMapper.entityToDto(purchaseRepository.save(purchase));
    }
}
