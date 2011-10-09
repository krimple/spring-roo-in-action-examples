// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package org.rooinaction.taskmanager.web;

import java.lang.Long;
import java.lang.String;
import org.rooinaction.taskmanager.model.Task;
import org.rooinaction.taskmanager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;

privileged aspect ApplicationConversionServiceFactoryBean_Roo_ConversionService {
    
    declare @type: ApplicationConversionServiceFactoryBean: @Configurable;
    
    @Autowired
    TaskService ApplicationConversionServiceFactoryBean.taskService;
    
    public Converter<Task, String> ApplicationConversionServiceFactoryBean.getTaskToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<org.rooinaction.taskmanager.model.Task, java.lang.String>() {
            public String convert(Task task) {
                return new StringBuilder().append(task.getTask()).toString();
            }
        };
    }
    
    public Converter<Long, Task> ApplicationConversionServiceFactoryBean.getIdToTaskConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, org.rooinaction.taskmanager.model.Task>() {
            public org.rooinaction.taskmanager.model.Task convert(java.lang.Long id) {
                return taskService.findTask(id);
            }
        };
    }
    
    public Converter<String, Task> ApplicationConversionServiceFactoryBean.getStringToTaskConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, org.rooinaction.taskmanager.model.Task>() {
            public org.rooinaction.taskmanager.model.Task convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), Task.class);
            }
        };
    }
    
    public void ApplicationConversionServiceFactoryBean.installLabelConverters(FormatterRegistry registry) {
        registry.addConverter(getTaskToStringConverter());
        registry.addConverter(getIdToTaskConverter());
        registry.addConverter(getStringToTaskConverter());
    }
    
    public void ApplicationConversionServiceFactoryBean.afterPropertiesSet() {
        super.afterPropertiesSet();
        installLabelConverters(getObject());
    }
    
}
