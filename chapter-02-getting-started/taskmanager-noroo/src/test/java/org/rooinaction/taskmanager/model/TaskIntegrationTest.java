package org.rooinaction.taskmanager.model;

import org.junit.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.rooinaction.taskmanager.repository.TaskRepository;
import org.rooinaction.taskmanager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Configurable
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/META-INF/spring/applicationContext*.xml")
@Transactional
public class TaskIntegrationTest {

    @Autowired
    private TaskDataOnDemand dod;

    @Autowired
    TaskService taskService;

    @Autowired
    TaskRepository taskRepository;

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

    @Test
    public void testCountAllTasks() {
        Assert.assertNotNull("Data on demand for 'Task' failed to initialize correctly", dod.getRandomTask());
        long count = taskService.countAllTasks();
        Assert.assertTrue("Counter for 'Task' incorrectly reported there were no entries", count > 0);
    }
    
    @Test
    public void testFindTask() {
        Task obj = dod.getRandomTask();
        Assert.assertNotNull("Data on demand for 'Task' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Task' failed to provide an identifier", id);
        obj = taskService.findTask(id);
        Assert.assertNotNull("Find method for 'Task' illegally returned null for id '" + id + "'", obj);
        Assert.assertEquals("Find method for 'Task' returned the incorrect identifier", id, obj.getId());
    }
    
    @Test
    public void testFindAllTasks() {
        Assert.assertNotNull("Data on demand for 'Task' failed to initialize correctly", dod.getRandomTask());
        long count = taskService.countAllTasks();
        Assert.assertTrue("Too expensive to perform a find all test for 'Task', as there are " + count + " entries; set the findAllMaximum to exceed this value or set findAll=false on the integration test annotation to disable the test", count < 250);
        List<Task> result = taskService.findAllTasks();
        Assert.assertNotNull("Find all method for 'Task' illegally returned null", result);
        Assert.assertTrue("Find all method for 'Task' failed to return any data", result.size() > 0);
    }
    
    @Test
    public void testFindTaskEntries() {
        Assert.assertNotNull("Data on demand for 'Task' failed to initialize correctly", dod.getRandomTask());
        long count = taskService.countAllTasks();
        if (count > 20) count = 20;
        int firstResult = 0;
        int maxResults = (int) count;
        List<Task> result = taskService.findTaskEntries(firstResult, maxResults);
        Assert.assertNotNull("Find entries method for 'Task' illegally returned null", result);
        Assert.assertEquals("Find entries method for 'Task' returned an incorrect number of entries", count, result.size());
    }
    
    @Test
    public void testFlush() {
        Task obj = dod.getRandomTask();
        Assert.assertNotNull("Data on demand for 'Task' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Task' failed to provide an identifier", id);
        obj = taskService.findTask(id);
        Assert.assertNotNull("Find method for 'Task' illegally returned null for id '" + id + "'", obj);
        boolean modified =  dod.modifyTask(obj);
        Integer currentVersion = obj.getVersion();
        taskRepository.flush();
        Assert.assertTrue("Version for 'Task' failed to increment on flush directive", (currentVersion != null && obj.getVersion() > currentVersion) || !modified);
    }
    
    @Test
    public void testUpdateTaskUpdate() {
        Task obj = dod.getRandomTask();
        Assert.assertNotNull("Data on demand for 'Task' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Task' failed to provide an identifier", id);
        obj = taskService.findTask(id);
        boolean modified =  dod.modifyTask(obj);
        Integer currentVersion = obj.getVersion();
        Task merged = taskService.updateTask(obj);
        taskRepository.flush();
        Assert.assertEquals("Identifier of merged object not the same as identifier of original object", merged.getId(), id);
        Assert.assertTrue("Version for 'Task' failed to increment on merge and flush directive", (currentVersion != null && obj.getVersion() > currentVersion) || !modified);
    }
    
    @Test
    public void testSaveTask() {
        Assert.assertNotNull("Data on demand for 'Task' failed to initialize correctly", dod.getRandomTask());
        Task obj = dod.getNewTransientTask(Integer.MAX_VALUE);
        Assert.assertNotNull("Data on demand for 'Task' failed to provide a new transient entity", obj);
        Assert.assertNull("Expected 'Task' identifier to be null", obj.getId());
        taskService.saveTask(obj);
        taskRepository.flush();
        Assert.assertNotNull("Expected 'Task' identifier to no longer be null", obj.getId());
    }
    
    @Test
    public void testDeleteTask() {
        Task obj = dod.getRandomTask();
        Assert.assertNotNull("Data on demand for 'Task' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Task' failed to provide an identifier", id);
        obj = taskService.findTask(id);
        taskService.deleteTask(obj);
        taskRepository.flush();
        Assert.assertNull("Failed to remove 'Task' with identifier '" + id + "'", taskService.findTask(id));
    }
    

}
