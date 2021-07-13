package br.com.alura.microservice.loja.controller.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class OrderDTO {
    private Long id;
    private Integer preparationTime;
    private AddressDTO address;
    private List<OrderItemDTO> items;

    public List<OrderItemDTO> getItems() {
        return Collections.unmodifiableList(items);
    }


    public String getState() {
        return address != null ? address.getState() : null;
    }
}
