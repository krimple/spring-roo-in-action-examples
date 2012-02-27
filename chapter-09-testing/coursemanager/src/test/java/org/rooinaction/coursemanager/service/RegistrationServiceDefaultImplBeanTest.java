package org.rooinaction.coursemanager.service;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.rooinaction.coursemanager.model.*;
import org.springframework.mock.staticmock.AnnotationDrivenStaticEntityMockingControl;
import org.springframework.mock.staticmock.MockStaticEntityMethods;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RunWith(JUnit4.class)
@MockStaticEntityMethods
public class RegistrationServiceDefaultImplBeanTest {

  StudentDataOnDemand studentDod;
  OfferingDataOnDemand offeringDod;
  CourseDataOnDemand courseDod;

  private RegistrationServiceDefaultImplBean registrationServiceDefaultImplBean;

  @Before
  public void setUp() {
    registrationServiceDefaultImplBean = new RegistrationServiceDefaultImplBean();
    studentDod = new StudentDataOnDemand();
    offeringDod = new OfferingDataOnDemand();
    courseDod = new CourseDataOnDemand();
  }

  @Test
  public void testRegisterStudents() {
    Offering offering = offeringDod.getNewTransientOffering(1);
    offering.setId(1L);

    Offering.findOffering(1L);
    AnnotationDrivenStaticEntityMockingControl.expectReturn(offering);
    List<Long> ids = new ArrayList<Long>();
    List<Student> testStudents = new ArrayList<Student>();

    // record expectations
    for (int id = 0; id < 10; id++) {
      Student.findStudent((long)id);
      Student student = studentDod.getNewTransientStudent(id);
      student.setId(Long.valueOf(id));
      ids.add(Long.valueOf(id));
      AnnotationDrivenStaticEntityMockingControl.expectReturn(student);
    }

    AnnotationDrivenStaticEntityMockingControl.playback();

    registrationServiceDefaultImplBean.completeRegistration(offering.getId(), ids);
    Set<Registration> registrations = offering.getRegistrations();
    Assert.assertEquals(10, registrations.size());

  }
}
