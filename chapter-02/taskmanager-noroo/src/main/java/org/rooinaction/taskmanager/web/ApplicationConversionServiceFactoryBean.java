package org.rooinaction.taskmanager.web;

import org.rooinaction.taskmanager.model.Task;
import org.rooinaction.taskmanager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.support.FormattingConversionServiceFactoryBean;
import org.springframework.roo.addon.web.mvc.controller.RooConversionService;

@Configurable
/**
 * A central place to register application converters and formatters. 
 */
@RooConversionService
public class ApplicationConversionServiceFactoryBean extends FormattingConversionServiceFactoryBean {

	@Override
	protected void installFormatters(FormatterRegistry registry) {
		super.installFormatters(registry);
		// Register application converters and formatters
	}

	@Autowired
    TaskService taskService;

	public Converter<Task, String> getTaskToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<org.rooinaction.taskmanager.model.Task, java.lang.String>() {
            public String convert(Task task) {
                return new StringBuilder().append(task.getTask()).toString();
            }
        };
    }

	public Converter<Long, Task> getIdToTaskConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, org.rooinaction.taskmanager.model.Task>() {
            public org.rooinaction.taskmanager.model.Task convert(java.lang.Long id) {
                return taskService.findTask(id);
            }
        };
    }

	public Converter<String, Task> getStringToTaskConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, org.rooinaction.taskmanager.model.Task>() {
            public org.rooinaction.taskmanager.model.Task convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), Task.class);
            }
        };
    }

	public void installLabelConverters(FormatterRegistry registry) {
        registry.addConverter(getTaskToStringConverter());
        registry.addConverter(getIdToTaskConverter());
        registry.addConverter(getStringToTaskConverter());
    }

	public void afterPropertiesSet() {
        super.afterPropertiesSet();
        installLabelConverters(getObject());
    }
}
