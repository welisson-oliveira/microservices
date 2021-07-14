package br.com.alura.microservice.loja.infrasctructure.feign;

import br.com.alura.microservice.loja.controller.dto.DeliveryDTO;
import br.com.alura.microservice.loja.controller.dto.VoucherDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("transportador")
public interface TransporterClient {

    @PostMapping("/delivery")
    VoucherDTO bookingDelivery(final DeliveryDTO deliveryDTO);
}
