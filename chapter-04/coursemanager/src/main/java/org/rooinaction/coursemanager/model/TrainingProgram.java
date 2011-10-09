package org.rooinaction.coursemanager.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.serializable.RooSerializable;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooEntity
@RooSerializable
@Table(name="training_program")
public class TrainingProgram {

    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trainingProgram")
    private Set<Course> courses = new HashSet<Course>();
}
