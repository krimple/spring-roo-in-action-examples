// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package org.rooinaction.coursemanager.proxy;

import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyForName;
import org.springframework.roo.addon.gwt.RooGwtProxy;

@ProxyForName(value = "org.rooinaction.coursemanager.shared.model.Registration", locator = "org.rooinaction.coursemanager.server.locator.RegistrationLocator")
@RooGwtProxy(value = "org.rooinaction.coursemanager.shared.model.Registration", readOnly = { "version", "id" }, scaffold = true)
public interface RegistrationProxy extends EntityProxy {

    abstract Long getId();

    abstract Integer getVersion();
}
