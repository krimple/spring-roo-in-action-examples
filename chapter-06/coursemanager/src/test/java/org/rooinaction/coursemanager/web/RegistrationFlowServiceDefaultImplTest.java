package org.rooinaction.coursemanager.web;

import static org.mockito.Mockito.RETURNS_DEEP_STUBS;
import static org.mockito.Mockito.mock;
import static org.powermock.api.mockito.PowerMockito.mockStatic;

import java.util.ArrayList;

import javax.persistence.EntityManager;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.rooinaction.coursemanager.model.Course;
import org.rooinaction.coursemanager.model.Offering;
import org.springframework.mock.staticmock.AnnotationDrivenStaticEntityMockingControl;
import org.springframework.mock.staticmock.MockStaticEntityMethods;
import org.springframework.webflow.execution.Event;
import org.springframework.webflow.test.MockExternalContext;
import org.springframework.webflow.test.MockParameterMap;
import org.springframework.webflow.test.MockRequestContext;

@MockStaticEntityMethods
//@RunWith(PowerMockRunner.class)
//@PrepareForTest(Course.class)
public class RegistrationFlowServiceDefaultImplTest {

	private RegistrationFlowServiceDefaultImpl registrationFlowService;
	
	@Before
	public void setUp() {
		this.registrationFlowService = new RegistrationFlowServiceDefaultImpl();		
	}
	
	@Test
	public void testFindCourseById() {
		long courseId = 1l;
		Course.findCourse(courseId);		
		AnnotationDrivenStaticEntityMockingControl.expectReturn(new Course());
		AnnotationDrivenStaticEntityMockingControl.playback();
		Course course = Course.findCourse(1L);
		Assert.assertNotNull(course);		
	}
	
	@Test
	public void testAddStudent() {
				
		long courseId = 1l;
		long offeringId = 1l;
		
		setupMocks(0, 10, courseId, offeringId);				
		
		// now, set up our form in the fake webflow context
		RegisterStudentsForm form = new RegisterStudentsForm();
		
		// Course registration:  empty list - test that it has a value later
		form.setStudentsToRegister(new ArrayList<Long>());
		
		MockRequestContext context = setupMockContext(courseId, offeringId,
				form);
		
		// pre-test assertion
		Assert.assertEquals(0, form.getStudentsToRegister().size());		
		
		// now, try testing it
		Event event = this.registrationFlowService.addStudent(context);
		
		// post-test assertion
		Assert.assertEquals(1, form.getStudentsToRegister().size());
		
		Assert.assertEquals("success", event.getId());			
	}
	
	@Test(expected = CourseFullException.class)
	public void testAddStudentNoCapacity() {
		long courseId = 1l;
		long offeringId = 1l;
		
		setupMocks(10, 10, courseId, offeringId);				
		
		// now, set up our form in the fake webflow context
		RegisterStudentsForm form = new RegisterStudentsForm();
		
		// Course registration:  empty list - test that it has a value later
		form.setStudentsToRegister(new ArrayList<Long>());
		
		MockRequestContext context = setupMockContext(courseId, offeringId, form);
		
		// pre-test assertion
		Assert.assertEquals(0, form.getStudentsToRegister().size());		
		
		// now, try testing it
		this.registrationFlowService.addStudent(context);
		
		// post-test assertion
		Assert.assertEquals(1, form.getStudentsToRegister().size());	
	}
	

	private void setupMocks(long studentsRegistered, 
			int maxCapacity, long courseId, long offeringId) {		
		 
		// Mockito mock the course
		//final EntityManager manager = mock(EntityManager.class);
		Course course = mock(Course.class, RETURNS_DEEP_STUBS);
		Offering offering = mock(Offering.class, RETURNS_DEEP_STUBS);	
		EntityManager manager = mock(EntityManager.class, RETURNS_DEEP_STUBS);
		mockStatic(Course.class);
		mockStatic(Offering.class);
		Mockito.when(Course.entityManager()).thenReturn(manager);
		Mockito.when(Offering.entityManager()).thenReturn(manager);
		Mockito.when(Course.findCourse(1L)).thenReturn(course);
		
		// set up the static mocking for the findCourse method to return our emulated course		
		Course.findCourse(courseId);		
		//AnnotationDrivenStaticEntityMockingControl.expectReturn(course);		
		Offering.findOffering(offeringId);
		AnnotationDrivenStaticEntityMockingControl.expectReturn(offering);
		AnnotationDrivenStaticEntityMockingControl.playback();

		// mock call return values - have exactly one more seat left so we should allow the reg
		Mockito.when(offering.countStudentsRegisteredInOffering()).thenReturn(studentsRegistered);
		Mockito.when(course.getMaxiumumCapacity()).thenReturn(maxCapacity);
	}

	private MockRequestContext setupMockContext(long courseId, long offeringId,
			RegisterStudentsForm form) {
		
		// mock the Web Flow Request Context
		MockRequestContext context = new MockRequestContext();
		
		// dummy data - not used to go to a real database call
		form.setCourseId(courseId);
		form.setOfferingId(offeringId);
		
		// stuff data in form
		context.getFlowScope().asMap().put("registerStudentsForm", form);
		
		// mock an external context
		MockParameterMap parameterMap = new MockParameterMap();
		parameterMap.put("id", String.valueOf(courseId));
		MockExternalContext externalContext = new MockExternalContext(parameterMap);
		context.setExternalContext(externalContext);
		return context;
	}
}
