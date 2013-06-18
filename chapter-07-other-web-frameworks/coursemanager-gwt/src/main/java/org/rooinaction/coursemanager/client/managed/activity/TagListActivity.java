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
import org.rooinaction.coursemanager.web.proxy.TagProxy;

public class TagListActivity extends TagListActivity_Roo_Gwt {

    public TagListActivity(ApplicationRequestFactory requests, ProxyListView<TagProxy> view, PlaceController placeController) {
        super(placeController, view, TagProxy.class);
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
        return "Tags";
    }

    public boolean hasEditButton() {
        return false;
    }

    protected Request<List<TagProxy>> createRangeRequest(Range range) {
        return requests.tagRequest().findTagEntries(range.getStart(), range.getLength());
    }
}
