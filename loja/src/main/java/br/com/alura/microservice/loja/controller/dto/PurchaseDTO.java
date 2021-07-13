package br.com.alura.microservice.loja.controller.dto;

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
public class PurchaseDTO {

	private Long id;
	private OrderDTO order;

	public List<OrderItemDTO> getItems() {
		return Collections.unmodifiableList(order.getItems());
	}

	public String getState() {
		return order != null ? order.getState() : null;
	}
}
