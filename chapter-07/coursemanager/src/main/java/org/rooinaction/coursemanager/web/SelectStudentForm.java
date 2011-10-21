package org.rooinaction.coursemanager.web;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.serializable.RooSerializable;
import org.springframework.roo.addon.tostring.RooToString;

@RooSerializable
@RooJavaBean
@RooToString
public class SelectStudentForm {
	private Long studentId;
}
