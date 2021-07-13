package br.com.alura.microservice.fornecedor.domain.supplier;

import br.com.alura.microservice.fornecedor.repository.OrderRepository;
import br.com.alura.microservice.fornecedor.repository.SupplierRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class SupplierApplicationServices {

    private final SupplierRepository repository;
    private final OrderRepository orderRepository;

    public Supplier getSupplierByState(String state) {
        log.info("Recebido pedido para o Estado: {} ",state);
        return this.repository.findByState(state).orElse(null);
    }

    @Transactional
    public Order makeOrder(final Long id, final List<OrderItem> items) {
        Supplier supplier = repository.findById(id).orElseThrow(() -> new RuntimeException("Fornecedor não encontrado"));
        log.info("Criando order para Supplier: {} ",supplier.getName());

        if(items == null) {
            return null;
        }
        Order order = new Order(items);
        Order savedOrder = orderRepository.save(order);
        supplier.addOrder(savedOrder);
        repository.save(supplier);
        return savedOrder;
    }

    public Order getOrderById(Long id) {
        return this.orderRepository.findById(id).orElse(null);
    }

}
