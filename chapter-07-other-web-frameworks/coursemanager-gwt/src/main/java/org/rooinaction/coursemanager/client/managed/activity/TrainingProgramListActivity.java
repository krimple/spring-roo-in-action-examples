package org.rooinaction.coursemanager.client.managed.activity;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.view.client.Range;
import com.google.web.bindery.requestfactory.shared.Receiver;
import com.google.web.bindery.requestfactory.shared.Request;
import java.util.List;
import org.rooinaction.coursemanager.client.managed.request.ApplicationRequestFactory;
import org.rooinaction.coursemanager.client.scaffold.ScaffoldMobileApp;
import org.rooinaction.coursemanager.client.scaffold.activity.IsScaffoldMobileActivity;
import org.rooinaction.coursemanager.client.scaffold.place.AbstractProxyListActivity;
import org.rooinaction.coursemanager.client.scaffold.place.ProxyListView;
import org.rooinaction.coursemanager.proxy.TrainingProgramProxy;

public class TrainingProgramListActivity extends TrainingProgramListActivity_Roo_Gwt {

    public TrainingProgramListActivity(ApplicationRequestFactory requests, ProxyListView<org.rooinaction.coursemanager.proxy.TrainingProgramProxy> view, PlaceController placeController) {
        super(placeController, view, TrainingProgramProxy.class);
        this.requests = requests;
    }

    public Place getBackButtonPlace() {
        return ScaffoldMobileApp.ROOT_PLACE;
    }

    public String getBackButtonText() {
        return "Entities";
    }

    public Place getEditButtonPlace() {
        return null;
    }

    public String getTitleText() {
        return "TrainingPrograms";
    }

    public boolean hasEditButton() {
        return false;
    }

    protected Request<java.util.List<org.rooinaction.coursemanager.proxy.TrainingProgramProxy>> createRangeRequest(Range range) {
        return requests.trainingProgramRequest().findTrainingProgramEntries(range.getStart(), range.getLength());
    }
}
