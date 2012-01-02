// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package org.rooinaction.coursemanager.web.gwt.proxies;

import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyForName;
import javax.persistence.Transient;
import org.springframework.roo.addon.gwt.RooGwtProxy;

@ProxyForName(value = "org.rooinaction.coursemanager.model.Instructor", locator = "org.rooinaction.coursemanager.server.locator.InstructorLocator")
@RooGwtProxy(value = "org.rooinaction.coursemanager.model.Instructor", readOnly = { "version", "id" }, scaffold = true)
public interface InstructorProxy extends EntityProxy {

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

    abstract String getTaxNumber();

    abstract void setTaxNumber(String taxNumber);
}
