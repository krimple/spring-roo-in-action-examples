package org.rooinaction.coursemanager.web;

import java.util.List;

import org.rooinaction.coursemanager.model.Course;
import org.rooinaction.coursemanager.model.Offering;
import org.springframework.webflow.execution.Event;
import org.springframework.webflow.execution.RequestContext;

public interface RegistrationFlowService {
	
	List<Course> retrieveAllCourses();
	Event retrieveCourseOfferings(RequestContext context);
	Event search(RequestContext context);
	Event removeStudent(RequestContext context);
	Event addStudent(RequestContext context);
	Event completeRegistration(RequestContext context);
	Event findPendingStudents(RequestContext context);
}
