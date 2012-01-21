// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package org.rooinaction.coursemanager.web.gwt.requests;

import com.google.web.bindery.requestfactory.shared.InstanceRequest;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.ServiceName;
import java.util.List;
import org.rooinaction.coursemanager.web.gwt.proxies.OfferingProxy;
import org.springframework.roo.addon.gwt.RooGwtRequest;

@RooGwtRequest(value = "org.rooinaction.coursemanager.model.Student", exclude = { "clear", "entityManager", "equals", "flush", "hashCode", "merge", "toString" })
@ServiceName("org.rooinaction.coursemanager.model.Student")
public interface StudentRequest extends RequestContext {

    abstract Request<java.lang.Long> countStudents();

    abstract Request<java.util.List<org.rooinaction.coursemanager.web.gwt.proxies.StudentProxy>> findAllStudents();

    abstract Request<java.util.List<org.rooinaction.coursemanager.web.gwt.proxies.StudentProxy>> findStudentEntries(int firstResult, int maxResults);

    abstract Request<org.rooinaction.coursemanager.web.gwt.proxies.StudentProxy> findStudent(Long id);

    abstract InstanceRequest<org.rooinaction.coursemanager.web.gwt.proxies.StudentProxy, java.lang.Void> persist();

    abstract InstanceRequest<org.rooinaction.coursemanager.web.gwt.proxies.StudentProxy, java.lang.Void> remove();
}
