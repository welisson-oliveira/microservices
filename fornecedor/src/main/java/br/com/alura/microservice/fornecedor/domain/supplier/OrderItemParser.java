package br.com.alura.microservice.fornecedor.domain.supplier;

import br.com.alura.microservice.fornecedor.controller.dto.OrderItemDTO;
import br.com.alura.microservice.fornecedor.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderItemParser {

    private final ProductRepository productRepository;

    public OrderItem parse(OrderItemDTO orderItemDTO){
        return new OrderItem(null, orderItemDTO.getQuantity(), productRepository.findById(orderItemDTO.getProductId()).orElse(null));
    }
}
