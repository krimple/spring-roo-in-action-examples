// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package org.rooinaction.coursemanager.request;

import com.google.web.bindery.requestfactory.shared.InstanceRequest;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.ServiceName;
import org.springframework.roo.addon.gwt.RooGwtRequest;

@RooGwtRequest("org.rooinaction.coursemanager.shared.model.Instructor")
@ServiceName("org.rooinaction.coursemanager.shared.model.Instructor")
public interface InstructorRequest extends RequestContext {

    abstract Request<java.lang.Long> countInstructors();

    abstract Request<java.util.List<org.rooinaction.coursemanager.proxy.InstructorProxy>> findAllInstructors();

    abstract Request<java.util.List<org.rooinaction.coursemanager.proxy.InstructorProxy>> findInstructorEntries(int firstResult, int maxResults);

    abstract Request<org.rooinaction.coursemanager.proxy.InstructorProxy> findInstructor(Long id);

    abstract InstanceRequest<org.rooinaction.coursemanager.proxy.InstructorProxy, java.lang.Void> persist();

    abstract InstanceRequest<org.rooinaction.coursemanager.proxy.InstructorProxy, java.lang.Void> remove();
}
