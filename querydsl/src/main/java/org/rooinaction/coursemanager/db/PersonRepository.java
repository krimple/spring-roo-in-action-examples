package org.rooinaction.coursemanager.db;

import org.rooinaction.coursemanager.model.Person;
import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;

@RooJpaRepository(domainType = Person.class)
public interface PersonRepository {
}
