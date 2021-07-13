package br.com.alura.microservice.loja.controller.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class OrderItemDTO {
    private Long id;
    private Integer quantity;
    private ProductDTO product;

    public Long getProductId(){
        return product.getId();
    }
}
