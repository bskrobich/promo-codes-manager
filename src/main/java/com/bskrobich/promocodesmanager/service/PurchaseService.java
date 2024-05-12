package com.bskrobich.promocodesmanager.service;

import com.bskrobich.promocodesmanager.dto.PurchaseDto;

public interface PurchaseService {

    PurchaseDto simulatePurchase(String promoCode, Long productId);
}
