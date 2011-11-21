package org.rooinaction.coursemanager.model;

import static junit.framework.Assert.assertEquals;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.mock.staticmock.AnnotationDrivenStaticEntityMockingControl;
import org.springframework.mock.staticmock.MockStaticEntityMethods;

@MockStaticEntityMethods
public class TrainingProgramTest {

    @Test
    public void testMethod() {
        int expectedCount = 13;
        TrainingProgram.countTrainingPrograms();
        AnnotationDrivenStaticEntityMockingControl.expectReturn(expectedCount);
        AnnotationDrivenStaticEntityMockingControl.playback();
        assertEquals(expectedCount, TrainingProgram.countTrainingPrograms());
    }
    
    @Test
    public void testSomethingElse() {
    	TrainingProgram program = Mockito.mock(TrainingProgram.class);    	    	
    }
}
