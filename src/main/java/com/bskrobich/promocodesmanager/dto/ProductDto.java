package com.bskrobich.promocodesmanager.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDto {
    private Long productId;
    private String name;
    private String description;
    private BigDecimal regularPrice;
    private String currency;
}
