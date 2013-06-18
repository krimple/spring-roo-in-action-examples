package org.rooinaction.coursemanager.client.managed.activity;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.requestfactory.shared.EntityProxyId;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import org.rooinaction.coursemanager.client.managed.request.ApplicationRequestFactory;
import org.rooinaction.coursemanager.client.managed.ui.desktop.TagDesktopDetailsView;
import org.rooinaction.coursemanager.client.managed.ui.desktop.TagDesktopEditView;
import org.rooinaction.coursemanager.client.managed.ui.desktop.TagDesktopListView;
import org.rooinaction.coursemanager.client.managed.ui.mobile.TagMobileDetailsView;
import org.rooinaction.coursemanager.client.managed.ui.mobile.TagMobileEditView;
import org.rooinaction.coursemanager.client.scaffold.ScaffoldApp;
import org.rooinaction.coursemanager.client.scaffold.place.ProxyPlace;
import org.rooinaction.coursemanager.web.proxy.TagProxy;
import org.rooinaction.coursemanager.web.request.TagRequest;

public class TagActivitiesMapper extends TagActivitiesMapper_Roo_Gwt {

    public TagActivitiesMapper(ApplicationRequestFactory factory, PlaceController placeController) {
        this.factory = factory;
        this.placeController = placeController;
    }

    public Activity getActivity(ProxyPlace place) {
        switch(((place.getOperation()))) {
            case DETAILS:
                return new TagDetailsActivity((EntityProxyId<TagProxy>) place.getProxyId(), factory, placeController, ScaffoldApp.isMobile() ? TagMobileDetailsView.instance() : TagDesktopDetailsView.instance());
            case EDIT:
                return makeEditActivity(place);
            case CREATE:
                return makeCreateActivity();
        }
        throw new IllegalArgumentException("Unknown operation " + place.getOperation());
    }
}
