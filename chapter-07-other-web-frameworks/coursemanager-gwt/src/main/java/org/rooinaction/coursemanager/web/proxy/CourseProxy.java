// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package org.rooinaction.coursemanager.web.proxy;
import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyForName;
import java.math.BigDecimal;
import org.springframework.roo.addon.gwt.RooGwtProxy;

@ProxyForName(value = "org.rooinaction.coursemanager.model.Course", locator = "org.rooinaction.coursemanager.server.locator.CourseLocator")
@RooGwtProxy(value = "org.rooinaction.coursemanager.model.Course", readOnly = { "version", "id" }, scaffold = true)
public interface CourseProxy extends EntityProxy {

    abstract Long getId();

    abstract String getName();

    abstract void setName(String name);

    abstract String getDescription();

    abstract void setDescription(String description);

    abstract BigDecimal getListPrice();

    abstract void setListPrice(BigDecimal listPrice);

    abstract Integer getMaxiumumCapacity();

    abstract void setMaxiumumCapacity(Integer maxiumumCapacity);

    abstract Integer getVersion();
}
