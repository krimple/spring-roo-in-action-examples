package org.rooinaction.coursemanager.service;


import java.util.List;

public interface RegistrationService {
  void completeRegistration(Long offeringId, List<Long> studentIds);
}
