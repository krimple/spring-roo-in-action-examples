package org.rooinaction.coursemanager.server.locator;

import com.google.web.bindery.requestfactory.shared.Locator;
import org.rooinaction.coursemanager.shared.model.Offering;
import org.springframework.roo.addon.gwt.RooGwtLocator;
import org.springframework.stereotype.Component;

@RooGwtLocator("org.rooinaction.coursemanager.shared.model.Offering")
@Component
public class OfferingLocator extends Locator<Offering, Long> {

    public Offering create(Class<? extends org.rooinaction.coursemanager.shared.model.Offering> clazz) {
        return new Offering();
    }

    public Offering find(Class<? extends org.rooinaction.coursemanager.shared.model.Offering> clazz, Long id) {
        return Offering.findOffering(id);
    }

    public Class<org.rooinaction.coursemanager.shared.model.Offering> getDomainType() {
        return Offering.class;
    }

    public Long getId(Offering offering) {
        return offering.getId();
    }

    public Class<java.lang.Long> getIdType() {
        return Long.class;
    }

    public Object getVersion(Offering offering) {
        return offering.getVersion();
    }
}
