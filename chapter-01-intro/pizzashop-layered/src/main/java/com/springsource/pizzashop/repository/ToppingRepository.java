package com.springsource.pizzashop.repository;

import com.springsource.pizzashop.domain.Topping;
import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;

@RooJpaRepository(domainType = Topping.class)
public interface ToppingRepository {
}
