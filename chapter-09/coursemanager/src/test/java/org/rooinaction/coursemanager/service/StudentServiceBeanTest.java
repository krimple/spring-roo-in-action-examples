package org.rooinaction.coursemanager.service;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.rooinaction.coursemanager.model.Person;
import org.rooinaction.coursemanager.model.Student;
import org.rooinaction.coursemanager.model.StudentDataOnDemand;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Configurable;


//@RunWith(PowerMockRunner.class)
//@PrepareForTest({Student.class, Person.class})
public class StudentServiceBeanTest {

    private StudentServiceBean studentServiceBean = new StudentServiceBean();
    private final Map<Long, Student> students = new HashMap<Long, Student>();
    /*
    @Before
    public void setup() {
    	PowerMockito.mockStatic(Student.class, new Answer() {
    		@Override
    		public Object answer(InvocationOnMock invocation) throws Throwable {    			
    			return new Configurable() {
    				@Override
    				public boolean preConstruction() {
    					// TODO Auto-generated method stub
    					return true;
    				}

					@Override
					public Class<? extends Annotation> annotationType() {
						// TODO Auto-generated method stub
						return null;
					}

					@Override
					public Autowire autowire() {
						// TODO Auto-generated method stub
						return null;
					}

					@Override
					public boolean dependencyCheck() {
						// TODO Auto-generated method stub
						return false;
					}

					@Override
					public String value() {
						// TODO Auto-generated method stub
						return null;
					}
    			};
    		}
    	});
    	PowerMockito.mockStatic(Person.class);
        students.clear();
        StudentDataOnDemand dod = new StudentDataOnDemand();
        
    	for (int i = 0; i < 10; i++) {
    		
    		Student student = dod.getNewTransientStudent(i);
    		Student studentSpy = Mockito.spy(student);
    		// add to our "database"
    		students.put((long)i, studentSpy);
    		
    		Mockito.doNothing().when(studentSpy).persist();
    		Mockito.doNothing().when(studentSpy).flush();      		
    	}
    	
    	//Mockito.doNothing().when(Student.entityManager());
    	//Mockito.doNothing().when(Person.entityManager());
    	
    	Mockito.when(Student.findStudent(new Long(0L))).thenAnswer(new Answer() {
			@Override
			public Object answer(InvocationOnMock invocation)
					throws Throwable {
				Student student = students.get((Long)invocation.getArguments()[0]);
				return student;
			}
			
		});    	    	
    }
    
    @Test
    public void updateCities() {
    	
    	List<Long> keys = new ArrayList<Long>();
    	for (int i = 0; i < 10; i++) { keys.add(new Long(i)); }
    	studentServiceBean.updateCities(keys, "Key West");
    	
    	// now, if all is well, we verify the map has only cities of "Key West"
    	Iterator<Student> itEntries = students.values().iterator();
    	while (itEntries.hasNext()) {
    		Student student = itEntries.next();
    		Assert.assertEquals("Key West", student.getCity());
    	}
    }
*/
}
