package br.com.alura.microservice.transportador.domain;

import br.com.alura.microservice.transportador.controller.dto.DeliveryDTO;
import br.com.alura.microservice.transportador.controller.dto.VoucherDTO;
import br.com.alura.microservice.transportador.repository.DeliveryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeliveryApplicationServices {

    private final DeliveryRepository repository;

    public VoucherDTO bookDelivery(DeliveryDTO deliveryDTO) {
        final Delivery delivery = new Delivery(deliveryDTO.getDeliveryDate(), deliveryDTO.getDeliveryDate().plusDays(1L), deliveryDTO.getDestinyAddress(),deliveryDTO.getOriginAddress(), deliveryDTO.getOrderId());
        repository.save(delivery);

        return new VoucherDTO(delivery.getId(), delivery.getDeliveryForecast());
    }

}
