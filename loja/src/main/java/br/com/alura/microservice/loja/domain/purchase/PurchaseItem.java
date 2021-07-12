package br.com.alura.microservice.loja.domain.purchase;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class PurchaseItem {
    private long product;
    private int quantity;
}
