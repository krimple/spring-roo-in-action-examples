package org.rooinaction.coursemanager.client.managed.activity;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.requestfactory.shared.EntityProxyId;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import org.rooinaction.coursemanager.client.managed.request.ApplicationRequestFactory;
import org.rooinaction.coursemanager.client.managed.ui.desktop.StudentDesktopDetailsView;
import org.rooinaction.coursemanager.client.managed.ui.desktop.StudentDesktopEditView;
import org.rooinaction.coursemanager.client.managed.ui.desktop.StudentDesktopListView;
import org.rooinaction.coursemanager.client.managed.ui.mobile.StudentMobileDetailsView;
import org.rooinaction.coursemanager.client.managed.ui.mobile.StudentMobileEditView;
import org.rooinaction.coursemanager.client.scaffold.ScaffoldApp;
import org.rooinaction.coursemanager.client.scaffold.place.ProxyPlace;
import org.rooinaction.coursemanager.web.proxy.StudentProxy;
import org.rooinaction.coursemanager.web.request.StudentRequest;

public class StudentActivitiesMapper extends StudentActivitiesMapper_Roo_Gwt {

    public StudentActivitiesMapper(ApplicationRequestFactory factory, PlaceController placeController) {
        this.factory = factory;
        this.placeController = placeController;
    }

    public Activity getActivity(ProxyPlace place) {
        switch(((place.getOperation()))) {
            case DETAILS:
                return new StudentDetailsActivity((EntityProxyId<StudentProxy>) place.getProxyId(), factory, placeController, ScaffoldApp.isMobile() ? StudentMobileDetailsView.instance() : StudentDesktopDetailsView.instance());
            case EDIT:
                return makeEditActivity(place);
            case CREATE:
                return makeCreateActivity();
        }
        throw new IllegalArgumentException("Unknown operation " + place.getOperation());
    }
}
