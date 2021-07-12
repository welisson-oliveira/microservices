package br.com.alura.microservice.loja.controller.dto;

import br.com.alura.microservice.loja.domain.purchase.Address;
import br.com.alura.microservice.loja.domain.purchase.PurchaseItem;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class BookingItemDTO {
    private Long id;
    private Integer preparationTime;
    private Address address;
    private List<OrderItemDTO> items;

    public List<OrderItemDTO> getItems() {
        return Collections.unmodifiableList(items);
    }


}
