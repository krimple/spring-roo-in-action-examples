/**
 *  Copyright.
 */
package com.rooinaction.cmsapp.integration;

import java.io.File;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author
 * 
 * Test Data:
 * Successful Registration Text Message:
 * Test Course Registration # 12345
 * 
 * Waitlist Registration Text Message:
 * Test Course Registration # - 99999
 *
 */
public class CourseRegistrationSpringIntegrationTest {

	private static final Log log = LogFactory.getLog(CourseRegistrationSpringIntegrationTest.class);
	
	private final static String[] configFiles = {
		"/META-INF/spring/integration/applicationContext-integration.xml", 
		"/META-INF/spring/integration/cmsapp-spring-int-config.xml"
	};
	
	public static void main(String[] args) {
		CourseRegistrationSpringIntegrationTest client = new CourseRegistrationSpringIntegrationTest();
		client.verifyThatCourseRegistrationIsSuccessful();
	}

	public void verifyThatCourseRegistrationIsSuccessful() {
		log.debug("verifyThatCourseRegistrationIsSuccessful() method is called.");
		log.debug("Cleaning up the ActiveMQ Test Data.");
		File tmpDirAMQ = new File("activemq-data");
		cleanupActiveMQDatabase(tmpDirAMQ);
		log.debug("Loading Spring Application Context.");
		new ClassPathXmlApplicationContext(configFiles, CourseRegistrationSpringIntegrationTest.class);
		log.debug("[For testing purposes, Successful Registration message should contain " +
				"the number 12345 and the Waitlist should contain 99999].");
		System.out.println("Type the Course Registration Test Message and press the Enter key.");
	}
	
	private void cleanupActiveMQDatabase(File dirAMQ) {
		if (dirAMQ.exists()) {
			String[] children = dirAMQ.list();
			if (children != null) {
				for (int i = 0; i < children.length; i++) {
					cleanupActiveMQDatabase(new File(dirAMQ, children[i]));
				}
			}
		}
		dirAMQ.delete();
	}

}
