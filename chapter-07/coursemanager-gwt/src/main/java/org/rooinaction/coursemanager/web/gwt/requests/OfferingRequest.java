// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package org.rooinaction.coursemanager.web.gwt.requests;

import com.google.web.bindery.requestfactory.shared.InstanceRequest;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.ServiceName;
import org.rooinaction.coursemanager.web.gwt.proxies.RegistrationProxy;
import org.springframework.roo.addon.gwt.RooGwtRequest;

@RooGwtRequest(value = "org.rooinaction.coursemanager.model.Offering", exclude = { "clear", "entityManager", "equals", "flush", "hashCode", "merge", "toString" })
@ServiceName("org.rooinaction.coursemanager.model.Offering")
public interface OfferingRequest extends RequestContext {

    abstract Request<java.lang.Long> countOfferings();

    abstract Request<java.util.List<org.rooinaction.coursemanager.web.gwt.proxies.OfferingProxy>> findAllOfferings();

    abstract Request<java.util.List<org.rooinaction.coursemanager.web.gwt.proxies.OfferingProxy>> findOfferingEntries(int firstResult, int maxResults);

    abstract Request<org.rooinaction.coursemanager.web.gwt.proxies.OfferingProxy> findOffering(Long id);

    abstract InstanceRequest<org.rooinaction.coursemanager.web.gwt.proxies.OfferingProxy, java.lang.Void> persist();

    abstract InstanceRequest<org.rooinaction.coursemanager.web.gwt.proxies.OfferingProxy, java.lang.Void> remove();
}
