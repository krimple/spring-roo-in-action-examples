// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package org.rooinaction.coursemanager.web.gwt.requests;

import com.google.web.bindery.requestfactory.shared.InstanceRequest;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.ServiceName;
import java.util.Date;
import org.rooinaction.coursemanager.web.gwt.proxies.OfferingProxy;
import org.rooinaction.coursemanager.web.gwt.proxies.StudentProxy;
import org.springframework.roo.addon.gwt.RooGwtRequest;

@RooGwtRequest(value = "org.rooinaction.coursemanager.model.Registration", exclude = { "clear", "entityManager", "equals", "flush", "hashCode", "merge", "toString" })
@ServiceName("org.rooinaction.coursemanager.model.Registration")
public interface RegistrationRequest extends RequestContext {

    abstract Request<java.lang.Long> countRegistrations();

    abstract Request<java.util.List<org.rooinaction.coursemanager.web.gwt.proxies.RegistrationProxy>> findAllRegistrations();

    abstract Request<java.util.List<org.rooinaction.coursemanager.web.gwt.proxies.RegistrationProxy>> findRegistrationEntries(int firstResult, int maxResults);

    abstract Request<org.rooinaction.coursemanager.web.gwt.proxies.RegistrationProxy> findRegistration(Long id);

    abstract InstanceRequest<org.rooinaction.coursemanager.web.gwt.proxies.RegistrationProxy, java.lang.Void> persist();

    abstract InstanceRequest<org.rooinaction.coursemanager.web.gwt.proxies.RegistrationProxy, java.lang.Void> remove();
}
