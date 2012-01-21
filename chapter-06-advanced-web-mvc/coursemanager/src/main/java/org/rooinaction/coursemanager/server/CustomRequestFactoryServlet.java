package org.rooinaction.coursemanager.server;

import com.google.web.bindery.requestfactory.server.DefaultExceptionHandler;
import com.google.web.bindery.requestfactory.server.ExceptionHandler;
import com.google.web.bindery.requestfactory.server.RequestFactoryServlet;
import com.google.web.bindery.requestfactory.server.ServiceLayerDecorator;

public class CustomRequestFactoryServlet extends RequestFactoryServlet {

	public CustomRequestFactoryServlet() {
		this(new DefaultExceptionHandler(), new CustomServiceLayerDecorator());
	}

	public CustomRequestFactoryServlet(ExceptionHandler exceptionHandler, ServiceLayerDecorator... serviceDecorators) {
		super(exceptionHandler, serviceDecorators);
	}
}
