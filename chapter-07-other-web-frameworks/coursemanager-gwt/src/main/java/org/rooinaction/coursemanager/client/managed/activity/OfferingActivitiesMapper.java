package org.rooinaction.coursemanager.client.managed.activity;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.requestfactory.shared.EntityProxyId;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import org.rooinaction.coursemanager.client.managed.request.ApplicationRequestFactory;
import org.rooinaction.coursemanager.client.managed.ui.OfferingDetailsView;
import org.rooinaction.coursemanager.client.managed.ui.OfferingEditView;
import org.rooinaction.coursemanager.client.managed.ui.OfferingListView;
import org.rooinaction.coursemanager.client.managed.ui.OfferingMobileDetailsView;
import org.rooinaction.coursemanager.client.managed.ui.OfferingMobileEditView;
import org.rooinaction.coursemanager.client.scaffold.ScaffoldApp;
import org.rooinaction.coursemanager.client.scaffold.place.CreateAndEditProxy;
import org.rooinaction.coursemanager.client.scaffold.place.FindAndEditProxy;
import org.rooinaction.coursemanager.client.scaffold.place.ProxyPlace;
import org.rooinaction.coursemanager.proxy.OfferingProxy;
import org.rooinaction.coursemanager.request.OfferingRequest;

public class OfferingActivitiesMapper extends OfferingActivitiesMapper_Roo_Gwt {

    public OfferingActivitiesMapper(ApplicationRequestFactory requests, PlaceController placeController) {
        this.requests = requests;
        this.placeController = placeController;
    }

    public Activity getActivity(ProxyPlace place) {
        switch(place.getOperation()) {
            case DETAILS:
                return new OfferingDetailsActivity((EntityProxyId<OfferingProxy>) place.getProxyId(), requests, placeController, ScaffoldApp.isMobile() ? OfferingMobileDetailsView.instance() : OfferingDetailsView.instance());
            case EDIT:
                return makeEditActivity(place);
            case CREATE:
                return makeCreateActivity();
        }
        throw new IllegalArgumentException("Unknown operation " + place.getOperation());
    }
}
