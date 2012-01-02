package org.rooinaction.coursemanager.model;

import org.springframework.roo.addon.entity.RooJpaActiveRecord;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.serializable.RooSerializable;
import org.springframework.roo.addon.tostring.RooToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@RooJavaBean
@RooToString
@RooSerializable
@RooJpaActiveRecord(inheritanceType = "TABLE_PER_CLASS")
public abstract class Person {

    @Size(min = 1, max = 30)
    @Column(name = "first_name")
    private String firstName;

    @Size(min = 1, max = 30)
    @Column(name = "middle_name_or_initial")
    private String middleNameOrInitial;

    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "last_name")
    private String lastName;

    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "address_line1")
    private String addressLine1;

    @Size(min = 1, max = 60)
    @Column(name = "address_line2")
    private String addressLine2;

    @NotNull
    @Size(min = 1, max = 40)
    private String city;

    @NotNull
    @Size(min = 2, max = 2)
    @Column(name = "state_code")
    private String stateCode;

    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "postal_code")
    private String postalCode;

    public Long getId() {
        return this.id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Size(max = 80)
    @Column(name = "email_address")
    private java.lang.String emailAddress;

    public void setId(Long id) {
        this.id = id;
    }
    
    @Transient
    public String getFullName() {
    	StringBuffer sbName = 
    		new StringBuffer();
    	sbName.append(lastName);
    	if (firstName != null && firstName.length() > 0) {
    		sbName.append(", ");
    		sbName.append(firstName);
    	}
    	if (middleNameOrInitial != null && middleNameOrInitial.length() > 0) {
    		if (firstName == null || firstName.length() > 0) sbName.append(",");
    			sbName.append(" ");
    			sbName.append(middleNameOrInitial);
    	} 
    	return sbName.toString();
    }
}
