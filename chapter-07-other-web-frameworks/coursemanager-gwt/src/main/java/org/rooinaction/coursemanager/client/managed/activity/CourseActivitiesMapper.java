package org.rooinaction.coursemanager.client.managed.activity;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.requestfactory.shared.EntityProxyId;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import org.rooinaction.coursemanager.client.managed.request.ApplicationRequestFactory;
import org.rooinaction.coursemanager.client.managed.ui.desktop.CourseDesktopDetailsView;
import org.rooinaction.coursemanager.client.managed.ui.desktop.CourseDesktopEditView;
import org.rooinaction.coursemanager.client.managed.ui.desktop.CourseDesktopListView;
import org.rooinaction.coursemanager.client.managed.ui.mobile.CourseMobileDetailsView;
import org.rooinaction.coursemanager.client.managed.ui.mobile.CourseMobileEditView;
import org.rooinaction.coursemanager.client.scaffold.ScaffoldApp;
import org.rooinaction.coursemanager.client.scaffold.place.ProxyPlace;
import org.rooinaction.coursemanager.web.proxy.CourseProxy;
import org.rooinaction.coursemanager.web.request.CourseRequest;

public class CourseActivitiesMapper extends CourseActivitiesMapper_Roo_Gwt {

    public CourseActivitiesMapper(ApplicationRequestFactory factory, PlaceController placeController) {
        this.factory = factory;
        this.placeController = placeController;
    }

    public Activity getActivity(ProxyPlace place) {
        switch(((place.getOperation()))) {
            case DETAILS:
                return new CourseDetailsActivity((EntityProxyId<CourseProxy>) place.getProxyId(), factory, placeController, ScaffoldApp.isMobile() ? CourseMobileDetailsView.instance() : CourseDesktopDetailsView.instance());
            case EDIT:
                return makeEditActivity(place);
            case CREATE:
                return makeCreateActivity();
        }
        throw new IllegalArgumentException("Unknown operation " + place.getOperation());
    }
}
