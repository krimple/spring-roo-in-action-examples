package org.rooina.coursemanager.web;

import java.util.ArrayList;
import java.util.List;

import org.rooina.coursemanager.model.Student;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.serializable.RooSerializable;

@RooSerializable
@RooJavaBean
public class RegisterStudentsForm {
	
	private Long courseId;
	private Long offeringId;
	private String currentSearch;
	private List<Long> studentsToRegister = new ArrayList<Long>();
	
	public void addStudent(Long id) {
		if (!studentsToRegister.contains(id)) studentsToRegister.add(id);
	}
	
}
