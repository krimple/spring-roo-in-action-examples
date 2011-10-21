package org.rooinaction.coursemanager.model;

import org.springframework.roo.addon.entity.RooJpaActiveRecord;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.serializable.RooSerializable;
import org.springframework.roo.addon.tostring.RooToString;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@RooJavaBean
@RooToString
@RooSerializable
@RooJpaActiveRecord(finders = { "findCoursesByNameLike" })
public class Course {

    @NotNull
    @Size(min = 1, max = 60)
    private String name;

    @NotNull
    @Size(max = 1000)
    private String description;

    @NotNull
    @DecimalMin("0.0")
    @DecimalMax("99999.00") //see JIRA ROO-2027
    @Digits(integer = 10, fraction = 2) // upped from 5,2 
    private BigDecimal cost;
    
    @NotNull
    @Column(name = "max_capacity")
    @Min(1L)
    @Max(9999L)
    private java.lang.Integer maxiumumCapacity;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "course_type")
    private CourseTypeEnum courseType;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="training_program")
    private TrainingProgram trainingProgram;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "courses")
    @Column(name="tag_id")
    private Set<Tag> tags = new HashSet<Tag>();

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)    
    private Set<Offering> offerings = new HashSet<Offering>();
    
    public void addTag(Tag tag) {
    	tag.addCourse(this);    	
    }
    
    public void addOffering(Offering offering) {
    	offering.setCourse(this);
    	this.offerings.add(offering);
    }
    
    @Override
    public String toString() {
        return getName();
    }
}
