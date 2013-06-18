package org.rooinaction.coursemanager.model;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
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
    @DecimalMax("99999.00")
    @Digits(integer = 7, fraction = 2)
    private BigDecimal listPrice;    

    @NotNull
    @Column(name = "max_capacity")
    @Min(1L)
    @Max(9999L)
    private Integer maxiumumCapacity;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "course_type")
    private CourseTypeEnum courseType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "training_program")
    private TrainingProgram trainingProgram;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "courses")
    @Column(name = "tag_id")
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
