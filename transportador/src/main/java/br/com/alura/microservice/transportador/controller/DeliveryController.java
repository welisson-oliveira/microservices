package br.com.alura.microservice.transportador.controller;

import br.com.alura.microservice.transportador.domain.DeliveryApplicationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.microservice.transportador.controller.dto.DeliveryDTO;
import br.com.alura.microservice.transportador.controller.dto.VoucherDTO;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {
	
	@Autowired
	private DeliveryApplicationServices deliveryApplicationServices;

	@RequestMapping(method = RequestMethod.POST)
	public VoucherDTO bookDelivery(@RequestBody DeliveryDTO orderDTO) {
		return deliveryApplicationServices.bookDelivery(orderDTO);
	}
}
