package org.rooina.coursemanager.web;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.serializable.RooSerializable;

@RooSerializable
@RooJavaBean
public class RegisterStudentSearchForm {
	private String searchCriteria;
}
