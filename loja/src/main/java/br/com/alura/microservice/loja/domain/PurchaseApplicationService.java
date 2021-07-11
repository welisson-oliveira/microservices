package br.com.alura.microservice.loja.domain;

import br.com.alura.microservice.loja.controller.dto.InfoSupplierDTO;
import br.com.alura.microservice.loja.controller.dto.PurchaseDTO;
import br.com.alura.microservice.loja.domain.Purchase;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class PurchaseApplicationService {

    private final RestTemplate restTemplate;

    @Value("${supplier-url}")
    private String url;

    public void makePurchase(Purchase purchase) {
        ResponseEntity<InfoSupplierDTO> exchange = restTemplate.exchange(url+"/supplier/"+purchase.getState(), HttpMethod.GET, null, InfoSupplierDTO.class);
        System.out.println(exchange.getBody().getAddress());
    }
}
