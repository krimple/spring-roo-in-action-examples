package org.rooinaction.coursemanager.model;

import java.math.BigDecimal;

import org.springframework.roo.addon.dod.RooDataOnDemand;

@RooDataOnDemand(entity = Course.class)
public class CourseDataOnDemand {

  public Course getNewTransientCourse(int index) {
    Course obj = new Course();
    setCourseType(obj, index);
    setDescription(obj, index);
    setMaxiumumCapacity(obj, index);
    setName(obj, index);
    setRunDate(obj, index);
    obj.setListPrice(new BigDecimal("100.05"));
    return obj;
  }
}
