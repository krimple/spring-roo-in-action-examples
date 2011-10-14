package com.rooinaction.cmsapp.messaging;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rooinaction.cmsapp.messaging.RegistrationNotificationWaitListEventPublisher;

/**
 * @author
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:/META-INF/spring/applicationContext.xml",
		"classpath:/META-INF/spring/applicationContext-jms.xml"
})
public class RegistrationNotificationWaitListEventPublisherTest {

	@Autowired
	private RegistrationNotificationWaitListEventPublisher eventPublisher;

	@Test
	public void testCourseCatalogUpdateEvent() {
		eventPublisher.publish("RegistrationNotificationWaitListEvent - Test Message 1");
//		eventPublisher.publish("RegistrationNotificationWaitListEvent - Test Message 2");
	}
}


