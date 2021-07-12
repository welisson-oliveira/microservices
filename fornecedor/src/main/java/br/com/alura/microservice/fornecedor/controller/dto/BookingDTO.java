package br.com.alura.microservice.fornecedor.controller.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BookingDTO {

	public Integer id;
	public Integer preparationTime;
}
