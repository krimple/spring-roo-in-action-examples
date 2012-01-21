package com.rooinaction.cmsapp.messaging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

/**
 * @author Srini
 */
@Component
public class CourseCatalogUpdateEventListener implements ApplicationListener {

    @Autowired
    private transient JmsTemplate jmsTopicTemplate;
    
	public void onApplicationEvent(ApplicationEvent event) {
    	System.out.println("ApplicationEvent: " + event);
        if (event instanceof CourseCatalogUpdateEvent) {
        	CourseCatalogUpdateEvent courseCatalogEvent = (CourseCatalogUpdateEvent)event;
            System.out.println("Received " + courseCatalogEvent.getMessage() +
                    " from " + courseCatalogEvent.getSource());
            
            // Post the message to JMS Destination
            sendMessage(courseCatalogEvent);
        }
    }

	public void sendMessage(Object messageObject) {
		jmsTopicTemplate.convertAndSend(messageObject);
    }
}
