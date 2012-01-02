// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package org.rooinaction.coursemanager.web.gwt.proxies;

import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyForName;
import java.util.Date;
import java.util.Set;
import org.springframework.roo.addon.gwt.RooGwtProxy;

@ProxyForName(value = "org.rooinaction.coursemanager.model.Offering", locator = "org.rooinaction.coursemanager.server.locator.OfferingLocator")
@RooGwtProxy(value = "org.rooinaction.coursemanager.model.Offering", readOnly = { "version", "id" }, scaffold = true)
public interface OfferingProxy extends EntityProxy {

    abstract Long getId();

    abstract Date getRunDate();

    abstract void setRunDate(Date runDate);

    abstract CourseProxy getCourse();

    abstract void setCourse(CourseProxy course);

    abstract Set<org.rooinaction.coursemanager.web.gwt.proxies.RegistrationProxy> getRegistrations();

    abstract void setRegistrations(Set<org.rooinaction.coursemanager.web.gwt.proxies.RegistrationProxy> registrations);

    abstract InstructorProxy getInstructor();

    abstract void setInstructor(InstructorProxy instructor);

    abstract Integer getVersion();
}
