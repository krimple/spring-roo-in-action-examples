// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package org.rooinaction.coursemanager.model;

import java.lang.Integer;
import java.lang.String;
import java.math.BigDecimal;
import java.util.Set;
import org.rooinaction.coursemanager.model.CourseTypeEnum;
import org.rooinaction.coursemanager.model.Offering;
import org.rooinaction.coursemanager.model.Tag;
import org.rooinaction.coursemanager.model.TrainingProgram;

privileged aspect Course_Roo_JavaBean {
    
    public String Course.getName() {
        return this.name;
    }
    
    public void Course.setName(String name) {
        this.name = name;
    }
    
    public String Course.getDescription() {
        return this.description;
    }
    
    public void Course.setDescription(String description) {
        this.description = description;
    }
    
    public BigDecimal Course.getCost() {
        return this.cost;
    }
    
    public void Course.setCost(BigDecimal cost) {
        this.cost = cost;
    }
    
    public Integer Course.getMaxiumumCapacity() {
        return this.maxiumumCapacity;
    }
    
    public void Course.setMaxiumumCapacity(Integer maxiumumCapacity) {
        this.maxiumumCapacity = maxiumumCapacity;
    }
    
    public CourseTypeEnum Course.getCourseType() {
        return this.courseType;
    }
    
    public void Course.setCourseType(CourseTypeEnum courseType) {
        this.courseType = courseType;
    }
    
    public TrainingProgram Course.getTrainingProgram() {
        return this.trainingProgram;
    }
    
    public void Course.setTrainingProgram(TrainingProgram trainingProgram) {
        this.trainingProgram = trainingProgram;
    }
    
    public Set<Tag> Course.getTags() {
        return this.tags;
    }
    
    public void Course.setTags(Set<Tag> tags) {
        this.tags = tags;
    }
    
    public Set<Offering> Course.getOfferings() {
        return this.offerings;
    }
    
    public void Course.setOfferings(Set<Offering> offerings) {
        this.offerings = offerings;
    }
    
}
