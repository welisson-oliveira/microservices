package br.com.alura.microservice.loja.controller;

import br.com.alura.microservice.loja.controller.dto.PurchaseRequestDTO;
import br.com.alura.microservice.loja.domain.purchase.PurchaseApplicationService;
import br.com.alura.microservice.loja.domain.purchase.PurchaseParser;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import br.com.alura.microservice.loja.controller.dto.PurchaseDTO;

@RestController
@RequestMapping("/purchase")
@RequiredArgsConstructor
public class PurchaseController {

	private final PurchaseApplicationService purchaseApplicationService;
	private final PurchaseParser parser;

	@PostMapping
	public PurchaseDTO makePurchase(@RequestBody PurchaseRequestDTO purchase) {
		return purchaseApplicationService.makePurchase(purchase);
	}

	@GetMapping("/{id}")
	public PurchaseDTO getById(@PathVariable final Long id){
		return parser.parseToDTO(this.purchaseApplicationService.getPurchaseById(id));
	}
}
