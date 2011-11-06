package org.rooinaction.coursemanager.model;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

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
