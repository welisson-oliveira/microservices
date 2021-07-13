package br.com.alura.microservice.loja.domain.purchase;

import br.com.alura.microservice.loja.controller.dto.PurchaseDTO;
import br.com.alura.microservice.loja.infrasctructure.feign.SupplierClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PurchaseParser {

    private final SupplierClient supplierClient;

    public PurchaseDTO parseToDTO(Purchase purchase) {
        return new PurchaseDTO(purchase.getId(), supplierClient.getOrderById(purchase.getOrderId()));
    }

}
