package br.com.alura.microservice.loja.controller;

import br.com.alura.microservice.loja.domain.PurchaseApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import br.com.alura.microservice.loja.controller.dto.PurchaseDTO;

@RestController
@RequestMapping("/purchase")
@RequiredArgsConstructor
public class PurchaseController {

	private final PurchaseApplicationService purchaseApplicationService;

	@PostMapping
	public void makePurchase(@RequestBody PurchaseDTO purchase) {
		purchaseApplicationService.makePurchase(purchase.convert());
	}
}
