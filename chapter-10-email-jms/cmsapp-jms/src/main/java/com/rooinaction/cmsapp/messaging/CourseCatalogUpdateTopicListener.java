package com.rooinaction.cmsapp.messaging;

public class CourseCatalogUpdateTopicListener {

    public void onMessage(Object message) {
        System.out.println("**** JMS message received: " + message);
    }
}
