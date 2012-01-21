// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package org.rooinaction.coursemanager.web.gwt.requests;

import com.google.web.bindery.requestfactory.shared.InstanceRequest;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.ServiceName;
import org.rooinaction.coursemanager.web.gwt.proxies.CourseProxy;
import org.springframework.roo.addon.gwt.RooGwtRequest;

@RooGwtRequest(value = "org.rooinaction.coursemanager.model.Tag", exclude = { "clear", "entityManager", "equals", "flush", "hashCode", "merge", "toString" })
@ServiceName("org.rooinaction.coursemanager.model.Tag")
public interface TagRequest extends RequestContext {

    abstract Request<java.lang.Long> countTags();

    abstract Request<java.util.List<org.rooinaction.coursemanager.web.gwt.proxies.TagProxy>> findAllTags();

    abstract Request<java.util.List<org.rooinaction.coursemanager.web.gwt.proxies.TagProxy>> findTagEntries(int firstResult, int maxResults);

    abstract Request<org.rooinaction.coursemanager.web.gwt.proxies.TagProxy> findTag(Long id);

    abstract InstanceRequest<org.rooinaction.coursemanager.web.gwt.proxies.TagProxy, java.lang.Void> persist();

    abstract InstanceRequest<org.rooinaction.coursemanager.web.gwt.proxies.TagProxy, java.lang.Void> remove();
}
