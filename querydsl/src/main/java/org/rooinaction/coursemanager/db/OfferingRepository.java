package org.rooinaction.coursemanager.db;

import org.rooinaction.coursemanager.model.Offering;
import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;

@RooJpaRepository(domainType = Offering.class)
public interface OfferingRepository {
}
