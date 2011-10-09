package org.rooinaction.taskmanager.repository;

import org.rooinaction.taskmanager.model.Task;
import org.springframework.roo.addon.layers.repository.jpa.RooRepositoryJpa;

@RooRepositoryJpa(domainType = Task.class)
public interface TaskRepository {
}
