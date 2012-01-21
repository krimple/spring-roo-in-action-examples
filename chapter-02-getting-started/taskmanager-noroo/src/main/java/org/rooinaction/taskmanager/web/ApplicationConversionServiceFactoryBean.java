package org.rooinaction.taskmanager.web;

import org.rooinaction.taskmanager.model.Task;
import org.rooinaction.taskmanager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.support.FormattingConversionServiceFactoryBean;

/**
 * A central place to register application converters and formatters. 
 */
@Configurable
public class ApplicationConversionServiceFactoryBean extends FormattingConversionServiceFactoryBean {

    @Autowired
    TaskService taskService;

    @Override
	protected void installFormatters(FormatterRegistry registry) {
		super.installFormatters(registry);
		// Register application converters and formatters
	}

    public void installLabelConverters(FormatterRegistry registry) {
        registry.addConverter(getTaskToStringConverter());
        registry.addConverter(getIdToTaskConverter());
        registry.addConverter(getStringToTaskConverter());
    }

    public Converter<Long, Task> getIdToTaskConverter() {
        return new Converter<Long, Task>() {
            public Task convert(Long id) {
                return taskService.findTask(id);
            }
        };
    }

    public Converter<String, Task> getStringToTaskConverter() {
        return new Converter<String, Task>() {
            public Task convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), Task.class);
            }
        };
    }

    public Converter<Task, String> getTaskToStringConverter() {
        return new Converter<Task, String>() {
            public String convert(Task task) {
                return task.toString();
            }
        };
    }

    public void afterPropertiesSet() {
        super.afterPropertiesSet();
        installLabelConverters(getObject());
    }
}
