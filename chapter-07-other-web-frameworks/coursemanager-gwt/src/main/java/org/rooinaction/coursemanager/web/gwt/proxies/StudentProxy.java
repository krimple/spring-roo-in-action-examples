// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package org.rooinaction.coursemanager.web.gwt.proxies;

import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyForName;
import java.util.Set;
import javax.persistence.Transient;
import org.springframework.roo.addon.gwt.RooGwtProxy;

@ProxyForName(value = "org.rooinaction.coursemanager.model.Student", locator = "org.rooinaction.coursemanager.server.locator.StudentLocator")
@RooGwtProxy(value = "org.rooinaction.coursemanager.model.Student", readOnly = { "version", "id" }, scaffold = true)
public interface StudentProxy extends EntityProxy {

    abstract Long getId();

    @Transient
    abstract String getFullName();

    @Transient
    abstract void setFullName(String fullName);

    abstract String getFirstName();

    abstract void setFirstName(String firstName);

    abstract String getMiddleNameOrInitial();

    abstract void setMiddleNameOrInitial(String middleNameOrInitial);

    abstract String getLastName();

    abstract void setLastName(String lastName);

    abstract String getAddressLine1();

    abstract void setAddressLine1(String addressLine1);

    abstract String getAddressLine2();

    abstract void setAddressLine2(String addressLine2);

    abstract String getCity();

    abstract void setCity(String city);

    abstract String getStateCode();

    abstract void setStateCode(String stateCode);

    abstract String getPostalCode();

    abstract void setPostalCode(String postalCode);

    abstract String getEmailAddress();

    abstract void setEmailAddress(String emailAddress);

    abstract Integer getVersion();

    abstract String getEmergencyContactName();

    abstract void setEmergencyContactName(String emergencyContactName);

    abstract String getEmergencyContactInfo();

    abstract void setEmergencyContactInfo(String emergencyContactInfo);

    abstract String getDietaryRestrictions();

    abstract void setDietaryRestrictions(String dietaryRestrictions);

    abstract Set<org.rooinaction.coursemanager.web.gwt.proxies.RegistrationProxy> getRegistrations();

    abstract void setRegistrations(Set<org.rooinaction.coursemanager.web.gwt.proxies.RegistrationProxy> registrations);
}
