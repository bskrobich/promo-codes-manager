package com.bskrobich.promocodesmanager.service;

import com.bskrobich.promocodesmanager.dto.DiscountDto;
import com.bskrobich.promocodesmanager.dto.ProductDto;
import com.bskrobich.promocodesmanager.dto.PromoCodeResponseDto;
import com.bskrobich.promocodesmanager.mapper.ProductMapper;
import com.bskrobich.promocodesmanager.mapper.PromoCodeMapper;
import com.bskrobich.promocodesmanager.model.Product;
import com.bskrobich.promocodesmanager.model.PromoCode;
import com.bskrobich.promocodesmanager.repository.ProductRepository;
import com.bskrobich.promocodesmanager.repository.PromoCodeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.NoSuchElementException;

import static java.time.LocalDate.now;

@Service
@RequiredArgsConstructor
public class DiscountServiceImpl implements DiscountService {

    private final ProductRepository productRepository;
    private final PromoCodeRepository promoCodeRepository;

    @Override
    @Transactional(readOnly = true)
    public DiscountDto getDiscount(Long productId, String promoCodeId) {

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new NoSuchElementException("Product not found"));

        DiscountDto discountDto = DiscountDto.builder()
                .productId(productId)
                .build();

        if (promoCodeId == null) {
            discountDto.setDiscountPrice(product.getRegularPrice());
            return discountDto;
        }

        PromoCode promoCode = promoCodeRepository.findById(promoCodeId)
                .orElseThrow(() -> new NoSuchElementException("Promo code not found"));

        discountDto.setPromoCode(promoCodeId);

        if (promoCode.getExpirationDate().isBefore(now())) {
            discountDto.setDiscountPrice(product.getRegularPrice());
            discountDto.setWarning("Promo code expired");
            return discountDto;
        }

        if (!promoCode.getCurrency().equals(product.getCurrency())) {
            discountDto.setDiscountPrice(product.getRegularPrice());
            discountDto.setWarning("Promo code and Product currency do not match");
            return discountDto;
        }

        if (promoCode.getNumberOfUsages() >= promoCode.getMaxUsages()) {
            discountDto.setDiscountPrice(product.getRegularPrice());
            discountDto.setWarning("Promo code exceeded max usages");
            return discountDto;
        }

        BigDecimal discountPrice = product.getRegularPrice()
                .subtract(promoCode.getDiscountAmount());

        if (discountPrice.compareTo(BigDecimal.ZERO) < 0) {
            discountDto.setDiscountPrice(BigDecimal.ZERO);
            return discountDto;
        }

        discountDto.setDiscountPrice(discountPrice);

        return discountDto;
    }
}
