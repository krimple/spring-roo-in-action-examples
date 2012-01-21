package org.rooinaction.taskmanager.service;

import org.rooinaction.taskmanager.model.Task;

import java.util.List;

public interface TaskService {
    public abstract long countAllTasks();
        public abstract void deleteTask(Task task);
        public abstract Task findTask(java.lang.Long id);
        public abstract List<Task> findAllTasks();
        public abstract List<Task> findTaskEntries(int firstResult, int maxResults);
        public abstract void saveTask(Task task);
        public abstract Task updateTask(Task task);
}
