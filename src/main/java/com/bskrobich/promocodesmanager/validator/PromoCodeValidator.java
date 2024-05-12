package com.bskrobich.promocodesmanager.validator;

import com.bskrobich.promocodesmanager.dto.PromoCodeRequestDto;
import com.bskrobich.promocodesmanager.repository.PromoCodeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.math.BigDecimal.ZERO;
import static java.time.LocalDate.now;

@Component
@RequiredArgsConstructor
public class PromoCodeValidator {

    private final PromoCodeRepository repository;
    private static final List<String> currencies = List.of("PLN", "GBP", "USD", "EUR", "CHF");

    public void isValidPromoCode(PromoCodeRequestDto promoCode) {
        if (repository.existsById(promoCode.getCode())) {
            throw new IllegalArgumentException(
                    "Promo code with code %s already exists".formatted(promoCode.getCode())
            );
        }
        if (!promoCode.getCode().matches("[a-zA-Z0-9]+")) {
            throw new IllegalArgumentException("Invalid promo code");
        }

        if (promoCode.getExpirationDate().isBefore(now())) {
            throw new IllegalArgumentException("Expiration date cannot be from past");
        }

        if (promoCode.getDiscountAmount().compareTo(ZERO) < 0) {
            throw new IllegalArgumentException("Discount amount cannot be negative");
        }

        if (promoCode.getMaxUsages() < 1) {
            throw new IllegalArgumentException("Max amount cannot be less than 1");
        }

        if (!currencies.contains(promoCode.getCurrency())) {
            throw new IllegalArgumentException("Invalid currency");
        }

    }
}
