package br.com.alura.microservice.loja.controller.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class ProductDTO {
    private Long id;
    private String name;
    private String state;
    private String description;
    private BigDecimal price;
}
