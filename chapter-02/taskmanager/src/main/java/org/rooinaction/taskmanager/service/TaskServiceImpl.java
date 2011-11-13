package org.rooinaction.taskmanager.service;


import org.rooinaction.taskmanager.model.Task;

public class TaskServiceImpl implements TaskService {
    public Task updateTask(Task task) {
        if (task.getCompleted().equals(Boolean.TRUE)) {
          task.setTask("(completed) " + task.getTask());
        }
        return taskRepository.save(task);
    }
}
