package org.rooinaction.taskmanager.model;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.roo.addon.test.RooIntegrationTest;

@RooIntegrationTest(entity = Task.class)
public class TaskIntegrationTest {
	
    @Test
    public void testMarkerMethod() {
    }
    
    @Test
    public void testModifyTaskWhenCompletingFromRepo() {
    	Task t = new Task();
    	t.setTask("Click on button");
    	taskService.saveTask(t);
    	taskRepository.flush();
    	t.setCompleted(true);
    	taskService.updateTask(t);
    	taskRepository.flush();
    	Task t2 = taskRepository.findOne(t.getId());
    	
    	Assert.assertTrue("Task text does not start with (completed).", 
    			t2.getTask().startsWith("(completed)"));
    }    
    
}
