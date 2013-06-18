// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package org.rooinaction.coursemanager.web.request;
import com.google.web.bindery.requestfactory.shared.InstanceRequest;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.ServiceName;
import java.util.List;
import org.rooinaction.coursemanager.web.proxy.InstructorProxy;
import org.springframework.roo.addon.gwt.RooGwtRequest;

@RooGwtRequest("org.rooinaction.coursemanager.model.Instructor")
@ServiceName("org.rooinaction.coursemanager.model.Instructor")
public interface InstructorRequest_Roo_Gwt extends RequestContext {

    abstract Request<Long> countInstructors();

    abstract Request<List<InstructorProxy>> findAllInstructors();

    abstract Request<List<InstructorProxy>> findInstructorEntries(int firstResult, int maxResults);

    abstract Request<InstructorProxy> findInstructor(Long id);

    abstract InstanceRequest<InstructorProxy, Void> persist();

    abstract InstanceRequest<InstructorProxy, Void> remove();
}
