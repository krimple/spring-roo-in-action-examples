package org.rooinaction.coursemanager.server.locator;
import com.google.web.bindery.requestfactory.shared.Locator;
import org.rooinaction.coursemanager.model.Instructor;
import org.springframework.roo.addon.gwt.RooGwtLocator;
import org.springframework.stereotype.Component;

@RooGwtLocator("org.rooinaction.coursemanager.model.Instructor")
@Component
public class InstructorLocator extends Locator<Instructor, Long> {

    public Instructor create(Class<? extends org.rooinaction.coursemanager.model.Instructor> clazz) {
        return new Instructor();
    }

    public Instructor find(Class<? extends org.rooinaction.coursemanager.model.Instructor> clazz, Long id) {
        return Instructor.findInstructor(id);
    }

    public Class<Instructor> getDomainType() {
        return Instructor.class;
    }

    public Long getId(Instructor instructor) {
        return instructor.getId();
    }

    public Class<Long> getIdType() {
        return Long.class;
    }

    public Object getVersion(Instructor instructor) {
        return instructor.getVersion();
    }
}
