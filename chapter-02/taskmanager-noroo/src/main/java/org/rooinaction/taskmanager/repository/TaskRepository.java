package org.rooinaction.taskmanager.repository;

import org.rooinaction.taskmanager.model.Task;
import org.springframework.roo.addon.layers.repository.jpa.RooRepositoryJpa;
import org.springframework.stereotype.Repository;

@Repository
@RooRepositoryJpa(domainType = Task.class)
public interface TaskRepository extends org.springframework.data.jpa.repository.JpaRepository<org.rooinaction.taskmanager.model.Task,java.lang.Long>, org.springframework.data.jpa.repository.JpaSpecificationExecutor<org.rooinaction.taskmanager.model.Task> {
}
