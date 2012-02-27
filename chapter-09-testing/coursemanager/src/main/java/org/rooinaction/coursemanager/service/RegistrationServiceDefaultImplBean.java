package org.rooinaction.coursemanager.service;


import org.rooinaction.coursemanager.model.Offering;
import org.rooinaction.coursemanager.model.Registration;
import org.rooinaction.coursemanager.model.Student;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class RegistrationServiceDefaultImplBean implements RegistrationService {
  @Override
  @Transactional
  public void completeRegistration(Long offeringId, List<Long> studentIds) {
    Offering offering = Offering.findOffering(offeringId);
    for (Long studentId : studentIds) {
      Student student = Student.findStudent(studentId);
      Registration registration = new Registration();
      registration.setStudent(student);
      registration.setOffering(offering);
      registration.setAttended(false);
      registration.setPaymentMade(false);
      offering.addRegistration(registration);
    }
  }

}
