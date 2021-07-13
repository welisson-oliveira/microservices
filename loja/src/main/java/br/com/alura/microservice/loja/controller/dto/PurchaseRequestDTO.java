package br.com.alura.microservice.loja.controller.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class PurchaseRequestDTO {
    private List<OrderItemDTO> items = new ArrayList<>();
    private AddressDTO address;

    public String getState() {
        return address != null ? address.getState() : null;
    }
}
