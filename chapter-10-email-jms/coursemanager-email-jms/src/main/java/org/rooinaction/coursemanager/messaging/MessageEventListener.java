package org.rooinaction.coursemanager.messaging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

/**
 * @author Srini
 */
public class MessageEventListener {

    @Autowired
    private transient JmsTemplate jmsTopicTemplate;

	public void onApplicationEvent(ApplicationEvent event) {
    	System.out.println("ApplicationEvent: " + event);
        if (event instanceof MessageEvent) {
            MessageEvent messageEvent = (MessageEvent)event;
            System.out.println("Received " + messageEvent.getMessage() +
                    " from " + messageEvent.getSource());

            // Post the message to JMS Destination
            sendMessage(messageEvent);
        }
    }

	public void sendMessage(Object messageObject) {
		jmsTopicTemplate.convertAndSend(messageObject);
    }
}
