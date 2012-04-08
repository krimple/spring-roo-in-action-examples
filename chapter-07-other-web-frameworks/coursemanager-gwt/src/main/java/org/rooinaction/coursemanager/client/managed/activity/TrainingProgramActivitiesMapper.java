package org.rooinaction.coursemanager.client.managed.activity;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.requestfactory.shared.EntityProxyId;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import org.rooinaction.coursemanager.client.managed.request.ApplicationRequestFactory;
import org.rooinaction.coursemanager.client.managed.ui.TrainingProgramDetailsView;
import org.rooinaction.coursemanager.client.managed.ui.TrainingProgramEditView;
import org.rooinaction.coursemanager.client.managed.ui.TrainingProgramListView;
import org.rooinaction.coursemanager.client.managed.ui.TrainingProgramMobileDetailsView;
import org.rooinaction.coursemanager.client.managed.ui.TrainingProgramMobileEditView;
import org.rooinaction.coursemanager.client.scaffold.ScaffoldApp;
import org.rooinaction.coursemanager.client.scaffold.place.CreateAndEditProxy;
import org.rooinaction.coursemanager.client.scaffold.place.FindAndEditProxy;
import org.rooinaction.coursemanager.client.scaffold.place.ProxyPlace;
import org.rooinaction.coursemanager.proxy.TrainingProgramProxy;
import org.rooinaction.coursemanager.request.TrainingProgramRequest;

public class TrainingProgramActivitiesMapper extends TrainingProgramActivitiesMapper_Roo_Gwt {

    public TrainingProgramActivitiesMapper(ApplicationRequestFactory requests, PlaceController placeController) {
        this.requests = requests;
        this.placeController = placeController;
    }

    public Activity getActivity(ProxyPlace place) {
        switch(place.getOperation()) {
            case DETAILS:
                return new TrainingProgramDetailsActivity((EntityProxyId<TrainingProgramProxy>) place.getProxyId(), requests, placeController, ScaffoldApp.isMobile() ? TrainingProgramMobileDetailsView.instance() : TrainingProgramDetailsView.instance());
            case EDIT:
                return makeEditActivity(place);
            case CREATE:
                return makeCreateActivity();
        }
        throw new IllegalArgumentException("Unknown operation " + place.getOperation());
    }
}
