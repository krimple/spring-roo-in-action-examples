package org.rooinaction.coursemanager.web;

import org.junit.runner.RunWith;
import org.rooinaction.coursemanager.model.Course;
import org.rooinaction.coursemanager.model.CourseDataOnDemand;
import org.rooinaction.coursemanager.web.scaffold.CourseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath*:/META-INF/spring/applicationContext.xml",
		"/WEB-INF/spring/webmvc-config.xml"})
@Transactional
public class CourseControllerTest {

	@Autowired
	CourseController controller;
	
	
	public void testPostNew() {
		CourseDataOnDemand dod = new CourseDataOnDemand();
		Course course = dod.getNewTransientCourse(0);
		
		
	}
}
