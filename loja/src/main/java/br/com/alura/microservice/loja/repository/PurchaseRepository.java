package br.com.alura.microservice.loja.repository;

import br.com.alura.microservice.loja.domain.purchase.Purchase;
import org.springframework.data.repository.CrudRepository;

public interface PurchaseRepository extends CrudRepository<Purchase, Long> {
}
