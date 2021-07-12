package br.com.alura.microservice.fornecedor.controller.dto;

import br.com.alura.microservice.fornecedor.domain.supplier.OrderItem;
import br.com.alura.microservice.fornecedor.domain.supplier.Product;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderItemDTO {

	private long id;
	private int quantity;
	private Long product;

}
