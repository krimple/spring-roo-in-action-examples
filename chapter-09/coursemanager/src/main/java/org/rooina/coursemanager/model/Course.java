package org.rooina.coursemanager.model;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;
import org.rooina.coursemanager.model.CourseTypeEnum;
import javax.validation.constraints.NotNull;
import javax.persistence.Column;
import javax.persistence.Enumerated;
import javax.persistence.EnumType;
import javax.validation.constraints.Size;
import javax.validation.constraints.Min;
import javax.validation.constraints.Max;
import org.rooina.coursemanager.model.TrainingProgram;
import javax.persistence.ManyToOne;
import java.util.Set;
import org.rooina.coursemanager.model.Tag;
import java.util.HashSet;
import javax.persistence.ManyToMany;
import javax.persistence.CascadeType;
import org.rooina.coursemanager.model.Offering;
import javax.persistence.OneToMany;


@RooJavaBean
@RooToString
@RooEntity(finders = { "findCoursesByNameLike" })
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
