package org.rooina.coursemanager.model;

import java.lang.annotation.Annotation;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

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
    public void addAndFetchCourse() {
    	Course c = new Course();
    	c.setCourseType(CourseTypeEnum.CONTINUING_EDUCATION);
    	c.setName("Stand-up Comedy");
    	c.setDescription("You'll laugh, you'll cry, it will become a part of you.");
    	c.setMaxiumumCapacity(10);    	
    	c.persist();    	

    	c.flush();

    	Assert.assertNotNull(c.getId());
    	
    	Course c2 = Course.findCourse(c.getId());
    	Assert.assertNotNull(c2);
    	Assert.assertEquals(c.getName(), c2.getName());
    	Assert.assertEquals(c2.getDescription(), c.getDescription());
    	Assert.assertEquals(c.getMaxiumumCapacity(), c2.getMaxiumumCapacity());
    	Assert.assertEquals(c.getCourseType(), c2.getCourseType());
    }
    
    @Test(expected = ConstraintViolationException.class )
    public void testInvalidCourse() {
    	Course c = new Course();
    	c.persist();
    }
    
    public void testPersistTagsInCourses() {
    	   CourseDataOnDemand courseDod = new CourseDataOnDemand();
    	   Course course = courseDod.getRandomCourse();
    	   TagDataOnDemand tagDod = new TagDataOnDemand();
    	   Tag t1 = tagDod.getNewTransientTag(0);
    	   Tag t2 = tagDod.getNewTransientTag(1);
    		
    	   course.getTags().add(t1);
    	   course.getTags().add(t2);
    	   course.persist();
    		
    	   course.flush();
    	   
    	   Assert.assertEquals(2, Course.findCourse(course.getId()).getTags().size());    	
    	}

  
    @Test
    public void testSpecificException() {
    	Course c = new Course();
    	c.setCourseType(CourseTypeEnum.CONTINUING_EDUCATION);
    	c.setMaxiumumCapacity(10);
    	//c.setRunDate(new Date());
    	c.setName(null);
    	c.setDescription(null);    	
    	try {
    		c.persist();
    	} catch (ConstraintViolationException cve) {
    		Assert.assertEquals(2, cve.getConstraintViolations().size());
    		Iterator<ConstraintViolation<?>> it = cve.getConstraintViolations().iterator();
    		while (it.hasNext()) {
    			ConstraintViolation<?> constraintViolation = it.next();    			
    			ConstraintDescriptor<?> descriptor = constraintViolation.getConstraintDescriptor();
    			Annotation annotation = descriptor.getAnnotation();
    			if (!(annotation.annotationType().getName().equals("javax.validation.constraints.NotNull"))) {
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
    public void testFindByNameFinder() {
    	Course c = new Course();
    	c.setName("Basket Weaving");
    	c.setCourseType(CourseTypeEnum.SEMINAR);
    	c.setDescription("Weaving baskets is an essential skill.");
    	c.setMaxiumumCapacity(100);
    	c.persist();
    	
    	c.flush();
    	//c.entityManager().clear();
    	
    	List<Course> courses = Course.findCoursesByNameLike("Bas").getResultList();
    	
    	Assert.assertEquals(1, courses.size());    	
    	
    }

}
