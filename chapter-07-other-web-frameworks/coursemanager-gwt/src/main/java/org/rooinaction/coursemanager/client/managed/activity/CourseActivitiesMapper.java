package org.rooinaction.coursemanager.client.managed.activity;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.requestfactory.shared.EntityProxyId;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import org.rooinaction.coursemanager.client.managed.request.ApplicationRequestFactory;
import org.rooinaction.coursemanager.client.managed.ui.CourseDetailsView;
import org.rooinaction.coursemanager.client.managed.ui.CourseEditView;
import org.rooinaction.coursemanager.client.managed.ui.CourseListView;
import org.rooinaction.coursemanager.client.managed.ui.CourseMobileDetailsView;
import org.rooinaction.coursemanager.client.managed.ui.CourseMobileEditView;
import org.rooinaction.coursemanager.client.scaffold.ScaffoldApp;
import org.rooinaction.coursemanager.client.scaffold.place.CreateAndEditProxy;
import org.rooinaction.coursemanager.client.scaffold.place.FindAndEditProxy;
import org.rooinaction.coursemanager.client.scaffold.place.ProxyPlace;
import org.rooinaction.coursemanager.proxy.CourseProxy;
import org.rooinaction.coursemanager.request.CourseRequest;
import org.rooinaction.coursemanager.shared.CourseTypeEnum;

public class CourseActivitiesMapper extends CourseActivitiesMapper_Roo_Gwt {

    public CourseActivitiesMapper(ApplicationRequestFactory requests, PlaceController placeController) {
        this.requests = requests;
        this.placeController = placeController;
    }

    public Activity getActivity(ProxyPlace place) {
        switch(place.getOperation()) {
            case DETAILS:
                return new CourseDetailsActivity((EntityProxyId<CourseProxy>) place.getProxyId(), requests, placeController, ScaffoldApp.isMobile() ? CourseMobileDetailsView.instance() : CourseDetailsView.instance());
            case EDIT:
                return makeEditActivity(place);
            case CREATE:
                return makeCreateActivity();
        }
        throw new IllegalArgumentException("Unknown operation " + place.getOperation());
    }
}
