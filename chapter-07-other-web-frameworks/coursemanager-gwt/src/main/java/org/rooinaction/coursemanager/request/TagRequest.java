// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package org.rooinaction.coursemanager.request;

import com.google.web.bindery.requestfactory.shared.InstanceRequest;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.ServiceName;
import org.springframework.roo.addon.gwt.RooGwtRequest;

@RooGwtRequest("org.rooinaction.coursemanager.shared.model.Tag")
@ServiceName("org.rooinaction.coursemanager.shared.model.Tag")
public interface TagRequest extends RequestContext {

    abstract Request<java.lang.Long> countTags();

    abstract Request<java.util.List<org.rooinaction.coursemanager.proxy.TagProxy>> findAllTags();

    abstract Request<java.util.List<org.rooinaction.coursemanager.proxy.TagProxy>> findTagEntries(int firstResult, int maxResults);

    abstract Request<org.rooinaction.coursemanager.proxy.TagProxy> findTag(Long id);

    abstract InstanceRequest<org.rooinaction.coursemanager.proxy.TagProxy, java.lang.Void> persist();

    abstract InstanceRequest<org.rooinaction.coursemanager.proxy.TagProxy, java.lang.Void> remove();
}
