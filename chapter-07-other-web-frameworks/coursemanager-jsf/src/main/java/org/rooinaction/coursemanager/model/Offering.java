package org.rooinaction.coursemanager.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;
import javax.validation.constraints.AssertTrue;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.serializable.RooSerializable;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooSerializable
@RooJpaActiveRecord
public class Offering {

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "S-")
    @Column(name = "run_date")
    private Date runDate;

    @ManyToOne(cascade = CascadeType.ALL)
    private Course course;
    
    @OneToMany(mappedBy = "offering", cascade = CascadeType.ALL)
    private Set<Registration> registrations = new HashSet<Registration>();

    @ManyToOne(cascade = CascadeType.ALL)
    private Instructor instructor;
    
//    @AssertTrue(message="course.full.exception")
//    public boolean isValid() {
//    	int maxCapacity = course.getMaximumCapacity();
//    	return registrations.size() <= maxCapacity;
//    }
    
    public void addRegistration(Registration registration) {
    	registration.setOffering(this);
    	registrations.add(registration);
    }
    
    public long countStudentsRegisteredInOffering() {
        return entityManager().createQuery("select count(r) from Registration r " +
        		"where r.offering = :offering", 
        		Long.class).setParameter("offering", this).getSingleResult();
    }
    
    public static TypedQuery<Offering> findOfferingsByCourseId(Long courseId) {
        if (courseId == null) throw new IllegalArgumentException("The courseID argument is required");
        EntityManager em = entityManager();
        TypedQuery<Offering> q = em.createQuery("SELECT Offering FROM Offering AS offering WHERE offering.course.id = :courseId", Offering.class);
        q.setParameter("courseId", courseId);
        return q;
    }

	public String toString() {        
        return getRunDate().toString();        
    }
}
