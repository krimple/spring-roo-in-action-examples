package org.rooinaction.coursemanager.model;

import org.springframework.roo.addon.dod.RooDataOnDemand;

import java.math.BigDecimal;

@RooDataOnDemand(entity = Course.class)
public class CourseDataOnDemand {

  public Course getNewTransientCourse(int index) {
    Course obj = new Course();
    setCourseType(obj, index);
    setDescription(obj, index);
    setMaximumCapacity(obj, index);
    setName(obj, index);
    setRunDate(obj, index);
    // this replaces the sample in the book - we've pushed-in the setListPrice
    // method from the ITD (CourseDataOnDemand_Roo_DataOnDemand.aj)
    // (below) and changed the value to a non-zero price with a non-fractional amount.
    setListPrice(obj, index);
    return obj;
  }

  public void setListPrice(Course obj, int index) {
    BigDecimal listPrice = new BigDecimal("100.00");
    obj.setListPrice(listPrice);
  }

  public void setCourseType(Course obj, int index) {
    CourseTypeEnum courseType = CourseTypeEnum.CONTINUING_EDUCATION;
    obj.setCourseType(courseType);
  }

  public void setMaximumCapacity(Course obj, int index) {
    // another correction to examples - this max capacity value
    // needs to be between a min of 1 and max of 9999.
    // this worked properly in Roo 1.2.0 without patching.
    if (index == 0)
      obj.setMaximumCapacity(1);
    else if (index > 9999)
      obj.setMaximumCapacity(9999);
    else
       obj.setMaximumCapacity(index);
  }
}
