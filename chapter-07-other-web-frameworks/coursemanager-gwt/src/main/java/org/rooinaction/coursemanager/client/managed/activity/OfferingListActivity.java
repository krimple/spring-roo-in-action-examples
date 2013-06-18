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
import org.rooinaction.coursemanager.web.proxy.OfferingProxy;

public class OfferingListActivity extends OfferingListActivity_Roo_Gwt {

    public OfferingListActivity(ApplicationRequestFactory requests, ProxyListView<OfferingProxy> view, PlaceController placeController) {
        super(placeController, view, OfferingProxy.class);
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
        return "Offerings";
    }

    public boolean hasEditButton() {
        return false;
    }

    protected Request<List<OfferingProxy>> createRangeRequest(Range range) {
        return requests.offeringRequest().findOfferingEntries(range.getStart(), range.getLength());
    }
}
