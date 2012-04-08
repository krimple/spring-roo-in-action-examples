package org.rooinaction.coursemanager.messaging;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class JmsCourseRegistrationWaitListQueueListener {

	private static final Log log = LogFactory.getLog(JmsCourseRegistrationWaitListQueueListener.class);

    public void onMessage(Object message) {
        log.debug("JMS message received: " + message);
    }
}
