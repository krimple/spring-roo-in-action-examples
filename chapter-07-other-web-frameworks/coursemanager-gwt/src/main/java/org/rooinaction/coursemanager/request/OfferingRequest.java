// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package org.rooinaction.coursemanager.request;

import com.google.web.bindery.requestfactory.shared.InstanceRequest;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.ServiceName;
import org.springframework.roo.addon.gwt.RooGwtRequest;

@RooGwtRequest("org.rooinaction.coursemanager.shared.model.Offering")
@ServiceName("org.rooinaction.coursemanager.shared.model.Offering")
public interface OfferingRequest extends RequestContext {

    abstract Request<java.lang.Long> countOfferings();

    abstract Request<java.util.List<org.rooinaction.coursemanager.proxy.OfferingProxy>> findAllOfferings();

    abstract Request<java.util.List<org.rooinaction.coursemanager.proxy.OfferingProxy>> findOfferingEntries(int firstResult, int maxResults);

    abstract Request<org.rooinaction.coursemanager.proxy.OfferingProxy> findOffering(Long id);

    abstract InstanceRequest<org.rooinaction.coursemanager.proxy.OfferingProxy, java.lang.Void> persist();

    abstract InstanceRequest<org.rooinaction.coursemanager.proxy.OfferingProxy, java.lang.Void> remove();
}
