package org.foo.bar.services.persistence;

import org.foo.bar.services.db.Course;
import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;

@RooJpaRepository(domainType = Course.class)
public interface CourseRepository {
}
