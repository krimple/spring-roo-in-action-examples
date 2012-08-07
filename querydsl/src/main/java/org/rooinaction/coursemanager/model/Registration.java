package org.rooinaction.coursemanager.model;

import javax.persistence.ManyToOne;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class Registration {

    @ManyToOne
    private Student student;

    @ManyToOne
    private Course course;

    private Boolean paymentMade;

    private Boolean attended;
}
