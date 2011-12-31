package org.rooinaction.taskmanager.service;


import org.rooinaction.taskmanager.model.Task;
import org.rooinaction.taskmanager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TaskServiceImpl implements TaskService {
    @Autowired
    TaskRepository taskRepository;

    public Task updateTask(Task task) {
        if (task.getCompleted().equals(Boolean.TRUE)) {
          task.setDescription("(completed) " + task.getDescription());
        }
        return taskRepository.save(task);
    }

    public void saveTask(Task task) {
        taskRepository.save(task);
    }

    public List<Task> findTaskEntries(int firstResult, int maxResults) {
        return taskRepository.findAll(new org.springframework.data.domain.PageRequest(firstResult / maxResults, maxResults)).getContent();
    }

    public Task findTask(Long id) {
        return taskRepository.findOne(id);
    }

    public void deleteTask(Task task) {
        taskRepository.delete(task);
    }

    public List<Task> findAllTasks() {
        return taskRepository.findAll();
    }

    public long countAllTasks() {
        return taskRepository.count();
    }
}
