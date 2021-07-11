package br.com.alura.microservice.fornecedor.controller;

import br.com.alura.microservice.fornecedor.domain.supplier.Supplier;
import br.com.alura.microservice.fornecedor.domain.supplier.SupplierApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/supplier")
@RequiredArgsConstructor
public class SupplierController {

    private final SupplierApplicationService infoApplicationService;

    @GetMapping("/{state}")
    public Supplier getSupplierByState(@PathVariable final String state){
        return infoApplicationService.getSupplierByState(state);
    }
}
