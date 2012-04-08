// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package org.rooinaction.coursemanager.proxy;

import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyForName;
import java.util.Date;
import org.springframework.roo.addon.gwt.RooGwtProxy;

@ProxyForName(value = "org.rooinaction.coursemanager.shared.model.Offering", locator = "org.rooinaction.coursemanager.server.locator.OfferingLocator")
@RooGwtProxy(value = "org.rooinaction.coursemanager.shared.model.Offering", readOnly = { "version", "id" }, scaffold = true)
public interface OfferingProxy extends EntityProxy {

    abstract Long getId();

    abstract Date getRunDate();

    abstract void setRunDate(Date runDate);

    abstract Integer getVersion();
}
