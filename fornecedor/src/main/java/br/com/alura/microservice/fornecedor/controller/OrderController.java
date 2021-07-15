package br.com.alura.microservice.fornecedor.controller;

import br.com.alura.microservice.fornecedor.domain.order.OrderApplicationServices;
import br.com.alura.microservice.fornecedor.domain.supplier.Order;
import br.com.alura.microservice.fornecedor.domain.supplier.OrderState;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderApplicationServices orderApplicationServices;

    @GetMapping("/{id}")
    public Order getOrder(@PathVariable final Long id){
        return orderApplicationServices.getOrderById(id);
    }

    @PostMapping
    public Order createOrder(){
        return new Order(1L,3, OrderState.RECEIVED, Collections.emptyList());
    }
}
