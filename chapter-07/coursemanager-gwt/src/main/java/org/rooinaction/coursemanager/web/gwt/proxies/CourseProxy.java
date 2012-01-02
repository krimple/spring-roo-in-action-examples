// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package org.rooinaction.coursemanager.web.gwt.proxies;

import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyForName;
import java.math.BigDecimal;
import java.util.Set;
import org.rooinaction.coursemanager.shared.CourseTypeEnum;
import org.springframework.roo.addon.gwt.RooGwtProxy;

@ProxyForName(value = "org.rooinaction.coursemanager.model.Course", locator = "org.rooinaction.coursemanager.server.locator.CourseLocator")
@RooGwtProxy(value = "org.rooinaction.coursemanager.model.Course", readOnly = { "version", "id" }, scaffold = true)
public interface CourseProxy extends EntityProxy {

    abstract Long getId();

    abstract String getName();

    abstract void setName(String name);

    abstract String getDescription();

    abstract void setDescription(String description);

    abstract BigDecimal getCost();

    abstract void setCost(BigDecimal cost);

    abstract Integer getMaximumCapacity();

    abstract void setMaximumCapacity(Integer maximumCapacity);

    abstract CourseTypeEnum getCourseType();

    abstract void setCourseType(CourseTypeEnum courseType);

    abstract TrainingProgramProxy getTrainingProgram();

    abstract void setTrainingProgram(TrainingProgramProxy trainingProgram);

    abstract Set<org.rooinaction.coursemanager.web.gwt.proxies.TagProxy> getTags();

    abstract void setTags(Set<org.rooinaction.coursemanager.web.gwt.proxies.TagProxy> tags);

    abstract Set<org.rooinaction.coursemanager.web.gwt.proxies.OfferingProxy> getOfferings();

    abstract void setOfferings(Set<org.rooinaction.coursemanager.web.gwt.proxies.OfferingProxy> offerings);

    abstract Integer getVersion();
}
