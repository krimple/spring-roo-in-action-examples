package org.rooinaction.coursemanager.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsOperations;

public class CourseRegistrationNotificationHelper {

    @Autowired
    private transient JmsOperations jmsTemplate;

    public void sendMessage(Object messageObject) {
        jmsTemplate.convertAndSend(messageObject);
    }
}
