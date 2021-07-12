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

	private AddressDTO address;
	private List<PurchaseItemDTO> items;

	public List<PurchaseItemDTO> getItems() {
		return Collections.unmodifiableList(items);
	}

	public Purchase convert() {
		return new Purchase(new Address(this.getAddress().getStreet(), this.getAddress().getNumber(), this.address.getState()),
				this.getItems().stream().map(item -> new PurchaseItem(item.getProduct(), item.getQuantity())).collect(Collectors.toList()));
	}
}
