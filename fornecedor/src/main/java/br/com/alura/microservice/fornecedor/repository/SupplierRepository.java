package br.com.alura.microservice.fornecedor.repository;

import br.com.alura.microservice.fornecedor.domain.supplier.Supplier;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface SupplierRepository extends CrudRepository<Supplier, Long> {
    Optional<Supplier> findByState(final String state);
}
