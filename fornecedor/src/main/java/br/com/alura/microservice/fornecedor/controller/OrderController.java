package br.com.alura.microservice.fornecedor.controller;

import br.com.alura.microservice.fornecedor.domain.order.OrderApplicationServices;
import br.com.alura.microservice.fornecedor.domain.supplier.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderApplicationServices orderApplicationServices;

    @GetMapping("/{id}")
    public Order getOrder(@PathVariable final Long id){
        return orderApplicationServices.getOrderById(id);
    }
}
