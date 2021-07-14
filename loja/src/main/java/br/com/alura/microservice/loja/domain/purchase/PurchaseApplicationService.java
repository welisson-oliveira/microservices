package br.com.alura.microservice.loja.domain.purchase;

import br.com.alura.microservice.loja.controller.dto.*;
import br.com.alura.microservice.loja.infrasctructure.feign.SupplierClient;
import br.com.alura.microservice.loja.infrasctructure.feign.TransporterClient;
import br.com.alura.microservice.loja.repository.PurchaseRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class PurchaseApplicationService {

    private final SupplierClient supplierClient;
    private final TransporterClient transporterClient;
    private final PurchaseRepository purchaseRepository;

//    @HystrixCommand(fallbackMethod = "makePurchaseFallback", threadPoolKey = "makePurchase")
    @Transactional
    public PurchaseDTO makePurchase(PurchaseRequestDTO purchaseRequest) {
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        log.info("Buscando informações de fornecedor {}", purchaseRequest.getState());
        SupplierDTO supplier = supplierClient.getSupplierByState(purchaseRequest.getState());
        log.info("Realizando um pedido");
        OrderDTO order = supplierClient.makeOrder(supplier.getId(), purchaseRequest.getItems());

        DeliveryDTO deliveryDTO = new DeliveryDTO(order.getId(), LocalDate.now().plusDays(order.getPreparationTime()), supplier.getAddress(), purchaseRequest.getAddress().toString());
        VoucherDTO voucher = transporterClient.bookingDelivery(deliveryDTO);

        Purchase purchase = new Purchase(null, order.getId(), voucher.getDeliveryForecast(), voucher.getNumber());
        purchaseRepository.save(purchase);
        return new PurchaseDTO(purchase.getId(), order);
    }

//    public PurchaseDTO makePurchaseFallback(PurchaseRequestDTO purchaseRequest){
//        log.info("Buscando informações de fornecedor {}", purchaseRequest.getState());
////        SupplierDTO supplier = supplierClient.getSupplierByState(purchaseRequest.getState());
//        log.info("Realizando um pedido");
////        OrderDTO order = supplierClient.makeOrder(supplier.getId(), purchaseRequest.getItems());
//
////        Purchase purchase = new Purchase(null, order.getId());
////        purchaseRepository.save(purchase);
////        return new PurchaseDTO(purchase.getId(), order);
//        return null;
//    }

    @HystrixCommand(threadPoolKey = "getPurchaseById")
    public Purchase getPurchaseById(Long id) {
        return purchaseRepository.findById(id).orElseThrow(() -> new RuntimeException("Compra não encontrada"));
    }

    @HystrixCommand(threadPoolKey = "getAllPurchase")
    public List<Purchase> getAllPurchase() {
        return (List<Purchase>) purchaseRepository.findAll();
    }
}
