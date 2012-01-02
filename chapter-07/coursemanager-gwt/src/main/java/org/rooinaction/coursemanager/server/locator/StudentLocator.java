package org.rooinaction.coursemanager.server.locator;

import com.google.web.bindery.requestfactory.shared.Locator;
import org.rooinaction.coursemanager.model.Student;
import org.springframework.roo.addon.gwt.RooGwtLocator;
import org.springframework.stereotype.Component;

@RooGwtLocator("org.rooinaction.coursemanager.model.Student")
@Component
public class StudentLocator extends Locator<Student, Long> {

    public Student create(Class<? extends org.rooinaction.coursemanager.model.Student> clazz) {
        return new Student();
    }

    public Student find(Class<? extends org.rooinaction.coursemanager.model.Student> clazz, Long id) {
        return Student.findStudent(id);
    }

    public Class<org.rooinaction.coursemanager.model.Student> getDomainType() {
        return Student.class;
    }

    public Long getId(Student student) {
        return student.getId();
    }

    public Class<java.lang.Long> getIdType() {
        return Long.class;
    }

    public Object getVersion(Student student) {
        return student.getVersion();
    }
}
