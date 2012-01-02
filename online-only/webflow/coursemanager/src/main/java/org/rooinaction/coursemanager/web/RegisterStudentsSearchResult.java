package org.rooinaction.coursemanager.web;

import org.rooinaction.coursemanager.model.Student;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.serializable.RooSerializable;

@RooJavaBean
@RooSerializable
public class RegisterStudentsSearchResult {
	
	public RegisterStudentsSearchResult(Student student, boolean exists) {
		this.student = student;
		this.existsInRegistry = exists;
	}
	
	private Student student;	
	private boolean existsInRegistry;
	 
}
