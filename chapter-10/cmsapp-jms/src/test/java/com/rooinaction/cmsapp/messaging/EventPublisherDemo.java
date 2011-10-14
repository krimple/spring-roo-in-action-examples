package com.rooinaction.cmsapp.messaging;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rooinaction.cmsapp.messaging.EventPublisher;

/**
 * @author Srini
 */
public class EventPublisherDemo {
	
    public static void main(String[] args) {
        new EventPublisherDemo().run();
    }

	private void run() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
                "/META-INF/spring/eventsdemo1-context.xml");

        EventPublisher pub = (EventPublisher) ctx.getBean("publisher");
        pub.publish("Hello World!");
        pub.publish("The quick brown fox jumped over the lazy dog");
	}

}
