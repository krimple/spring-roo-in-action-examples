package org.rooinaction.coursemanager.model;

import java.util.List;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.roo.addon.test.RooIntegrationTest;

@RooIntegrationTest(entity = Student.class)
public class StudentIntegrationTest {

  private Offering offering;

  @Before
  public void setupTestData() {
    TrainingProgramDataOnDemand tpDoD = new TrainingProgramDataOnDemand();
    TrainingProgram program = tpDoD.getNewTransientTrainingProgram(0);
    StudentDataOnDemand studentDoD = new StudentDataOnDemand();
    Student student = studentDoD.getNewTransientStudent(0);
    OfferingDataOnDemand offeringDoD = new OfferingDataOnDemand();
    offering = offeringDoD.getNewTransientOffering(0);
    CourseDataOnDemand courseDoD = new CourseDataOnDemand();
    Course course = courseDoD.getNewTransientCourse(0);
    course.addOffering(offering);
    Registration registration = new RegistrationDataOnDemand()
        .getNewTransientRegistration(0);
    offering.addRegistration(registration);
    registration.setStudent(student);
    program.persist();
    course.persist();
    student.persist();
    course.flush();
  }

  @After
  public void tearDown() {
    //offering.getRegistrations().iterator().next().remove();
  }

  @Test
  public void testMarkerMethod() {
  }

  @Test
  public void testfindStudentsNotInOffering() {
    List<Student> students = Student.findStudentsNotInOffering(
        Offering.findAllOfferings().get(0)).getResultList();
    Assert.assertNotNull(students);
  }

  @Test
  public void testFindStudentsInOffering() {
    List<Student> students = Student
        .findStudentsRegisteredForOffering(offering).getResultList();
    Assert.assertNotNull(students);
    Assert.assertEquals(1, students.size());
  }
}
