// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package org.rooinaction.coursemanager.web.request;
import com.google.web.bindery.requestfactory.shared.InstanceRequest;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.ServiceName;
import java.util.List;
import org.rooinaction.coursemanager.web.proxy.OfferingProxy;
import org.springframework.roo.addon.gwt.RooGwtRequest;

@RooGwtRequest("org.rooinaction.coursemanager.model.Offering")
@ServiceName("org.rooinaction.coursemanager.model.Offering")
public interface OfferingRequest_Roo_Gwt extends RequestContext {

    abstract Request<Long> countOfferings();

    abstract Request<List<OfferingProxy>> findAllOfferings();

    abstract Request<List<OfferingProxy>> findOfferingEntries(int firstResult, int maxResults);

    abstract Request<OfferingProxy> findOffering(Long id);

    abstract InstanceRequest<OfferingProxy, Void> persist();

    abstract InstanceRequest<OfferingProxy, Void> remove();
}
