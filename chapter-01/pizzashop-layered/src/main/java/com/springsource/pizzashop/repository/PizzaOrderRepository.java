package com.springsource.pizzashop.repository;

import com.springsource.pizzashop.domain.PizzaOrder;
import org.springframework.roo.addon.layers.repository.jpa.RooRepositoryJpa;

@RooRepositoryJpa(domainType = PizzaOrder.class)
public interface PizzaOrderRepository {
}
