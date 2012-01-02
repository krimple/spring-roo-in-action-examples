package org.rooinaction.coursemanager.service;

import java.util.List;


public interface RegistrationService {
	void registerStudents(Long offeringId, List<Long> studentIds);
}
