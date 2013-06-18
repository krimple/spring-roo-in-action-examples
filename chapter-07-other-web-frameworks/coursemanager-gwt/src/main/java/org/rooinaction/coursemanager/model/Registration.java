package org.rooinaction.coursemanager.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.ManyToOne;
import javax.persistence.TypedQuery;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.serializable.RooSerializable;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooSerializable
@RooJpaActiveRecord(finders = { "findRegistrationsByStudentAndOffering", "findRegistrationsByStudentAndOfferingNot" })
public class Registration {
	
	public Registration(Student student, Offering offering) {
		this.student = student;
		this.offering = offering;
		paymentMade = false;
		attended = false;
	}
	
	public Registration() {
		super();
	}

    @ManyToOne
    private Student student;

    @ManyToOne
    private Offering offering;

    @Column(name = "payment_made")
    private boolean paymentMade;

    private boolean attended;

    public static TypedQuery<Registration> findRegistrationsByStudent(Long studentId, Date startDate, Date endDate) {
        if (studentId == null) throw new IllegalArgumentException("The student id argument is required");
        EntityManager em = Registration.entityManager();
        TypedQuery<Registration> q = em.createQuery("SELECT DISTINCT r " + "FROM Registration AS r " + "WHERE r.student.id = :studentId " + "AND r.offering IN (SELECT o from Offering o " + "  WHERE o.runDate between :start and :end)", Registration.class);
        q.setParameter("studentId", studentId);
        q.setParameter("start", startDate);
        q.setParameter("end", endDate);
        return q;
    }
}
