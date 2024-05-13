package com.bskrobich.promocodesmanager.controller;

import com.bskrobich.promocodesmanager.dto.DiscountDto;
import com.bskrobich.promocodesmanager.service.DiscountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/discount-price")
@RequiredArgsConstructor
public class DiscountController {

    private final DiscountService discountService;

    @GetMapping
    public ResponseEntity<DiscountDto> getDiscount(
            @RequestParam(value = "productId") Long productId,
            @RequestParam(value = "promoCode", required = false) String promoCode
    )
    {
        return ResponseEntity.ok(discountService.getDiscount(productId, promoCode));
    }
}
