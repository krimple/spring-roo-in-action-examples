package org.rooina.coursemanager.web;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

public class FullTraceMappingExceptionResolver extends
		SimpleMappingExceptionResolver {

	@Override
	protected ModelAndView getModelAndView(String viewName, Exception ex) {
		// TODO Auto-generated method stub
		ModelAndView modelAndView =  super.getModelAndView(viewName, ex);
		String stackTrace = ExceptionUtils.getFullStackTrace(ExceptionUtils.getRootCause(ex));
		modelAndView.addObject("rootCause", stackTrace);
		return modelAndView;
	}
}
