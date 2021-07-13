package br.com.alura.microservice.loja.controller;

import br.com.alura.microservice.loja.domain.purchase.Purchase;
import br.com.alura.microservice.loja.domain.purchase.PurchaseApplicationService;
import br.com.alura.microservice.loja.domain.purchase.PurchaseParser;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import br.com.alura.microservice.loja.controller.dto.PurchaseDTO;

import java.util.List;

@RestController
@RequestMapping("/purchase")
@RequiredArgsConstructor
public class PurchaseController {

	private final PurchaseApplicationService purchaseApplicationService;
	private final PurchaseParser parser;

	@PostMapping
	public PurchaseDTO makePurchase(@RequestBody PurchaseDTO purchase) {
		return parser.parseToDTO(purchaseApplicationService.makePurchase(parser.parse(purchase)));
	}

	@GetMapping("/{id}")
	public PurchaseDTO getById(@PathVariable final Long id){
		return parser.parseToDTO(this.purchaseApplicationService.getById(id));
	}
}
