// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package org.rooinaction.coursemanager.proxy;

import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyForName;
import org.springframework.roo.addon.gwt.RooGwtProxy;

@ProxyForName(value = "org.rooinaction.coursemanager.shared.model.TrainingProgram", locator = "org.rooinaction.coursemanager.server.locator.TrainingProgramLocator")
@RooGwtProxy(value = "org.rooinaction.coursemanager.shared.model.TrainingProgram", readOnly = { "version", "id" }, scaffold = true)
public interface TrainingProgramProxy extends EntityProxy {

    abstract Long getId();

    abstract String getName();

    abstract void setName(String name);

    abstract Integer getVersion();
}
