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
  public void testSpecificException() {
    Course c = new Course();
    c.setCourseType(CourseTypeEnum.CONTINUING_EDUCATION);
    c.setMaxiumumCapacity(10);
    c.setRunDate(new Date());
    c.setName(null);
    c.setDescription(null);
    c.setListPrice(new BigDecimal("123.55"));
    try {
      courseRepository.save(c);
    } catch (ConstraintViolationException cve) {
      logger.debug("Constraint violation thrown - ", cve);
      Assert.assertEquals(2, cve.getConstraintViolations().size());
      Iterator<ConstraintViolation<?>> it = cve
              .getConstraintViolations().iterator();
      while (it.hasNext()) {
        ConstraintViolation<?> constraintViolation = it.next();
        ConstraintDescriptor<?> descriptor = constraintViolation
                .getConstraintDescriptor();
        Annotation annotation = descriptor.getAnnotation();
        if (!(annotation.annotationType().getName()
                .equals("javax.validation.constraints.NotNull"))) {
          Assert.fail("invalid error raised.  Should be 'not null'");
        }
      }
      return;
    } 

    Assert.fail("Exception not thrown.");
  }

  @Test
  public void testValidPrice() {
    CourseDataOnDemand cDod = new CourseDataOnDemand();
    Course course = cDod.getNewTransientCourse(0);
    course.setListPrice(new BigDecimal("2234.05"));
    courseRepository.save(course);
  }
  
  @Test
  public void testInvalidPrice() {
    try {
      CourseDataOnDemand cDod = new CourseDataOnDemand();
      Course course = cDod.getNewTransientCourse(0);
      course.setListPrice(new BigDecimal("2234.07"));
      courseRepository.save(course);
      
      Assert.fail("This test did not throw an invalid price exception.");
    } catch (ConstraintViolationException ve) {
      Iterator<ConstraintViolation<?>> violationsIterator = ve.getConstraintViolations().iterator();

      while (violationsIterator.hasNext()) {
        ConstraintViolation<?> violation = violationsIterator.next();
        if (violation.getMessageTemplate().equals("Invalid price")) {
          return;
        }
      }
    }
  }
  
  @Test
  public void addAndFetchCourseViaRepo() {
    Course c = new Course();
    c.setCourseType(CourseTypeEnum.CONTINUING_EDUCATION);
    c.setName("Stand-up Comedy");
    c.setListPrice(new BigDecimal("100.05"));
    c.setDescription(
      "You'll laugh, you'll cry, it will become a part of you.");
    c.setMaxiumumCapacity(10);

    courseRepository.saveAndFlush(c);
    Assert.assertNotNull(c.getId());

    Course c2 = courseRepository.findOne(c.getId());
    Assert.assertNotNull(c2);
    Assert.assertEquals(c.getName(), c2.getName());
    Assert.assertEquals(c2.getDescription(), c.getDescription());
    Assert.assertEquals(
      c.getMaxiumumCapacity(), c2.getMaxiumumCapacity());
    Assert.assertEquals(c.getCourseType(), c2.getCourseType());
  }
}
