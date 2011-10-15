package org.rooina.coursemanager.service;

import java.util.Iterator;
import java.util.List;

import org.rooina.coursemanager.model.Offering;
import org.rooina.coursemanager.model.Registration;
import org.rooina.coursemanager.model.Student;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegistrationServiceBeanImpl implements RegistrationService {
	
	@Transactional
	public void registerStudents(Long offeringId, List<Long> studentIds) {
		Offering offering = Offering.findOffering(offeringId);
		Iterator<Long> studentIterator = studentIds.iterator();
		while (studentIterator.hasNext()) {
			Long studentId = studentIterator.next();
			Student student = Student.findStudent(studentId);

			Registration registration = new Registration();
			registration.setOffering(offering);
			registration.setStudent(student);
			registration.setPaymentMade(false);
			registration.setAttended(false);
			offering.addRegistration(registration);
		}		
	}	
}
