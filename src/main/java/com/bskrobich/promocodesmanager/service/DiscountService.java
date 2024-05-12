package com.bskrobich.promocodesmanager.service;

import com.bskrobich.promocodesmanager.dto.DiscountDto;


public interface DiscountService {

    DiscountDto getDiscount(Long productId, String promoCode);


}
