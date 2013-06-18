// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package org.rooinaction.coursemanager.web.request;
import com.google.web.bindery.requestfactory.shared.InstanceRequest;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.ServiceName;
import java.util.List;
import org.rooinaction.coursemanager.web.proxy.StudentProxy;
import org.springframework.roo.addon.gwt.RooGwtRequest;

@RooGwtRequest("org.rooinaction.coursemanager.model.Student")
@ServiceName("org.rooinaction.coursemanager.model.Student")
public interface StudentRequest_Roo_Gwt extends RequestContext {

    abstract Request<Long> countStudents();

    abstract Request<List<StudentProxy>> findAllStudents();

    abstract Request<List<StudentProxy>> findStudentEntries(int firstResult, int maxResults);

    abstract Request<StudentProxy> findStudent(Long id);

    abstract InstanceRequest<StudentProxy, Void> persist();

    abstract InstanceRequest<StudentProxy, Void> remove();
}
