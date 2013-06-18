// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package org.rooinaction.coursemanager.web.request;
import com.google.web.bindery.requestfactory.shared.InstanceRequest;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.ServiceName;
import java.util.List;
import org.rooinaction.coursemanager.web.proxy.RegistrationProxy;
import org.springframework.roo.addon.gwt.RooGwtRequest;

@RooGwtRequest("org.rooinaction.coursemanager.model.Registration")
@ServiceName("org.rooinaction.coursemanager.model.Registration")
public interface RegistrationRequest_Roo_Gwt extends RequestContext {

    abstract Request<Long> countRegistrations();

    abstract Request<List<RegistrationProxy>> findAllRegistrations();

    abstract Request<List<RegistrationProxy>> findRegistrationEntries(int firstResult, int maxResults);

    abstract Request<RegistrationProxy> findRegistration(Long id);

    abstract InstanceRequest<RegistrationProxy, Void> persist();

    abstract InstanceRequest<RegistrationProxy, Void> remove();
}
