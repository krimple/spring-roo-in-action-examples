package org.rooinaction.coursemanager.model;

import org.springframework.roo.addon.dod.RooDataOnDemand;

@RooDataOnDemand(entity = Course.class)
public class CourseDataOnDemand {

  public void setCourseType(Course obj, int index) {

      obj.setCourseType(CourseTypeEnum.CONTINUING_EDUCATION);
  }
}
