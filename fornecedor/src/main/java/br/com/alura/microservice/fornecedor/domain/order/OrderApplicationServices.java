package br.com.alura.microservice.fornecedor.domain.order;

import br.com.alura.microservice.fornecedor.domain.supplier.Order;
import br.com.alura.microservice.fornecedor.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderApplicationServices {

    private final OrderRepository orderRepository;

    public Order getOrderById(final Long id){
        return orderRepository.findById(id).orElse(null);
    }
}
