package org.rooinaction.coursemanager.client.managed.activity;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.requestfactory.shared.EntityProxyId;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import org.rooinaction.coursemanager.client.managed.request.ApplicationRequestFactory;
import org.rooinaction.coursemanager.client.managed.ui.desktop.TrainingProgramDesktopDetailsView;
import org.rooinaction.coursemanager.client.managed.ui.desktop.TrainingProgramDesktopEditView;
import org.rooinaction.coursemanager.client.managed.ui.desktop.TrainingProgramDesktopListView;
import org.rooinaction.coursemanager.client.managed.ui.mobile.TrainingProgramMobileDetailsView;
import org.rooinaction.coursemanager.client.managed.ui.mobile.TrainingProgramMobileEditView;
import org.rooinaction.coursemanager.client.scaffold.ScaffoldApp;
import org.rooinaction.coursemanager.client.scaffold.place.ProxyPlace;
import org.rooinaction.coursemanager.web.proxy.TrainingProgramProxy;
import org.rooinaction.coursemanager.web.request.TrainingProgramRequest;

public class TrainingProgramActivitiesMapper extends TrainingProgramActivitiesMapper_Roo_Gwt {

    public TrainingProgramActivitiesMapper(ApplicationRequestFactory factory, PlaceController placeController) {
        this.factory = factory;
        this.placeController = placeController;
    }

    public Activity getActivity(ProxyPlace place) {
        switch(((place.getOperation()))) {
            case DETAILS:
                return new TrainingProgramDetailsActivity((EntityProxyId<TrainingProgramProxy>) place.getProxyId(), factory, placeController, ScaffoldApp.isMobile() ? TrainingProgramMobileDetailsView.instance() : TrainingProgramDesktopDetailsView.instance());
            case EDIT:
                return makeEditActivity(place);
            case CREATE:
                return makeCreateActivity();
        }
        throw new IllegalArgumentException("Unknown operation " + place.getOperation());
    }
}
