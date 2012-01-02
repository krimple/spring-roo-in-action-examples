package org.rooinaction.coursemanager.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.serializable.RooSerializable;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
@RooSerializable
public class Tag {

    @NotNull
    @Size(min = 1, max = 25)
    private String tag;

    @NotNull
    @Size(max = 250)
    private String description;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "tag_associations", 
    		joinColumns = { @JoinColumn(name="tag_id")} , 
    		inverseJoinColumns = { @JoinColumn(name="course_id")})
    private Set<Course> courses = new HashSet<Course>();      
    public void addCourse(Course c) {
    	this.getCourses().add(c);
    	c.getTags().add(this);    	    		
    }
}
