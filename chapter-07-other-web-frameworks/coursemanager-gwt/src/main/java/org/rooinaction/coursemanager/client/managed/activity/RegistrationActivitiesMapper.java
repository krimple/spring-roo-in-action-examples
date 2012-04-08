package org.rooinaction.coursemanager.client.managed.activity;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.requestfactory.shared.EntityProxyId;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import org.rooinaction.coursemanager.client.managed.request.ApplicationRequestFactory;
import org.rooinaction.coursemanager.client.managed.ui.RegistrationDetailsView;
import org.rooinaction.coursemanager.client.managed.ui.RegistrationEditView;
import org.rooinaction.coursemanager.client.managed.ui.RegistrationListView;
import org.rooinaction.coursemanager.client.managed.ui.RegistrationMobileDetailsView;
import org.rooinaction.coursemanager.client.managed.ui.RegistrationMobileEditView;
import org.rooinaction.coursemanager.client.scaffold.ScaffoldApp;
import org.rooinaction.coursemanager.client.scaffold.place.CreateAndEditProxy;
import org.rooinaction.coursemanager.client.scaffold.place.FindAndEditProxy;
import org.rooinaction.coursemanager.client.scaffold.place.ProxyPlace;
import org.rooinaction.coursemanager.proxy.RegistrationProxy;
import org.rooinaction.coursemanager.request.RegistrationRequest;

public class RegistrationActivitiesMapper extends RegistrationActivitiesMapper_Roo_Gwt {

    public RegistrationActivitiesMapper(ApplicationRequestFactory requests, PlaceController placeController) {
        this.requests = requests;
        this.placeController = placeController;
    }

    public Activity getActivity(ProxyPlace place) {
        switch(place.getOperation()) {
            case DETAILS:
                return new RegistrationDetailsActivity((EntityProxyId<RegistrationProxy>) place.getProxyId(), requests, placeController, ScaffoldApp.isMobile() ? RegistrationMobileDetailsView.instance() : RegistrationDetailsView.instance());
            case EDIT:
                return makeEditActivity(place);
            case CREATE:
                return makeCreateActivity();
        }
        throw new IllegalArgumentException("Unknown operation " + place.getOperation());
    }
}
