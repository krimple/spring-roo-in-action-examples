package com.rooinaction.cmsapp.messaging;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author Srini
 */
@Component
public class CourseCatalogUpdateEventPublisher implements ApplicationContextAware {

    private ApplicationContext ctx;

    public void setApplicationContext(ApplicationContext applicationContext)
            throws BeansException {
        this.ctx = applicationContext;
    }

    public void publish(String message) {
        ctx.publishEvent(new CourseCatalogUpdateEvent(this, message));
    }

}

