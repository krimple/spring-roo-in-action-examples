package org.rooinaction.coursemanager.model.db;

import org.rooinaction.coursemanager.model.Course;
import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;

@RooJpaRepository(domainType = Course.class)
public interface CourseRepository {
}
