package org.rooina.coursemanager.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooEntity(inheritanceType = "TABLE_PER_CLASS")
public abstract class Person {
	 
	@Size(min = 1, max = 30)
	private String firstName;
	
	@Size(min = 1, max = 30)
	private String middleNameOrInitial;
	
	@NotNull
	@Size(min = 1, max = 30)
	private String lastName;
	
	@NotNull
	@Size(min = 1, max = 60)
	private String addressLine1;
	
	@Size(min = 1, max = 60)
	private String addressLine2;
	
	@NotNull
	@Size(min = 1, max = 40)
	private String city;
	
	@NotNull
	@Size(min = 2, max = 2)
	private String stateCode;
	
	@NotNull
	@Size(min = 1, max = 10)
	private String postalCode;

	public Long getId() {
        return this.id;
    }

	@Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "id")
    private Long id;

	public void setId(Long id) {
        this.id = id;
    }
}
