package org.rooina.coursemanager.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.webflow.execution.FlowExecutionException;
import org.springframework.webflow.execution.FlowExecutionListenerAdapter;
import org.springframework.webflow.execution.RequestContext;

public class LoggingFlowExecutionListener extends FlowExecutionListenerAdapter {
	Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public void exceptionThrown(RequestContext context,
			FlowExecutionException exception) {
		super.exceptionThrown(context, exception);
		logger.error("Webflow " + context.getActiveFlow().getId()
				+ " threw exception in " + context.getCurrentState().getId(),
				exception);
	}

}
