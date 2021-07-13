package br.com.alura.microservice.transportador.controller.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class DeliveryDTO {
	private Long orderId;
	private LocalDate deliveryDate;
	private String originAddress;
	private String destinyAddress;
}
