package com.rooinaction.cmsapp.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

/**
 * @author Srini
 */
@Component
public class RegistrationNotificationEventListener implements ApplicationListener {
//public class RegistrationNotificationEventListener {

    @Autowired
    private NotificationService notificationService;
    
	public void onApplicationEvent(ApplicationEvent event) {
    	System.out.println("ApplicationEvent: " + event);
        if (event instanceof RegistrationNotificationEvent) {
        	RegistrationNotificationEvent messageEvent = (RegistrationNotificationEvent)event;
            System.out.println("Received " + messageEvent.getMessage() +
                    " from " + messageEvent.getSource());
            
            // Post the message to JMS Destination
            String mailTo = "srinipenchikala@gmail.com";
            String message = "TEST 2";
            notificationService.sendMessage(mailTo, message);
        }
    }
}
