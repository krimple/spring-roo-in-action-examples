package org.rooinaction.coursemanager.messaging;


public class JmsCourseRegistrationWaitListQueueListener {

    public void onMessage(Object message) {
        System.out.println("JMS message received: " + message);
    }
}
