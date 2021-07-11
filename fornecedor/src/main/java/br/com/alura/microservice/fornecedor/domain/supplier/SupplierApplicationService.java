package br.com.alura.microservice.fornecedor.domain.supplier;

import br.com.alura.microservice.fornecedor.repository.SupplierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SupplierApplicationService {

    private final SupplierRepository repository;

    public Supplier getSupplierByState(String state) {
        return this.repository.findByState(state).orElse(null);
    }
}
