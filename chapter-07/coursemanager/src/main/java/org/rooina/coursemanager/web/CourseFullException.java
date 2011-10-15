package org.rooina.coursemanager.web;

import org.rooina.coursemanager.model.Course;
import org.rooina.coursemanager.model.Offering;
import org.springframework.dao.DataAccessException;

public class CourseFullException extends DataAccessException {
	
	public CourseFullException(Course course, Offering offering) {
		super("Course " + course + " is full for offering " + offering);
	}
}
