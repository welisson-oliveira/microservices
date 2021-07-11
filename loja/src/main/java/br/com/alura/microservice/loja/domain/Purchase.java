package br.com.alura.microservice.loja.domain;

import br.com.alura.microservice.loja.controller.dto.AddressDTO;
import br.com.alura.microservice.loja.controller.dto.PurchaseItemDTO;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class Purchase {

    private Address address;
    private final List<PurchaseItem> items = new ArrayList<>();

    public Purchase(final Address address, List<PurchaseItem> purchaseItems){
        this.address = address;
        items.addAll(purchaseItems);
    }

    public String getState() {
        return this.address != null ? this.address.getState() : null;
    }
}
