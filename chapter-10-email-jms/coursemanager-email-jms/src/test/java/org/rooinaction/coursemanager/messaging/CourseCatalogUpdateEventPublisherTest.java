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
 * @author Srini
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:/META-INF/spring/applicationContext.xml",
		"classpath:/META-INF/spring/applicationContext-jms.xml"
	})
public class CourseCatalogUpdateEventPublisherTest {

	private static final Log log = LogFactory.getLog(CourseCatalogUpdateEventPublisherTest.class);

    @Autowired
    private transient JmsTemplate jmsTopicTemplate;

    @Test
	public void verifyCourseCatalogUpdateEventIsSuccessful() {

    	String courseCatalogEvent = "Test CourseCatalogEvent Message.";

    	log.debug("CourseCatalogEvent: " + courseCatalogEvent);

    	// Post the message to JMS Destination
    	sendMessage(courseCatalogEvent);
    }

	private void sendMessage(Object messageObject) {
		jmsTopicTemplate.convertAndSend(messageObject);
    }
}
