package com.rooinaction.cmsapp.messaging;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rooinaction.cmsapp.messaging.CourseCatalogUpdateEventPublisher;

/**
 * @author Srini
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:/META-INF/spring/applicationContext.xml",
		"classpath:/META-INF/spring/applicationContext-jms.xml"
	})
public class CourseCatalogUpdateEventPublisherTest {
	
	@Autowired
	private CourseCatalogUpdateEventPublisher eventPublisher;

	@Test
	public void testCourseCatalogUpdateEvent() {
		eventPublisher.publish("Test Message 1");
		eventPublisher.publish("Test Message 2");
	}

}

