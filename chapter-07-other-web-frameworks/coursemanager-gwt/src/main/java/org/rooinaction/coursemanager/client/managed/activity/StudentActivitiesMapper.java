package org.rooinaction.coursemanager.client.managed.activity;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.requestfactory.shared.EntityProxyId;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import java.util.Set;
import org.rooinaction.coursemanager.client.managed.request.ApplicationRequestFactory;
import org.rooinaction.coursemanager.client.managed.ui.RegistrationSetEditor;
import org.rooinaction.coursemanager.client.managed.ui.StudentDetailsView;
import org.rooinaction.coursemanager.client.managed.ui.StudentEditView;
import org.rooinaction.coursemanager.client.managed.ui.StudentListView;
import org.rooinaction.coursemanager.client.managed.ui.StudentMobileDetailsView;
import org.rooinaction.coursemanager.client.managed.ui.StudentMobileEditView;
import org.rooinaction.coursemanager.client.scaffold.ScaffoldApp;
import org.rooinaction.coursemanager.client.scaffold.place.CreateAndEditProxy;
import org.rooinaction.coursemanager.client.scaffold.place.FindAndEditProxy;
import org.rooinaction.coursemanager.client.scaffold.place.ProxyPlace;
import org.rooinaction.coursemanager.web.gwt.proxies.RegistrationProxy;
import org.rooinaction.coursemanager.web.gwt.proxies.StudentProxy;
import org.rooinaction.coursemanager.web.gwt.requests.StudentRequest;

public class StudentActivitiesMapper extends StudentActivitiesMapper_Roo_Gwt {

    public StudentActivitiesMapper(ApplicationRequestFactory requests, PlaceController placeController) {
        this.requests = requests;
        this.placeController = placeController;
    }

    public Activity getActivity(ProxyPlace place) {
        switch(place.getOperation()) {
            case DETAILS:
                return new StudentDetailsActivity((EntityProxyId<StudentProxy>) place.getProxyId(), requests, placeController, ScaffoldApp.isMobile() ? StudentMobileDetailsView.instance() : StudentDetailsView.instance());
            case EDIT:
                return makeEditActivity(place);
            case CREATE:
                return makeCreateActivity();
        }
        throw new IllegalArgumentException("Unknown operation " + place.getOperation());
    }
}
