package org.rooinaction.coursemanager.model;

import java.lang.annotation.Annotation;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Iterator;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.metadata.ConstraintDescriptor;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.roo.addon.test.RooIntegrationTest;

@RooIntegrationTest(entity = Course.class)
public class CourseIntegrationTest {

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
    c.setListPrice(null);
    try {
      c.persist();
    } catch (ConstraintViolationException cve) {
      Assert.assertEquals(3, cve.getConstraintViolations().size());
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
    } catch (Exception e) {
      Assert.fail("Unexpected exception thrown " + e.getMessage());
      return;
    }

    Assert.fail("Exception not thrown.");
  }

  @Test
  public void testInvalidPrice() {

    try {
      CourseDataOnDemand cDod = new CourseDataOnDemand();
      Course course = cDod.getNewTransientCourse(0);
      course.setListPrice(new BigDecimal("2234.05"));
      course.persist();
      course.flush();
      return;
    } catch (ConstraintViolationException ve) {
      Iterator<ConstraintViolation<?>> violationsIterator = ve.getConstraintViolations().iterator();

      while (violationsIterator.hasNext()) {
        ConstraintViolation<?> violation = violationsIterator.next();
        if (violation.getMessageTemplate().equals("Invalid price")) {
          return;
        }
      }
    }
    Assert.fail("This test did not throw an invalid price exception.");
  }
}
