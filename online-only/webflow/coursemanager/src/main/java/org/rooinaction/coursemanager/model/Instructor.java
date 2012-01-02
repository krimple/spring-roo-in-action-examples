package org.rooinaction.coursemanager.model;

import org.springframework.roo.addon.entity.RooJpaActiveRecord;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class Instructor extends Person {
	
	@NotNull
	@Size(min = 9, max = 9)
	@Column(name = "tax_number")
	private String taxNumber;		
	
	@NotNull
	private boolean active;
}
