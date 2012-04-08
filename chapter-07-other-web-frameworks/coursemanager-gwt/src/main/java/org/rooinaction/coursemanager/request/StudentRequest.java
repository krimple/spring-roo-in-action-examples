// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package org.rooinaction.coursemanager.request;

import com.google.web.bindery.requestfactory.shared.InstanceRequest;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.ServiceName;
import org.springframework.roo.addon.gwt.RooGwtRequest;

@RooGwtRequest("org.rooinaction.coursemanager.shared.model.Student")
@ServiceName("org.rooinaction.coursemanager.shared.model.Student")
public interface StudentRequest extends RequestContext {

    abstract Request<java.lang.Long> countStudents();

    abstract Request<java.util.List<org.rooinaction.coursemanager.proxy.StudentProxy>> findAllStudents();

    abstract Request<java.util.List<org.rooinaction.coursemanager.proxy.StudentProxy>> findStudentEntries(int firstResult, int maxResults);

    abstract Request<org.rooinaction.coursemanager.proxy.StudentProxy> findStudent(Long id);

    abstract InstanceRequest<org.rooinaction.coursemanager.proxy.StudentProxy, java.lang.Void> persist();

    abstract InstanceRequest<org.rooinaction.coursemanager.proxy.StudentProxy, java.lang.Void> remove();
}
