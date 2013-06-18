package org.rooinaction.coursemanager.client.managed.activity;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.requestfactory.shared.EntityProxyId;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import org.rooinaction.coursemanager.client.managed.request.ApplicationRequestFactory;
import org.rooinaction.coursemanager.client.managed.ui.desktop.OfferingDesktopDetailsView;
import org.rooinaction.coursemanager.client.managed.ui.desktop.OfferingDesktopEditView;
import org.rooinaction.coursemanager.client.managed.ui.desktop.OfferingDesktopListView;
import org.rooinaction.coursemanager.client.managed.ui.mobile.OfferingMobileDetailsView;
import org.rooinaction.coursemanager.client.managed.ui.mobile.OfferingMobileEditView;
import org.rooinaction.coursemanager.client.scaffold.ScaffoldApp;
import org.rooinaction.coursemanager.client.scaffold.place.ProxyPlace;
import org.rooinaction.coursemanager.web.proxy.OfferingProxy;
import org.rooinaction.coursemanager.web.request.OfferingRequest;

public class OfferingActivitiesMapper extends OfferingActivitiesMapper_Roo_Gwt {

    public OfferingActivitiesMapper(ApplicationRequestFactory factory, PlaceController placeController) {
        this.factory = factory;
        this.placeController = placeController;
    }

    public Activity getActivity(ProxyPlace place) {
        switch(((place.getOperation()))) {
            case DETAILS:
                return new OfferingDetailsActivity((EntityProxyId<OfferingProxy>) place.getProxyId(), factory, placeController, ScaffoldApp.isMobile() ? OfferingMobileDetailsView.instance() : OfferingDesktopDetailsView.instance());
            case EDIT:
                return makeEditActivity(place);
            case CREATE:
                return makeCreateActivity();
        }
        throw new IllegalArgumentException("Unknown operation " + place.getOperation());
    }
}
