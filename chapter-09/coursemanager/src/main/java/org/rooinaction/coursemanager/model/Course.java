package org.rooinaction.coursemanager.model;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@RooJavaBean
@RooToString
@RooJpaActiveRecord(finders = { "findCoursesByNameLike" })
public class Course {

    @NotNull
    @Column(name = "course_name")
    @Size(min = 1, max = 60)
    private String name;

    @NotNull
    @Size(max = 1000)
    private String description;

    @NotNull
    @Column(name = "max_capacity")
    @Min(1L)
    @Max(9999L)
    private Integer maxiumumCapacity;

    @NotNull
    @Enumerated(EnumType.STRING)
    private CourseTypeEnum courseType;

    @ManyToOne
    private TrainingProgram trainingProgram;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "courses")
    private Set<Tag> tags = new HashSet<Tag>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "course")
    private Set<Offering> offerings = new HashSet<Offering>();

	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(style = "S-")
	private Date createdDate; 
}
