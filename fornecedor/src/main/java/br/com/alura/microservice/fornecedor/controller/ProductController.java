package br.com.alura.microservice.fornecedor.controller;

import br.com.alura.microservice.fornecedor.domain.supplier.Product;
import br.com.alura.microservice.fornecedor.domain.supplier.ProductApplicationsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductApplicationsServices productApplicationsServices;
	
	@GetMapping("/{estado}")
	public List<Product> getProductByState(@PathVariable("estado") String estado) {
		return productApplicationsServices.getProductByState(estado);
	}

	@GetMapping
	public List<Product> getProductByState() {
		return productApplicationsServices.getAllProducts();
	}
}
