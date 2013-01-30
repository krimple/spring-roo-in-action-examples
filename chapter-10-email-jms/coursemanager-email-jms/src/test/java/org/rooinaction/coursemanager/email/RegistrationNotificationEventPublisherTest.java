/**
 * 
 */
package org.rooinaction.coursemanager.email;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Srini
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
"classpath:/META-INF/spring/applicationContext.xml"
})
public class RegistrationNotificationEventPublisherTest {

	@Autowired
	private NotificationService notificationService;

	@Test
	public void verifyThatRegistrationNotificationIsSuccessful() {

		// Send e-mail notification
		String mailTo="test-user@gmail.com";
		String message="RegistrationSuccessful.";
		notificationService.sendMessage(mailTo,message);
	}
}
