package com.rooinaction.cmsapp.messaging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

/**
 *
 * @author Srini
 */
@Component
public class RegistrationNotificationWaitListEventListener {

	@Autowired
	private transient JmsTemplate jmsQueueTemplate;

	public void onApplicationEvent(ApplicationEvent event) {
		System.out.println("ApplicationEvent: " + event);
		if (event instanceof RegistrationNotificationWaitListEvent) {
			RegistrationNotificationWaitListEvent regNotifyWaitListEvent = (RegistrationNotificationWaitListEvent) event;
			System.out.println("Received "
					+ regNotifyWaitListEvent.getMessage() +
					" from " + regNotifyWaitListEvent.getSource());

			// Post the message to JMS Destination
			sendMessage(event);
		}
	}

	public void sendMessage(Object messageObject) {
		jmsQueueTemplate.convertAndSend(messageObject);
	}
}
