package org.rooinaction.coursemanager.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.mock.staticmock.MockStaticEntityMethods;

@RunWith(JUnit4.class)
@MockStaticEntityMethods
public class CourseTest {

    @Test
    public void testMethod() {
        CourseDataOnDemand dod = new CourseDataOnDemand();
        Course course = dod.getNewTransientCourse(3);
        int expectedCount = 13;
        Course.countCourses();
        org.springframework.mock.staticmock.AnnotationDrivenStaticEntityMockingControl.expectReturn(expectedCount);
        org.springframework.mock.staticmock.AnnotationDrivenStaticEntityMockingControl.playback();
        org.junit.Assert.assertEquals(expectedCount, Course.countCourses());
    }
}
