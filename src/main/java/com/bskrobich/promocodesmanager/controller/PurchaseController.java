package com.bskrobich.promocodesmanager.controller;

import com.bskrobich.promocodesmanager.dto.PurchaseDto;
import com.bskrobich.promocodesmanager.service.PurchaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/purchase")
@RequiredArgsConstructor
public class PurchaseController {

    private final PurchaseService service;

    @PostMapping
    public ResponseEntity<PurchaseDto> simulatePurchase(
            @RequestParam(value = "productId") Long productId,
            @RequestParam(value = "promoCode", required = false) String promoCode
    )
    {
        PurchaseDto purchaseDto = service.simulatePurchase(promoCode, productId);

        return ResponseEntity.ok(purchaseDto);
    }

}
