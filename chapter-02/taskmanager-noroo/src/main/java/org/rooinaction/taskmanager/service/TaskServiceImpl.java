package org.rooinaction.taskmanager.service;

import java.util.List;
import org.rooinaction.taskmanager.model.Task;
import org.rooinaction.taskmanager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class TaskServiceImpl implements TaskService {

	public Task updateTask(Task task) {
		if (task.getCompleted().equals(Boolean.TRUE)) {
			task.setTask("(completed) " + task.getTask());
		}
        return taskRepository.save(task);
    }		

	@Autowired
    TaskRepository taskRepository;

	public long countAllTasks() {
        return taskRepository.count();
    }

	public void deleteTask(Task task) {
        taskRepository.delete(task);
    }

	public Task findTask(Long id) {
        return taskRepository.findOne(id);
    }

	public List<Task> findAllTasks() {
        return taskRepository.findAll();
    }

	public List<Task> findTaskEntries(int firstResult, int maxResults) {
        return taskRepository.findAll(new org.springframework.data.domain.PageRequest(firstResult / maxResults, maxResults)).getContent();
    }

	public void saveTask(Task task) {
        taskRepository.save(task);
    }
}
