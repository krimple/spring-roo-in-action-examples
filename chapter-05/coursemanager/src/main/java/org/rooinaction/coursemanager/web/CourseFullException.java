package org.rooinaction.coursemanager.web;

import org.rooinaction.coursemanager.model.Course;
import org.rooinaction.coursemanager.model.Offering;
import org.springframework.dao.DataAccessException;

public class CourseFullException extends DataAccessException {
	
	public CourseFullException(Course course, Offering offering) {
		super("Course " + course + " is full for offering " + offering);
	}
}
