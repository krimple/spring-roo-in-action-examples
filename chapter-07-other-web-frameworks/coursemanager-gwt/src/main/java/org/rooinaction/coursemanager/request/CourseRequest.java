// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package org.rooinaction.coursemanager.request;

import com.google.web.bindery.requestfactory.shared.InstanceRequest;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.ServiceName;
import org.springframework.roo.addon.gwt.RooGwtRequest;

@RooGwtRequest("org.rooinaction.coursemanager.shared.model.Course")
@ServiceName("org.rooinaction.coursemanager.shared.model.Course")
public interface CourseRequest extends RequestContext {

    abstract Request<java.lang.Long> countCourses();

    abstract Request<java.util.List<org.rooinaction.coursemanager.proxy.CourseProxy>> findAllCourses();

    abstract Request<java.util.List<org.rooinaction.coursemanager.proxy.CourseProxy>> findCourseEntries(int firstResult, int maxResults);

    abstract Request<org.rooinaction.coursemanager.proxy.CourseProxy> findCourse(Long id);

    abstract InstanceRequest<org.rooinaction.coursemanager.proxy.CourseProxy, java.lang.Void> persist();

    abstract InstanceRequest<org.rooinaction.coursemanager.proxy.CourseProxy, java.lang.Void> remove();
}
