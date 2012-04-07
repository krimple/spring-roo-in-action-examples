package org.rooinaction.coursemanager.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.groups.Default;

import org.junit.Before;
import org.junit.Test;
import org.rooinaction.coursemanager.model.*;
import org.springframework.mock.staticmock.AnnotationDrivenStaticEntityMockingControl;
import org.springframework.mock.staticmock.MockStaticEntityMethods;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import static org.mockito.Mockito.*;


@MockStaticEntityMethods
public class RegistrationServiceBeanImplTest {

  private RegistrationServiceBeanImpl registrationServiceBeanImpl;
  StudentDataOnDemand studentDod;
  OfferingDataOnDemand offeringDod;
  CourseDataOnDemand courseDod;
  TrainingProgramDataOnDemand trainingProgramDod;

  @Before
  public void setup() {
    registrationServiceBeanImpl = new RegistrationServiceBeanImpl();
    studentDod = new StudentDataOnDemand();
    offeringDod = new OfferingDataOnDemand();
    courseDod = new CourseDataOnDemand();
    courseDod.setTrainingProgramDataOnDemand(trainingProgramDod);
  }

  @Test
  public void pointlessTest() {
    RegistrationService service = mock(RegistrationService.class);
    List<Long> ids = new ArrayList();
    ids.add(1l);
    ids.add(2l);
    service.registerStudents(1l, ids);
  }


  @Test
  public void testRegisterStudents() {
    Offering.findOffering(1L);
    Offering offering = offeringDod.getNewTransientOfferingWithNullCourse(0);
    AnnotationDrivenStaticEntityMockingControl.expectReturn(offering);

    List<Long> ids = new ArrayList<Long>();
    List<Student> testStudents = new ArrayList<Student>();

    for (int id = 0; id < 10; id++) {
      ids.add(Long.valueOf(id));
      Student.findStudent((long) id);
      Student student = studentDod.getNewTransientStudent(id);
      testStudents.add(student);
      AnnotationDrivenStaticEntityMockingControl.expectReturn(student);
    }

    AnnotationDrivenStaticEntityMockingControl.playback();

    registrationServiceBeanImpl.registerStudents(1L, ids);

    // now, assert all are the same entries
    Set<Registration> registrations = offering.getRegistrations();
    assertEquals(10, registrations.size());


    Iterator<Registration> itRegistrations = registrations.iterator();
    while (itRegistrations.hasNext()) {
      Registration registration = itRegistrations.next();
      assertTrue(testStudents.contains(registration.getStudent()));
    }
  }

  /**
   * Currently does not execute so is disabled. This is because the Course has a related Training Program, which
   * is generated via an injected TrainingProgramDataOnDemand class. However, since this is a unit
   * test, not an integration test, the autowiring does not fire.
   *
   * This is a case where you could use something like Mockito or EasyMock to mock the
   * TrainingProgramDataOnDemand; however, you need to push-in refactor the setter and
   * member variable in the CourseDataOnDemand (which I've done) and then set the mock.
   *
   * Points and credit on this source code to the person who gets this working, we
   * ran out of time before production.
   */
  //@Test
  public void testRegisterStudentWhenMaxCapacityReached() {

    Offering offering = offeringDod.getNewTransientOfferingWithNullCourse(0);
    Course course = courseDod.getNewTransientCourse(0);
    offering.setCourse(course);

    Registration registration = new Registration();
    registration.setStudent(studentDod.getNewTransientStudent(0));
    Student newTransientStudent1 = studentDod.getNewTransientStudent(0);
    newTransientStudent1.setId(1l);

    offering.getCourse().setMaximumCapacity(1);
    offering.addRegistration(registration);

    Offering.findOffering(1l);
    // this is what needs mocking - see the code fragment in
    // TrainingProgram.init() - TrainingProgram.findTrainingProgramEntries(0, 10);

    AnnotationDrivenStaticEntityMockingControl.expectReturn(offering);

    Student newTransientStudent2 = studentDod.getNewTransientStudent(1);
    Student.findStudent(2l);

    AnnotationDrivenStaticEntityMockingControl.expectReturn(newTransientStudent2);

    AnnotationDrivenStaticEntityMockingControl.playback();

    List<Long> ids = new ArrayList<Long>();
    ids.add(2l);

    registrationServiceBeanImpl.registerStudents(1L, ids);

    LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
    validator.afterPropertiesSet();
    Set<ConstraintViolation<Offering>> violations = validator.validate(offering, Default.class);
    assertTrue(violations.size() == 1);
    assertEquals("course.full.exception", violations.iterator().next().getMessageTemplate());


  }


}
