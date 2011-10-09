package org.rooinaction.taskmanager.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooEntity
public class Task {
	
    @NotNull
    @Size(max = 40)
    private String task;

    @Value("false")
    private Boolean completed;
    
}
