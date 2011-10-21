package org.rooina.coursemanager.model;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Path;
import javax.validation.Path.Node;
import javax.validation.groups.Default;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.mock.staticmock.AnnotationDrivenStaticEntityMockingControl;
import org.springframework.mock.staticmock.MockStaticEntityMethods;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@MockStaticEntityMethods
public class StudentTest {

    @Test
    public void testMethod() {
        int expectedCount = 13;
        Student.countStudents();
        AnnotationDrivenStaticEntityMockingControl.expectReturn(expectedCount);
        AnnotationDrivenStaticEntityMockingControl.playback();
        org.junit.Assert.assertEquals(expectedCount, Student.countStudents());
    }
    
    @Test
    public void testValidation() {
        Student.findStudent(1L);
    	StudentDataOnDemand dod = new StudentDataOnDemand();
    	AnnotationDrivenStaticEntityMockingControl.expectReturn(dod.getNewTransientStudent(0));
    	AnnotationDrivenStaticEntityMockingControl.playback();
        Student student = Student.findStudent(1L);
        student.setEmergencyContactInfo(null);
        LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
		validator.afterPropertiesSet();
		
		Set<ConstraintViolation<Student>> violations = validator.validate(student, Default.class);
		Assert.assertEquals(1, violations.size());
		ConstraintViolation<Student> violation = violations.iterator().next();
		Assert.assertEquals("{javax.validation.constraints.NotNull.message}", violation.getMessageTemplate());
		Assert.assertEquals("emergencyContactInfo", violation.getPropertyPath().toString());
    }
}
