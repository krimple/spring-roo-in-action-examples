package org.rooinaction.taskmanager.model;

import org.junit.Test;
import org.junit.Assert;
import org.springframework.roo.addon.test.RooIntegrationTest;

@RooIntegrationTest(entity = Task.class)
public class TaskIntegrationTest {

    @Test
    public void testMarkerMethod() {
    }

    @Test
      public void testModifyTaskWhenCompletingFromRepo() {
        Task t = new Task();
        t.setDescription("Click on button");
        taskService.saveTask(t);
        taskRepository.flush();
        t.setCompleted(true);
        taskService.updateTask(t);
        taskRepository.flush();
        Task t2 = taskRepository.findOne(t.getId());
    
        Assert.assertTrue("Task text does not start with (completed).", 
            t2.getDescription().startsWith("(completed)"));
      }
}
