package com.bskrobich.promocodesmanager.service;

import com.bskrobich.promocodesmanager.dto.DiscountDto;

import java.math.BigDecimal;

public interface DiscountService {

    DiscountDto getDiscount(Long productId, String promoCode);


}
