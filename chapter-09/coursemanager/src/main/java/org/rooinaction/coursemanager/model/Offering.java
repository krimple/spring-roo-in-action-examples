package org.rooina.coursemanager.model;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;
import org.rooina.coursemanager.model.Course;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.ManyToOne;

@RooJavaBean
@RooToString
@RooEntity(inheritanceType = "SINGLE_TABLE")
@DiscriminatorColumn(name = "course_type", discriminatorType = DiscriminatorType.STRING)
public abstract class Offering {

    @ManyToOne
    private Course course;

    private String location;

    
}
