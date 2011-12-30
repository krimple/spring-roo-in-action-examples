package org.rooina.coursemanager.model;

import javax.persistence.ManyToOne;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooEntity
public class Registration {
	
	@ManyToOne
	private Student student;
	
	@ManyToOne
	private Course course;
	
	private boolean paymentMade;
	
	private boolean attended;
	
}
