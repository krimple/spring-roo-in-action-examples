package com.springsource.pizzashop.repository;

import com.springsource.pizzashop.domain.Pizza;
import org.springframework.roo.addon.layers.repository.jpa.RooRepositoryJpa;

@RooRepositoryJpa(domainType = Pizza.class)
public interface PizzaRepository {
}
