package com.rooinaction.cmsapp.email;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rooinaction.cmsapp.email.RegistrationNotificationEventPublisher;

/**
 * @author Srini
 */
@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration(locations = {
            "classpath:/META-INF/spring/applicationContext.xml"
            ,"classpath:/META-INF/spring/applicationContext-jms.xml"
      })
public class RegistrationNotificationEventPublisherTest {
	
	@Autowired
	private RegistrationNotificationEventPublisher eventPublisher;

	@Test
	public void verifyThatRegistrationNotificationIsSuccessful() {
		eventPublisher.publish("Test Email Message 1");
//		eventPublisher.publish("Test Email Message 2");
	}

}
