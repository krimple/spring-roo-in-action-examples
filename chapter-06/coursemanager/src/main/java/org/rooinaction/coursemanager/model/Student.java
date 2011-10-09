package org.rooinaction.coursemanager.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.OneToMany;
import javax.persistence.TypedQuery;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.serializable.RooSerializable;
import org.springframework.roo.addon.tostring.RooToString;
import org.springframework.transaction.annotation.Transactional;

@RooJavaBean
@RooToString
@RooEntity
@RooSerializable
public class Student extends Person {
	
	@NotNull
	@Size(min = 1, max = 30)
	@Column(length = 30, name = "emergency_contact_name", nullable = false)
	private String emergencyContactName;
	
	@NotNull
	@Size(min = 1, max = 80)
	@Column(name = "emergency_contact_info")
	private String emergencyContactInfo;
	
	@Size(max = 30)
	@Column(name = "dietary_restrictions")
	private String dietaryRestrictions;
	
	@OneToMany(mappedBy = "student", cascade = CascadeType.ALL)	
	private Set<Registration> registrations = new HashSet<Registration>();

@Transactional(readOnly=true)
public static TypedQuery<Student> findStudentsNotInOffering(Offering o) {
    if (o == null) throw new IllegalArgumentException("The offering argument is required");
    EntityManager em = Student.entityManager();
    TypedQuery<Student> q = em.createQuery("SELECT student FROM Student AS student " +
    		"WHERE student.id NOT IN " +
    		"(select registration.student.id from Registration registration where registration.offering = :offering)", 
    		Student.class);
    q.setParameter("offering", o);
    return q;
}

@Transactional(readOnly=true)
public static TypedQuery<Student> findStudentsNotRegisteredForOffering(Offering offering) {
    if (offering == null) throw new IllegalArgumentException("The offering argument is required");
    EntityManager em = Registration.entityManager();
    TypedQuery<Student> q = em.createQuery("SELECT student FROM Student AS student " +
    		"WHERE student not in (select r.s from Registration as r where r.offering = :offering)", Student.class);
    q.setParameter("offering", offering);
    return q;
}

@Transactional(readOnly=true)
public static TypedQuery<Student> findStudentsRegisteredForOffering(Offering offering) {
    if (offering == null) throw new IllegalArgumentException("The offering argument is required");
    EntityManager em = Registration.entityManager();
    TypedQuery<Student> q = em.createQuery("SELECT s FROM Student s INNER JOIN s.registrations r " +
    		"WHERE r.offering = :offering", Student.class);
    q.setParameter("offering", offering);
    return q;
}	

@Transactional(readOnly=true)
public static TypedQuery<Student> findStudentsByName(String name) {
	if (name == null) throw new IllegalArgumentException("The student argument is required");
	EntityManager em = Student.entityManager();
	TypedQuery<Student> q = em.createQuery("SELECT student from Student as Student " +
			"WHERE student.lastName like :name", Student.class);
	q.setParameter("name", "%" + name + "%");
	return q;
}

@Transactional(readOnly=true)
public static TypedQuery<Student> findStudentsByIdIn(List<Long> studentIds) {
	if (studentIds == null) throw new IllegalArgumentException("The studentIds argument is required");
	
	EntityManager em = Student.entityManager();
	TypedQuery<Student> q = em.createQuery("SELECT student from Student as Student " +
			"WHERE student.id in (:studentIds)", Student.class);
	q.setParameter("studentIds", studentIds);
	return q;
}
}
