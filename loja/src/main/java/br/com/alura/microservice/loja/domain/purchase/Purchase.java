package br.com.alura.microservice.loja.domain.purchase;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class Purchase {

    private Long id;
    private Integer preparationTime;
    private Address address;
    private final List<PurchaseItem> items = new ArrayList<>();

    public Purchase(final Long id, final Integer preparationTime, final Address address, List<PurchaseItem> purchaseItems){
        this.id = id;
        this.address = address;
        items.addAll(purchaseItems);
        this.preparationTime = preparationTime;
    }

    public Purchase(final Address address, List<PurchaseItem> purchaseItems){
        this.address = address;
        items.addAll(purchaseItems);
        this.preparationTime = purchaseItems.size();
    }

    public String getState() {
        return this.address != null ? this.address.getState() : null;
    }

    public List<PurchaseItem> getItems(){
        return Collections.unmodifiableList(items);
    }
}
