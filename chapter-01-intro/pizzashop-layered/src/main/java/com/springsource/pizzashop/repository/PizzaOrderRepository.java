package com.springsource.pizzashop.repository;

import com.springsource.pizzashop.domain.PizzaOrder;
import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;

@RooJpaRepository(domainType = PizzaOrder.class)
public interface PizzaOrderRepository {
}
