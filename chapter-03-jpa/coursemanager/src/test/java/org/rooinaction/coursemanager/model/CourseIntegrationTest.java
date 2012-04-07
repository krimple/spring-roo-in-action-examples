package org.rooinaction.coursemanager.model;

import junit.framework.Assert;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.roo.addon.test.RooIntegrationTest;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.metadata.ConstraintDescriptor;
import java.lang.annotation.Annotation;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@RooIntegrationTest(entity = Course.class)
public class CourseIntegrationTest {

  Logger logger = Logger.getLogger(CourseIntegrationTest.class);

  @Test
  public void testMarkerMethod() {
  }

  @Test
  public void addAndFetchCourse() {
    Course c = new Course();
    c.setCourseType(CourseTypeEnum.CONTINUING_EDUCATION);
    c.setName("Stand-up Comedy");
    c.setDescription("You'll laugh, you'll cry, it will become a part of you.");
    c.setMaximumCapacity(10);
    // a fix after adding validation annotations in 3.3 and rounding constraint
    c.setListPrice(new BigDecimal("100"));

    c.persist();
    c.flush();
    c.clear();
    Assert.assertNotNull(c.getId());
    Course c2 = Course.findCourse(c.getId());
    Assert.assertNotNull(c2);
    Assert.assertEquals(c.getName(), c2.getName());
    Assert.assertEquals(c2.getDescription(), c.getDescription());
    Assert.assertEquals(c.getMaximumCapacity(), c2.getMaximumCapacity());
    Assert.assertEquals(c.getCourseType(), c2.getCourseType());
  }

  @Test(expected = ConstraintViolationException.class)
  public void testInvalidCourse() {
    Course c = new Course();
    c.persist();
  }

  @Test
  public void testSpecificException() {
    Course c = new Course();
    c.setCourseType(CourseTypeEnum.CONTINUING_EDUCATION);
    c.setMaximumCapacity(10);
    c.setRunDate(new Date());
    // now because we did not set them,
    // name, description and listPrice are null...
    try {
      c.persist();
    } catch (ConstraintViolationException cve) {
      Assert.assertEquals(3, cve.getConstraintViolations().size());
      Iterator<ConstraintViolation<?>> it = cve.getConstraintViolations()
          .iterator();
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
  public void testValidPrice() {
    Course course = new CourseDataOnDemand().getNewTransientCourse(0);
    course.setCourseType(CourseTypeEnum.SEMINAR);
    course.setListPrice(new BigDecimal("500"));
    course.persist();
  }

  @Test(expected = ConstraintViolationException.class)
  public void testInvalidPrice() {
    Course course = new CourseDataOnDemand().getNewTransientCourse(0);
    course.setListPrice(new BigDecimal("500.30"));
    course.persist();
  }

  @Test
  public void testFindByNameFinder() {
    Course c = new Course();
    c.setName("Basket Weaving");
    c.setCourseType(CourseTypeEnum.SEMINAR);
    c.setDescription("Weaving baskets is an essential skill.");
    c.setMaximumCapacity(100);
    c.setRunDate(new Date());
    c.setListPrice(new BigDecimal("100"));
    c.persist();
    c.flush();
    c.entityManager().clear();
    List<Course> courses =
        c.findCoursesByNameLike("Bas").getResultList();
    Assert.assertEquals(1, courses.size());
  }
}
