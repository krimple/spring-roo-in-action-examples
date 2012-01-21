package org.rooinaction.coursemanager.model;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class Student extends Person {
		
	@NotNull
	@Size(min = 1, max = 30)
	private String emergencyContactName;
	
	@NotNull
	@Size(min = 1, max = 80)
	private String emergencyContactInfo;
	
	@Size(max = 30)
	private String dietaryRestrictions;
	
}
