package org.rooinaction.coursemanager.db;

import org.rooinaction.coursemanager.model.TrainingProgram;
import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;

@RooJpaRepository(domainType = TrainingProgram.class)
public interface TrainingProgramRepository {
}
