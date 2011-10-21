package org.rooina.coursemanager.model;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooEntity
@DiscriminatorValue("ONESHOT")
public class SingleEvent extends Offering {	
	
	 @Temporal(TemporalType.TIMESTAMP)
	    @DateTimeFormat(pattern = "MM/dd/yyyy")
	    private Date runDate;
}
