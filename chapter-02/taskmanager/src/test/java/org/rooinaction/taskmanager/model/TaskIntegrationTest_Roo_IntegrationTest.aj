// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package org.rooinaction.taskmanager.model;

import java.lang.Integer;
import java.lang.Long;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.rooinaction.taskmanager.model.TaskDataOnDemand;
import org.rooinaction.taskmanager.repository.TaskRepository;
import org.rooinaction.taskmanager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

privileged aspect TaskIntegrationTest_Roo_IntegrationTest {
    
    declare @type: TaskIntegrationTest: @RunWith(SpringJUnit4ClassRunner.class);
    
    declare @type: TaskIntegrationTest: @ContextConfiguration(locations = "classpath:/META-INF/spring/applicationContext*.xml");
    
    declare @type: TaskIntegrationTest: @Transactional;
    
    @Autowired
    private TaskDataOnDemand TaskIntegrationTest.dod;
    
    @Autowired
    TaskService TaskIntegrationTest.taskService;
    
    @Autowired
    TaskRepository TaskIntegrationTest.taskRepository;
    
    @Test
    public void TaskIntegrationTest.testCountAllTasks() {
        Assert.assertNotNull("Data on demand for 'Task' failed to initialize correctly", dod.getRandomTask());
        long count = taskService.countAllTasks();
        Assert.assertTrue("Counter for 'Task' incorrectly reported there were no entries", count > 0);
    }
    
    @Test
    public void TaskIntegrationTest.testFindTask() {
        Task obj = dod.getRandomTask();
        Assert.assertNotNull("Data on demand for 'Task' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Task' failed to provide an identifier", id);
        obj = taskService.findTask(id);
        Assert.assertNotNull("Find method for 'Task' illegally returned null for id '" + id + "'", obj);
        Assert.assertEquals("Find method for 'Task' returned the incorrect identifier", id, obj.getId());
    }
    
    @Test
    public void TaskIntegrationTest.testFindAllTasks() {
        Assert.assertNotNull("Data on demand for 'Task' failed to initialize correctly", dod.getRandomTask());
        long count = taskService.countAllTasks();
        Assert.assertTrue("Too expensive to perform a find all test for 'Task', as there are " + count + " entries; set the findAllMaximum to exceed this value or set findAll=false on the integration test annotation to disable the test", count < 250);
        List<Task> result = taskService.findAllTasks();
        Assert.assertNotNull("Find all method for 'Task' illegally returned null", result);
        Assert.assertTrue("Find all method for 'Task' failed to return any data", result.size() > 0);
    }
    
    @Test
    public void TaskIntegrationTest.testFindTaskEntries() {
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
    public void TaskIntegrationTest.testFlush() {
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
    public void TaskIntegrationTest.testUpdateTaskUpdate() {
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
    public void TaskIntegrationTest.testSaveTask() {
        Assert.assertNotNull("Data on demand for 'Task' failed to initialize correctly", dod.getRandomTask());
        Task obj = dod.getNewTransientTask(Integer.MAX_VALUE);
        Assert.assertNotNull("Data on demand for 'Task' failed to provide a new transient entity", obj);
        Assert.assertNull("Expected 'Task' identifier to be null", obj.getId());
        taskService.saveTask(obj);
        taskRepository.flush();
        Assert.assertNotNull("Expected 'Task' identifier to no longer be null", obj.getId());
    }
    
    @Test
    public void TaskIntegrationTest.testDeleteTask() {
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
