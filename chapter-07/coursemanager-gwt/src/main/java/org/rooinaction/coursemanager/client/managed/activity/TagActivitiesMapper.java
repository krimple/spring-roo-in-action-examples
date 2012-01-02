package org.rooinaction.coursemanager.client.managed.activity;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.requestfactory.shared.EntityProxyId;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import java.util.Set;
import org.rooinaction.coursemanager.client.managed.request.ApplicationRequestFactory;
import org.rooinaction.coursemanager.client.managed.ui.CourseSetEditor;
import org.rooinaction.coursemanager.client.managed.ui.TagDetailsView;
import org.rooinaction.coursemanager.client.managed.ui.TagEditView;
import org.rooinaction.coursemanager.client.managed.ui.TagListView;
import org.rooinaction.coursemanager.client.managed.ui.TagMobileDetailsView;
import org.rooinaction.coursemanager.client.managed.ui.TagMobileEditView;
import org.rooinaction.coursemanager.client.scaffold.ScaffoldApp;
import org.rooinaction.coursemanager.client.scaffold.place.CreateAndEditProxy;
import org.rooinaction.coursemanager.client.scaffold.place.FindAndEditProxy;
import org.rooinaction.coursemanager.client.scaffold.place.ProxyPlace;
import org.rooinaction.coursemanager.web.gwt.proxies.CourseProxy;
import org.rooinaction.coursemanager.web.gwt.proxies.TagProxy;
import org.rooinaction.coursemanager.web.gwt.requests.TagRequest;

public class TagActivitiesMapper extends TagActivitiesMapper_Roo_Gwt {

    public TagActivitiesMapper(ApplicationRequestFactory requests, PlaceController placeController) {
        this.requests = requests;
        this.placeController = placeController;
    }

    public Activity getActivity(ProxyPlace place) {
        switch(place.getOperation()) {
            case DETAILS:
                return new TagDetailsActivity((EntityProxyId<TagProxy>) place.getProxyId(), requests, placeController, ScaffoldApp.isMobile() ? TagMobileDetailsView.instance() : TagDetailsView.instance());
            case EDIT:
                return makeEditActivity(place);
            case CREATE:
                return makeCreateActivity();
        }
        throw new IllegalArgumentException("Unknown operation " + place.getOperation());
    }
}
