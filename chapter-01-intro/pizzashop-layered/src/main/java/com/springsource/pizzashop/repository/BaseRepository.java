package com.springsource.pizzashop.repository;

import com.springsource.pizzashop.domain.Base;
import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;

@RooJpaRepository(domainType = Base.class)
public interface BaseRepository {
}
