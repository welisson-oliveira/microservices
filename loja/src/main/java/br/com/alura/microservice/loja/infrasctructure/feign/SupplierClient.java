package br.com.alura.microservice.loja.infrasctructure.feign;

import br.com.alura.microservice.loja.controller.dto.BookingItemDTO;
import br.com.alura.microservice.loja.controller.dto.PurchaseDTO;
import br.com.alura.microservice.loja.controller.dto.SupplierDTO;
import br.com.alura.microservice.loja.domain.purchase.PurchaseItem;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.function.Supplier;

@FeignClient("fornecedor")
public interface SupplierClient {

    @GetMapping("/supplier/{state}")
    SupplierDTO getSupplierByState(@PathVariable String state);

    @PostMapping("/supplier/{id}/order")
    BookingItemDTO makeOrder(@PathVariable final Long id, final List<PurchaseItem> items);
}
