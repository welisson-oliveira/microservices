package br.com.alura.microservice.loja.domain.purchase;

import br.com.alura.microservice.loja.controller.dto.AddressDTO;
import br.com.alura.microservice.loja.controller.dto.PurchaseDTO;
import br.com.alura.microservice.loja.controller.dto.PurchaseItemDTO;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class PurchaseParser {
    public Purchase parse(final PurchaseDTO purchaseDTO) {
        return new Purchase(new Address(purchaseDTO.getAddress().getId(), purchaseDTO.getAddress().getStreet(), purchaseDTO.getAddress().getNumber(), purchaseDTO.getState()),
                purchaseDTO.getItems().stream().map(item -> new PurchaseItem(item.getId(), item.getProduct(), item.getQuantity())).collect(Collectors.toList()));
    }

    public PurchaseDTO parseToDTO(Purchase purchase) {
        return new PurchaseDTO(purchase.getId(), purchase.getPreparationTime(), new AddressDTO(purchase.getAddress().getId(), purchase.getAddress().getStreet(), purchase.getAddress().getNumber(), purchase.getState()),
                purchase.getItems().stream().map(item -> new PurchaseItemDTO(item.getId(), item.getProduct(), item.getQuantity())).collect(Collectors.toList()));
    }
}
