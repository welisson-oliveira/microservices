package br.com.alura.microservice.fornecedor.domain.supplier;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Table(name = "order_table")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Integer preparationTime;
	
	@Enumerated(EnumType.STRING)
	private OrderState status;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "order_id")
	private List<OrderItem> items;
	
	public Order(final List<OrderItem> items) {
		this.items = items;
		this.status = OrderState.RECEIVED;
		this.preparationTime = items.size();
	}
	
}
