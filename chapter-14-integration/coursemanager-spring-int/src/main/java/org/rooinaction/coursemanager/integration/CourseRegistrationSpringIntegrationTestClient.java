/**
 *  Copyright.
 */
package org.rooinaction.coursemanager.integration;

import java.io.File;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author
 * 
 * Test Data:
 * 
 * SCENARIO # 1:
 * Successful Registration Text Message:
 * Test Course Registration # 12345
 * 
 * SCENARIO # 2:
 * Waitlist Registration Text Message:
 * Test Course Registration # 99999
 *
 * SCENARIO # 3:
 * Invalid Registration Text Message:
 * Test Course Registration # 77777
 * 
 * When the test client is up and running, try with all three scenarios
 * by entering the text messages listed above, to see how each message
 * is routed to a different channel to process the course registration, 
 * based on the context (i.e. the registration code included in the
 * text message).
 * 
 */
public class CourseRegistrationSpringIntegrationTestClient {

	private static final Log log = LogFactory.getLog(CourseRegistrationSpringIntegrationTestClient.class);
	
	private final static String[] configFiles = {
		"/META-INF/spring/integration/applicationContext-integration.xml", 
		"/META-INF/spring/integration/coursemanager-spring-int-config.xml"
	};
	
	public static void main(String[] args) {
		CourseRegistrationSpringIntegrationTestClient client = new CourseRegistrationSpringIntegrationTestClient();
		client.verifyThatCourseRegistrationIsSuccessful();
	}

	public void verifyThatCourseRegistrationIsSuccessful() {
		log.debug("verifyThatCourseRegistrationIsSuccessful() method is called.");
		log.debug("Cleaning up the ActiveMQ Test Data.");
		File tmpDirAMQ = new File("activemq-data");
		cleanupActiveMQDatabase(tmpDirAMQ);
		log.debug("Loading Spring Application Context.");
		new ClassPathXmlApplicationContext(configFiles, CourseRegistrationSpringIntegrationTestClient.class);
		log.debug("[For testing purposes, Successful Registration message should contain " +
				"the number 12345 and the Waitlist should contain 99999].");
		System.out.println("Type the Course Registration Test Message and press the Enter key:");
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
