package org.rooinaction.coursemanager.server.locator;

import com.google.web.bindery.requestfactory.shared.Locator;
import org.rooinaction.coursemanager.shared.model.Tag;
import org.springframework.roo.addon.gwt.RooGwtLocator;
import org.springframework.stereotype.Component;

@RooGwtLocator("org.rooinaction.coursemanager.shared.model.Tag")
@Component
public class TagLocator extends Locator<Tag, Long> {

    public Tag create(Class<? extends org.rooinaction.coursemanager.shared.model.Tag> clazz) {
        return new Tag();
    }

    public Tag find(Class<? extends org.rooinaction.coursemanager.shared.model.Tag> clazz, Long id) {
        return Tag.findTag(id);
    }

    public Class<org.rooinaction.coursemanager.shared.model.Tag> getDomainType() {
        return Tag.class;
    }

    public Long getId(Tag tag) {
        return tag.getId();
    }

    public Class<java.lang.Long> getIdType() {
        return Long.class;
    }

    public Object getVersion(Tag tag) {
        return tag.getVersion();
    }
}
