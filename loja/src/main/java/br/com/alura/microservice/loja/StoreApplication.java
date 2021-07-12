package br.com.alura.microservice.loja;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class StoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(StoreApplication.class, args);
	}

}
