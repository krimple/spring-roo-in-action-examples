package org.rooinaction.coursemanager.messaging;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class JmsCourseCatalogUpdateTopicListener {
	
	private static final Log log = LogFactory.getLog(JmsCourseCatalogUpdateTopicListener.class);

    public void onMessage(Object message) {
        log.debug("JMS message received: " + message);
    }
}
