package org.rooinaction.taskmanager.model;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.rooinaction.taskmanager.repository.TaskRepository;
import org.rooinaction.taskmanager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.roo.addon.dod.RooDataOnDemand;
import org.springframework.stereotype.Component;

@Configurable
@Component
@RooDataOnDemand(entity = Task.class)
public class TaskDataOnDemand {

	private Random rnd = new SecureRandom();

	private List<Task> data;

	@Autowired
    TaskService taskService;

	@Autowired
    TaskRepository taskRepository;

	public Task getNewTransientTask(int index) {
        Task obj = new Task();
        setCompleted(obj, index);
        setTask(obj, index);
        return obj;
    }

	public void setCompleted(Task obj, int index) {
        Boolean completed = Boolean.TRUE;
        obj.setCompleted(completed);
    }

	public void setTask(Task obj, int index) {
        String task = "task_" + index;
        if (task.length() > 40) {
            task = task.substring(0, 40);
        }
        obj.setTask(task);
    }

	public Task getSpecificTask(int index) {
        init();
        if (index < 0) index = 0;
        if (index > (data.size() - 1)) index = data.size() - 1;
        Task obj = data.get(index);
        java.lang.Long id = obj.getId();
        return taskService.findTask(id);
    }

	public Task getRandomTask() {
        init();
        Task obj = data.get(rnd.nextInt(data.size()));
        java.lang.Long id = obj.getId();
        return taskService.findTask(id);
    }

	public boolean modifyTask(Task obj) {
        return false;
    }

	public void init() {
        int from = 0;
        int to = 10;
        data = taskService.findTaskEntries(from, to);
        if (data == null) throw new IllegalStateException("Find entries implementation for 'Task' illegally returned null");
        if (!data.isEmpty()) {
            return;
        }
        
        data = new ArrayList<org.rooinaction.taskmanager.model.Task>();
        for (int i = 0; i < 10; i++) {
            Task obj = getNewTransientTask(i);
            try {
                taskService.saveTask(obj);
            } catch (ConstraintViolationException e) {
                StringBuilder msg = new StringBuilder();
                for (Iterator<ConstraintViolation<?>> it = e.getConstraintViolations().iterator(); it.hasNext();) {
                    ConstraintViolation<?> cv = it.next();
                    msg.append("[").append(cv.getConstraintDescriptor()).append(":").append(cv.getMessage()).append("=").append(cv.getInvalidValue()).append("]");
                }
                throw new RuntimeException(msg.toString(), e);
            }
            taskRepository.flush();
            data.add(obj);
        }
    }
}
