package org.rooinaction.coursemanager.messaging;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:/META-INF/spring/applicationContext.xml",
		"classpath:/META-INF/spring/applicationContext-jms.xml"
})
public class RegistrationNotificationWaitListEventPublisherTest {

	private static final Log log = LogFactory.getLog(RegistrationNotificationWaitListEventPublisherTest.class);

    @Autowired
    private transient JmsTemplate jmsQueueTemplate;

    @Test
	public void verifyRegistrationNotificationWaitListEventIsSuccessful() {

    	String regNotifyWaitListEvent = "Test regNotifyWaitListEvent Message.";

    	log.debug("regNotifyWaitListEvent: " + regNotifyWaitListEvent);

    	// Post the message to JMS Destination
    	sendMessage(regNotifyWaitListEvent);
    }

	private void sendMessage(Object messageObject) {
		jmsQueueTemplate.convertAndSend(messageObject);
    }
}
