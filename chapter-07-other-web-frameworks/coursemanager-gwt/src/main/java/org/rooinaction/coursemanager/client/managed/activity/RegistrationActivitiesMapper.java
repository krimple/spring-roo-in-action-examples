package org.rooinaction.coursemanager.client.managed.activity;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.requestfactory.shared.EntityProxyId;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import org.rooinaction.coursemanager.client.managed.request.ApplicationRequestFactory;
import org.rooinaction.coursemanager.client.managed.ui.desktop.RegistrationDesktopDetailsView;
import org.rooinaction.coursemanager.client.managed.ui.desktop.RegistrationDesktopEditView;
import org.rooinaction.coursemanager.client.managed.ui.desktop.RegistrationDesktopListView;
import org.rooinaction.coursemanager.client.managed.ui.mobile.RegistrationMobileDetailsView;
import org.rooinaction.coursemanager.client.managed.ui.mobile.RegistrationMobileEditView;
import org.rooinaction.coursemanager.client.scaffold.ScaffoldApp;
import org.rooinaction.coursemanager.client.scaffold.place.ProxyPlace;
import org.rooinaction.coursemanager.web.proxy.RegistrationProxy;
import org.rooinaction.coursemanager.web.request.RegistrationRequest;

public class RegistrationActivitiesMapper extends RegistrationActivitiesMapper_Roo_Gwt {

    public RegistrationActivitiesMapper(ApplicationRequestFactory factory, PlaceController placeController) {
        this.factory = factory;
        this.placeController = placeController;
    }

    public Activity getActivity(ProxyPlace place) {
        switch(((place.getOperation()))) {
            case DETAILS:
                return new RegistrationDetailsActivity((EntityProxyId<RegistrationProxy>) place.getProxyId(), factory, placeController, ScaffoldApp.isMobile() ? RegistrationMobileDetailsView.instance() : RegistrationDesktopDetailsView.instance());
            case EDIT:
                return makeEditActivity(place);
            case CREATE:
                return makeCreateActivity();
        }
        throw new IllegalArgumentException("Unknown operation " + place.getOperation());
    }
}
