package br.com.alura.microservice.fornecedor.controller;

import br.com.alura.microservice.fornecedor.controller.dto.OrderItemDTO;
import br.com.alura.microservice.fornecedor.domain.supplier.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/supplier")
@RequiredArgsConstructor
public class SupplierController {

    private final SupplierApplicationServices supplierApplicationServices;
    private final OrderItemParser orderItemParser;

    @GetMapping("/{state}")
    public Supplier getSupplierByState(@PathVariable final String state){
        return supplierApplicationServices.getSupplierByState(state);
    }

    @GetMapping("/order/{id}")
    public Order getOrderById(@PathVariable Long id) {
        return supplierApplicationServices.getOrderById(id);
    }

    @PostMapping("{id}/order")
    public Order makeOrder(@PathVariable("id") Long supplierId, @RequestBody List<OrderItemDTO> items) {
        return supplierApplicationServices.makeOrder(supplierId, items.stream().map(orderItemParser::parse).collect(Collectors.toList()));
    }
}
