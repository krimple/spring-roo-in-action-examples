package org.rooinaction.coursemanager.client.managed.activity;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.requestfactory.shared.EntityProxyId;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import org.rooinaction.coursemanager.client.managed.request.ApplicationRequestFactory;
import org.rooinaction.coursemanager.client.managed.ui.InstructorDetailsView;
import org.rooinaction.coursemanager.client.managed.ui.InstructorEditView;
import org.rooinaction.coursemanager.client.managed.ui.InstructorListView;
import org.rooinaction.coursemanager.client.managed.ui.InstructorMobileDetailsView;
import org.rooinaction.coursemanager.client.managed.ui.InstructorMobileEditView;
import org.rooinaction.coursemanager.client.scaffold.ScaffoldApp;
import org.rooinaction.coursemanager.client.scaffold.place.CreateAndEditProxy;
import org.rooinaction.coursemanager.client.scaffold.place.FindAndEditProxy;
import org.rooinaction.coursemanager.client.scaffold.place.ProxyPlace;
import org.rooinaction.coursemanager.proxy.InstructorProxy;
import org.rooinaction.coursemanager.request.InstructorRequest;

public class InstructorActivitiesMapper extends InstructorActivitiesMapper_Roo_Gwt {

    public InstructorActivitiesMapper(ApplicationRequestFactory requests, PlaceController placeController) {
        this.requests = requests;
        this.placeController = placeController;
    }

    public Activity getActivity(ProxyPlace place) {
        switch(place.getOperation()) {
            case DETAILS:
                return new InstructorDetailsActivity((EntityProxyId<InstructorProxy>) place.getProxyId(), requests, placeController, ScaffoldApp.isMobile() ? InstructorMobileDetailsView.instance() : InstructorDetailsView.instance());
            case EDIT:
                return makeEditActivity(place);
            case CREATE:
                return makeCreateActivity();
        }
        throw new IllegalArgumentException("Unknown operation " + place.getOperation());
    }
}
