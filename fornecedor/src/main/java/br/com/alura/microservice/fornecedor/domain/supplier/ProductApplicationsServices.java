package br.com.alura.microservice.fornecedor.domain.supplier;

import br.com.alura.microservice.fornecedor.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductApplicationsServices {

	private final ProductRepository productRepository;
	
	public List<Product> getProductByState(String state) {
		return productRepository.findByState(state);
	}


	public List<Product> getAllProducts() {
		return (List<Product>) this.productRepository.findAll();
	}
}
