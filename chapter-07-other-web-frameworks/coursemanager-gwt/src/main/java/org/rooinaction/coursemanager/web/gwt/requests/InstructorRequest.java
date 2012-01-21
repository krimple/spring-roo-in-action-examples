// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package org.rooinaction.coursemanager.web.gwt.requests;

import com.google.web.bindery.requestfactory.shared.InstanceRequest;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.ServiceName;
import org.springframework.roo.addon.gwt.RooGwtRequest;

@RooGwtRequest(value = "org.rooinaction.coursemanager.model.Instructor", exclude = { "clear", "entityManager", "equals", "flush", "hashCode", "merge", "toString" })
@ServiceName("org.rooinaction.coursemanager.model.Instructor")
public interface InstructorRequest extends RequestContext {

    abstract Request<java.lang.Long> countInstructors();

    abstract Request<java.util.List<org.rooinaction.coursemanager.web.gwt.proxies.InstructorProxy>> findAllInstructors();

    abstract Request<java.util.List<org.rooinaction.coursemanager.web.gwt.proxies.InstructorProxy>> findInstructorEntries(int firstResult, int maxResults);

    abstract Request<org.rooinaction.coursemanager.web.gwt.proxies.InstructorProxy> findInstructor(Long id);

    abstract InstanceRequest<org.rooinaction.coursemanager.web.gwt.proxies.InstructorProxy, java.lang.Void> persist();

    abstract InstanceRequest<org.rooinaction.coursemanager.web.gwt.proxies.InstructorProxy, java.lang.Void> remove();
}
