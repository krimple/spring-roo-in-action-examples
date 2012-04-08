package org.rooinaction.coursemanager.server.locator;

import com.google.web.bindery.requestfactory.shared.Locator;
import org.rooinaction.coursemanager.shared.model.Instructor;
import org.springframework.roo.addon.gwt.RooGwtLocator;
import org.springframework.stereotype.Component;

@RooGwtLocator("org.rooinaction.coursemanager.shared.model.Instructor")
@Component
public class InstructorLocator extends Locator<Instructor, Long> {

    public Instructor create(Class<? extends org.rooinaction.coursemanager.shared.model.Instructor> clazz) {
        return new Instructor();
    }

    public Instructor find(Class<? extends org.rooinaction.coursemanager.shared.model.Instructor> clazz, Long id) {
        return Instructor.findInstructor(id);
    }

    public Class<org.rooinaction.coursemanager.shared.model.Instructor> getDomainType() {
        return Instructor.class;
    }

    public Long getId(Instructor instructor) {
        return instructor.getId();
    }

    public Class<java.lang.Long> getIdType() {
        return Long.class;
    }

    public Object getVersion(Instructor instructor) {
        return instructor.getVersion();
    }
}
