package br.com.alura.microservice.fornecedor.repository;

import br.com.alura.microservice.fornecedor.domain.supplier.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long>{

}
