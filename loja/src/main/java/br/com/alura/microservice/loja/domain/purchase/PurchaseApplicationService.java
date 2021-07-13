package br.com.alura.microservice.loja.domain.purchase;

import br.com.alura.microservice.loja.controller.dto.BookingItemDTO;
import br.com.alura.microservice.loja.controller.dto.SupplierDTO;
import br.com.alura.microservice.loja.infrasctructure.feign.SupplierClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class PurchaseApplicationService {

    private final SupplierClient supplierClient;

    @Value("${supplier-url}")
    private String url;

    @HystrixCommand(fallbackMethod = "makePurchaseFallback")
    public Purchase makePurchase(Purchase purchase) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        log.info("Buscando informações de fornecedor {}", purchase.getState());
        SupplierDTO supplier = supplierClient.getSupplierByState(purchase.getState());
        log.info("Realizando um pedido");
        BookingItemDTO order = supplierClient.makeOrder(supplier.getId(), purchase.getItems());

        return new Purchase(order.getId(), order.getPreparationTime(), purchase.getAddress(), purchase.getItems());
    }

    public Purchase makePurchaseFallback(Purchase purchase){
        log.info("FallBack: Buscando informações de fornecedor {}", purchase.getState());
        SupplierDTO supplier = supplierClient.getSupplierByState(purchase.getState());
        log.info("FallBack:  Realizando um pedido");
        BookingItemDTO order = supplierClient.makeOrder(supplier.getId(), purchase.getItems());

        return new Purchase(order.getId(), order.getPreparationTime(), purchase.getAddress(), purchase.getItems());
    }
}
