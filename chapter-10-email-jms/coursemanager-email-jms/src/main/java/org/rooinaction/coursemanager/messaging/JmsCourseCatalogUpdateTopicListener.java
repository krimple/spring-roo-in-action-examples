package org.rooinaction.coursemanager.messaging;


public class JmsCourseCatalogUpdateTopicListener {

    public void onMessage(Object message) {
        System.out.println("JMS message received: " + message);
    }
}
