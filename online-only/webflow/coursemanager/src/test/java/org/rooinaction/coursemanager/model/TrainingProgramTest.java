package org.rooinaction.coursemanager.model;

import static junit.framework.Assert.*;

import org.junit.Test;
import org.springframework.mock.staticmock.AnnotationDrivenStaticEntityMockingControl;
import org.springframework.mock.staticmock.MockStaticEntityMethods;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

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
    	TrainingProgram program = mock(TrainingProgram.class);    	    	
    }
}
