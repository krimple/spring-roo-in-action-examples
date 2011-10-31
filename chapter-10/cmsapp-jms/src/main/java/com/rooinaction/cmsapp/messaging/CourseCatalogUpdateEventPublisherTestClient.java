package com.rooinaction.cmsapp.messaging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Srini
 */
@Component
public class CourseCatalogUpdateEventPublisherTestClient {
	
	@Autowired
	private CourseCatalogUpdateEventPublisher eventPublisher;

	public void testCourseCatalogUpdateEvent() {
		eventPublisher.publish("Test Message 1");
		eventPublisher.publish("Test Message 2");
	}

}
