package br.com.alura.microservice.loja.controller.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class AddressDTO {

	private Long id;
	private String street;
	private int number;
	private String state;

	@Override
	public String toString() {
		return "AddressDTO{" +
				"id=" + id +
				", street='" + street + '\'' +
				", number=" + number +
				", state='" + state + '\'' +
				'}';
	}
}
