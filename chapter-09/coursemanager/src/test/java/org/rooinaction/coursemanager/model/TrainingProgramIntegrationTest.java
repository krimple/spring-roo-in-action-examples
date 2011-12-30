package org.rooinaction.coursemanager.model;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.roo.addon.test.RooIntegrationTest;

@RooIntegrationTest(entity = TrainingProgram.class)
public class TrainingProgramIntegrationTest {

    @Test
    public void testMarkerMethod() {
    }
    
    @Test
    public void addProgramAndCourse() {
    	CourseDataOnDemand courseDod = new CourseDataOnDemand(); 
    	Course course = courseDod.getRandomCourse(); 
    	
    	TrainingProgram trainingProgram = new TrainingProgram();
    	course.setTrainingProgram(trainingProgram); 
    	trainingProgram.persist();
    	
    	trainingProgram.getCourses().add(course);    	
    	trainingProgram.flush();
    	
    	TrainingProgram t2 = TrainingProgram.findTrainingProgram(trainingProgram.getId());
    	Assert.assertNotNull(t2.getId());
    	Assert.assertEquals(trainingProgram.getId(), t2.getId());    	
    }
}
