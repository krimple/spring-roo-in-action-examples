package com.rooinaction.cmsapp.messaging;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rooinaction.cmsapp.messaging.EventPublisher;

/**
 * @author Srini
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath:/META-INF/spring/applicationContext.xml",
//		"classpath:/META-INF/spring/applicationContext-jms.xml",
//		"classpath:/META-INF/spring/eventsdemo1-context.xml"})
@ContextConfiguration(locations = {
		"classpath:/META-INF/spring/applicationContext.xml",
		"classpath:/META-INF/spring/applicationContext-jms.xml"
	})
public class CourseCatalogUpdatePublisherTest {
	
	@Autowired
	private EventPublisher pub;

	@Test
	public void testCourseCatalogUpdateEvent() {
	    pub.publish("Test Message 1");
	    pub.publish("Test Message 2");
	}

}
