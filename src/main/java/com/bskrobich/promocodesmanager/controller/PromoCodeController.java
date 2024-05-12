package com.bskrobich.promocodesmanager.controller;

import com.bskrobich.promocodesmanager.dto.PromoCodeRequestDto;
import com.bskrobich.promocodesmanager.dto.PromoCodeResponseDto;
import com.bskrobich.promocodesmanager.service.PromoCodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/promoCodes")
@RequiredArgsConstructor
public class PromoCodeController {

    private final PromoCodeService service;

    @PostMapping
    public ResponseEntity<PromoCodeResponseDto> create(@RequestBody PromoCodeRequestDto promoCodeDto) {
        return ResponseEntity.ok(service.createPromoCode(promoCodeDto));
    }

    @GetMapping
    public ResponseEntity<List<PromoCodeResponseDto>> getAllPromoCodes() {
        return ResponseEntity.ok(service.getAllPromoCodes());
    }

    @GetMapping("/{code}")
    public ResponseEntity<PromoCodeResponseDto> getPromoCodeByCode(@PathVariable String code) {
        return ResponseEntity.ok(service.getPromoCodeByCode(code));

    }

}
