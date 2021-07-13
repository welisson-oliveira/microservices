package br.com.alura.microservice.loja.infrasctructure.feign;

import br.com.alura.microservice.loja.controller.dto.OrderDTO;
import br.com.alura.microservice.loja.controller.dto.OrderItemDTO;
import br.com.alura.microservice.loja.controller.dto.SupplierDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient("fornecedor")
public interface SupplierClient {

    @GetMapping("/supplier/{state}")
    SupplierDTO getSupplierByState(@PathVariable String state);

    @PostMapping("/supplier/{id}/order")
    OrderDTO makeOrder(@PathVariable final Long id, final List<OrderItemDTO> items);

    @GetMapping("/order/{id}")
    OrderDTO getOrderById(@PathVariable Long id);
}
