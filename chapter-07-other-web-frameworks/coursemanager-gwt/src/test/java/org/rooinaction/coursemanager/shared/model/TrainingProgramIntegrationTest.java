package org.rooinaction.coursemanager.shared.model;

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
    Course course = courseDod.getNewTransientCourse(0);

    TrainingProgram trainingProgram = new TrainingProgram();
    course.setTrainingProgram(trainingProgram);
    trainingProgram.getCourses().add(course);

    trainingProgram.persist();
    trainingProgram.flush();
    trainingProgram.clear();

    TrainingProgram t2 =
        TrainingProgram.findTrainingProgram(trainingProgram.getId());

    Assert.assertNotNull(t2.getId());
    Assert.assertEquals(trainingProgram.getName(), t2.getName());
    Assert.assertEquals(1, t2.getCourses().size());
  }
}
