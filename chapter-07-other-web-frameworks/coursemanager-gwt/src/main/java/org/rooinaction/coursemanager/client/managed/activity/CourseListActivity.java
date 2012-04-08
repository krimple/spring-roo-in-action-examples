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
import org.rooinaction.coursemanager.proxy.CourseProxy;
import org.rooinaction.coursemanager.shared.CourseTypeEnum;

public class CourseListActivity extends CourseListActivity_Roo_Gwt {

    public CourseListActivity(ApplicationRequestFactory requests, ProxyListView<org.rooinaction.coursemanager.proxy.CourseProxy> view, PlaceController placeController) {
        super(placeController, view, CourseProxy.class);
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
        return "Courses";
    }

    public boolean hasEditButton() {
        return false;
    }

    protected Request<java.util.List<org.rooinaction.coursemanager.proxy.CourseProxy>> createRangeRequest(Range range) {
        return requests.courseRequest().findCourseEntries(range.getStart(), range.getLength());
    }
}
