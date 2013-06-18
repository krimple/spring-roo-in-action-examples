// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package org.rooinaction.coursemanager.web.request;
import com.google.web.bindery.requestfactory.shared.InstanceRequest;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.ServiceName;
import java.util.List;
import org.rooinaction.coursemanager.web.proxy.CourseProxy;
import org.springframework.roo.addon.gwt.RooGwtRequest;

@RooGwtRequest("org.rooinaction.coursemanager.model.Course")
@ServiceName("org.rooinaction.coursemanager.model.Course")
public interface CourseRequest_Roo_Gwt extends RequestContext {

    abstract Request<Long> countCourses();

    abstract Request<List<CourseProxy>> findAllCourses();

    abstract Request<List<CourseProxy>> findCourseEntries(int firstResult, int maxResults);

    abstract Request<CourseProxy> findCourse(Long id);

    abstract InstanceRequest<CourseProxy, Void> persist();

    abstract InstanceRequest<CourseProxy, Void> remove();
}
