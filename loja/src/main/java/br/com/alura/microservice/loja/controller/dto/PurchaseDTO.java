package br.com.alura.microservice.loja.controller.dto;

import br.com.alura.microservice.loja.domain.purchase.Address;
import br.com.alura.microservice.loja.domain.purchase.Purchase;
import br.com.alura.microservice.loja.domain.purchase.PurchaseItem;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class PurchaseDTO {

	private Long id;
	private AddressDTO address;
	private Integer preparationTime;
	private List<PurchaseItemDTO> items;

	public List<PurchaseItemDTO> getItems() {
		return Collections.unmodifiableList(items);
	}

	public PurchaseDTO(final Long id, final Integer preparationTime, final AddressDTO address, List<PurchaseItemDTO> purchaseItems){
		this.id = id;
		this.address = address;
		items.addAll(purchaseItems);
		this.preparationTime = preparationTime;
	}


	public String getState() {
		return address != null ? address.getState() : null;
	}
}
