package org.rooinaction.coursemanager.model;

import java.lang.annotation.Annotation;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Iterator;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.metadata.ConstraintDescriptor;

import junit.framework.Assert;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.rooinaction.coursemanager.model.db.CourseRepository;
import org.springframework.roo.addon.test.RooIntegrationTest;

@RooIntegrationTest(entity = Course.class)
public class CourseIntegrationTest {

  Logger logger = Logger.getLogger(CourseIntegrationTest.class);

  @Test
  public void testMarkerMethod() {
  }

  
  @Test
  public void addAndFetchCourseViaRepo() {
    Course c = new Course();
    c.setCourseType(CourseTypeEnum.CONTINUING_EDUCATION);
    c.setName("Stand-up Comedy");
    c.setListPrice(new BigDecimal("100.00"));
    c.setDescription(
      "You'll laugh, you'll cry, it will become a part of you.");
    c.setMaximumCapacity(10);

    courseRepository.saveAndFlush(c);
    Assert.assertNotNull(c.getId());

    Course c2 = courseRepository.findOne(c.getId());
    Assert.assertNotNull(c2);
    Assert.assertEquals(c.getName(), c2.getName());
    Assert.assertEquals(c2.getDescription(), c.getDescription());
    Assert.assertEquals(
      c.getMaximumCapacity(), c2.getMaximumCapacity());
    Assert.assertEquals(c.getCourseType(), c2.getCourseType());
  }
}
