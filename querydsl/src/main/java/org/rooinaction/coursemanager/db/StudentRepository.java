package org.rooinaction.coursemanager.db;

import org.rooinaction.coursemanager.model.Student;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;

@RooJpaRepository(domainType = Student.class)
public interface StudentRepository extends QueryDslPredicateExecutor<Student> {


}
