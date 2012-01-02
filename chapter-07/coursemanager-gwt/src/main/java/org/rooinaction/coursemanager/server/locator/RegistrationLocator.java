package org.rooinaction.coursemanager.server.locator;

import com.google.web.bindery.requestfactory.shared.Locator;
import org.rooinaction.coursemanager.model.Registration;
import org.springframework.roo.addon.gwt.RooGwtLocator;
import org.springframework.stereotype.Component;

@RooGwtLocator("org.rooinaction.coursemanager.model.Registration")
@Component
public class RegistrationLocator extends Locator<Registration, Long> {

    public Registration create(Class<? extends org.rooinaction.coursemanager.model.Registration> clazz) {
        return new Registration();
    }

    public Registration find(Class<? extends org.rooinaction.coursemanager.model.Registration> clazz, Long id) {
        return Registration.findRegistration(id);
    }

    public Class<org.rooinaction.coursemanager.model.Registration> getDomainType() {
        return Registration.class;
    }

    public Long getId(Registration registration) {
        return registration.getId();
    }

    public Class<java.lang.Long> getIdType() {
        return Long.class;
    }

    public Object getVersion(Registration registration) {
        return registration.getVersion();
    }
}
