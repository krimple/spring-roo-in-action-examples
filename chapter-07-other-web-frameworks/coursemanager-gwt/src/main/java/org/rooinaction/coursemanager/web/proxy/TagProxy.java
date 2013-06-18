// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package org.rooinaction.coursemanager.web.proxy;
import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyForName;
import org.springframework.roo.addon.gwt.RooGwtProxy;

@ProxyForName(value = "org.rooinaction.coursemanager.model.Tag", locator = "org.rooinaction.coursemanager.server.locator.TagLocator")
@RooGwtProxy(value = "org.rooinaction.coursemanager.model.Tag", readOnly = { "version", "id" }, scaffold = true)
public interface TagProxy extends EntityProxy {

    abstract Long getId();

    abstract String getTag();

    abstract void setTag(String tag);

    abstract String getDescription();

    abstract void setDescription(String description);

    abstract Integer getVersion();
}
