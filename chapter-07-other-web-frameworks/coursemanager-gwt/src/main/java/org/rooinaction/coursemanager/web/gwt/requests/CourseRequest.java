// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package org.rooinaction.coursemanager.web.gwt.requests;

import com.google.web.bindery.requestfactory.shared.InstanceRequest;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.ServiceName;
import org.rooinaction.coursemanager.model.CourseTypeEnum;
import org.rooinaction.coursemanager.web.gwt.proxies.OfferingProxy;
import org.rooinaction.coursemanager.web.gwt.proxies.TagProxy;
import org.springframework.roo.addon.gwt.RooGwtRequest;

@RooGwtRequest(value = "org.rooinaction.coursemanager.model.Course", exclude = { "clear", "entityManager", "equals", "flush", "hashCode", "merge", "toString" })
@ServiceName("org.rooinaction.coursemanager.model.Course")
public interface CourseRequest extends RequestContext {

    abstract Request<java.lang.Long> countCourses();

    abstract Request<java.util.List<org.rooinaction.coursemanager.web.gwt.proxies.CourseProxy>> findAllCourses();

    abstract Request<java.util.List<org.rooinaction.coursemanager.web.gwt.proxies.CourseProxy>> findCourseEntries(int firstResult, int maxResults);

    abstract Request<org.rooinaction.coursemanager.web.gwt.proxies.CourseProxy> findCourse(Long id);

    abstract InstanceRequest<org.rooinaction.coursemanager.web.gwt.proxies.CourseProxy, java.lang.Void> persist();

    abstract InstanceRequest<org.rooinaction.coursemanager.web.gwt.proxies.CourseProxy, java.lang.Void> remove();
}
