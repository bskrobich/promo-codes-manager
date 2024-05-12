package com.bskrobich.promocodesmanager.controller;

import com.bskrobich.promocodesmanager.dto.PromoCodeDto;
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
    public ResponseEntity<PromoCodeDto> create(@RequestBody PromoCodeDto promoCodeDto) {
        return ResponseEntity.ok(service.createPromoCode(promoCodeDto));
    }

    @GetMapping
    public ResponseEntity<List<PromoCodeDto>> getAllPromoCodes() {
        return ResponseEntity.ok(service.getAllPromoCodes());
    }

    @GetMapping("/{code}")
    public ResponseEntity<PromoCodeDto> getPromoCodeByCode(@PathVariable String code) {
        Optional<PromoCodeDto> promoCode = service.getPromoCodeByCode(code);
        return promoCode.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());

    }

}
