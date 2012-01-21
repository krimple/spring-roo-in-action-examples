package com.rooinaction.cmsapp.email;

import org.springframework.context.ApplicationEvent;

/**
 * @author Srini
 */
public class RegistrationNotificationEvent extends ApplicationEvent {

	private static final long serialVersionUID = -6786033091498612636L;
    private String message;

    public RegistrationNotificationEvent(Object source, String message) {
        super(source);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
