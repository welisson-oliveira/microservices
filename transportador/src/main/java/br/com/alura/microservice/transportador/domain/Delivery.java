package br.com.alura.microservice.transportador.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long orderId;
    private LocalDate deliveryDate;
    private LocalDate deliveryForecast;
    private String originAddress;
    private String destinyAddress;

    public Delivery(final LocalDate deliveryDate, final LocalDate deliveryForecast, final String originAddress, final String destinyAddress, final Long orderId) {
        this.deliveryDate = deliveryDate;
        this.deliveryForecast = deliveryForecast;
        this.originAddress = originAddress;
        this.destinyAddress = destinyAddress;
        this.orderId = orderId;
    }
}
