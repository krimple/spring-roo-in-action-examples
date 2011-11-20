package org.foo.bar.db;

import org.foo.bar.model.Course;
import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;

@RooJpaRepository(domainType = Course.class)
public interface CourseRepository {
}
