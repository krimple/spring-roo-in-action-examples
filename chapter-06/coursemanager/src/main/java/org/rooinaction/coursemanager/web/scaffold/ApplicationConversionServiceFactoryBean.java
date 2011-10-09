package org.rooinaction.coursemanager.web.scaffold;

import org.rooinaction.coursemanager.model.Course;
import org.rooinaction.coursemanager.types.USPhoneNumber;
import org.rooinaction.coursemanager.types.USPhoneNumberFormatter;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.support.FormattingConversionServiceFactoryBean;
import org.springframework.roo.addon.web.mvc.controller.RooConversionService;
        
/**
 * A central place to register application Converters and Formatters. 
 */
@RooConversionService
public class ApplicationConversionServiceFactoryBean extends FormattingConversionServiceFactoryBean {

	@Override
	protected void installFormatters(FormatterRegistry registry) {
		registry.addFormatterForFieldType(USPhoneNumber.class,
                new USPhoneNumberFormatter());
        super.installFormatters(registry);
	}
}
