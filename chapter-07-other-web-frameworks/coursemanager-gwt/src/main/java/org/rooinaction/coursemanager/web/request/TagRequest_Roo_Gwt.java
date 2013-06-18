// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package org.rooinaction.coursemanager.web.request;
import com.google.web.bindery.requestfactory.shared.InstanceRequest;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.ServiceName;
import java.util.List;
import org.rooinaction.coursemanager.web.proxy.TagProxy;
import org.springframework.roo.addon.gwt.RooGwtRequest;

@RooGwtRequest("org.rooinaction.coursemanager.model.Tag")
@ServiceName("org.rooinaction.coursemanager.model.Tag")
public interface TagRequest_Roo_Gwt extends RequestContext {

    abstract Request<Long> countTags();

    abstract Request<List<TagProxy>> findAllTags();

    abstract Request<List<TagProxy>> findTagEntries(int firstResult, int maxResults);

    abstract Request<TagProxy> findTag(Long id);

    abstract InstanceRequest<TagProxy, Void> persist();

    abstract InstanceRequest<TagProxy, Void> remove();
}
