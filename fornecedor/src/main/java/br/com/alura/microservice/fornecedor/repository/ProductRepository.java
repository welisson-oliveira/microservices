package br.com.alura.microservice.fornecedor.repository;

import br.com.alura.microservice.fornecedor.domain.supplier.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long>{

	List<Product> findByState(String state);
	
	List<Product> findByIdIn(List<Long> ids);
}
