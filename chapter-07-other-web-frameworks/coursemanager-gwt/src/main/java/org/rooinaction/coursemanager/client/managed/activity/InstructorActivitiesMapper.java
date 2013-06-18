package org.rooinaction.coursemanager.client.managed.activity;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.requestfactory.shared.EntityProxyId;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import org.rooinaction.coursemanager.client.managed.request.ApplicationRequestFactory;
import org.rooinaction.coursemanager.client.managed.ui.desktop.InstructorDesktopDetailsView;
import org.rooinaction.coursemanager.client.managed.ui.desktop.InstructorDesktopEditView;
import org.rooinaction.coursemanager.client.managed.ui.desktop.InstructorDesktopListView;
import org.rooinaction.coursemanager.client.managed.ui.mobile.InstructorMobileDetailsView;
import org.rooinaction.coursemanager.client.managed.ui.mobile.InstructorMobileEditView;
import org.rooinaction.coursemanager.client.scaffold.ScaffoldApp;
import org.rooinaction.coursemanager.client.scaffold.place.ProxyPlace;
import org.rooinaction.coursemanager.web.proxy.InstructorProxy;
import org.rooinaction.coursemanager.web.request.InstructorRequest;

public class InstructorActivitiesMapper extends InstructorActivitiesMapper_Roo_Gwt {

    public InstructorActivitiesMapper(ApplicationRequestFactory factory, PlaceController placeController) {
        this.factory = factory;
        this.placeController = placeController;
    }

    public Activity getActivity(ProxyPlace place) {
        switch(((place.getOperation()))) {
            case DETAILS:
                return new InstructorDetailsActivity((EntityProxyId<InstructorProxy>) place.getProxyId(), factory, placeController, ScaffoldApp.isMobile() ? InstructorMobileDetailsView.instance() : InstructorDesktopDetailsView.instance());
            case EDIT:
                return makeEditActivity(place);
            case CREATE:
                return makeCreateActivity();
        }
        throw new IllegalArgumentException("Unknown operation " + place.getOperation());
    }
}
