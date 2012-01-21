package org.rooinaction.coursemanager.client.managed.activity;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.requestfactory.shared.EntityProxyId;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import java.util.Set;
import org.rooinaction.coursemanager.client.managed.request.ApplicationRequestFactory;
import org.rooinaction.coursemanager.client.managed.ui.CourseDetailsView;
import org.rooinaction.coursemanager.client.managed.ui.CourseEditView;
import org.rooinaction.coursemanager.client.managed.ui.CourseListView;
import org.rooinaction.coursemanager.client.managed.ui.CourseMobileDetailsView;
import org.rooinaction.coursemanager.client.managed.ui.CourseMobileEditView;
import org.rooinaction.coursemanager.client.managed.ui.OfferingSetEditor;
import org.rooinaction.coursemanager.client.managed.ui.TagSetEditor;
import org.rooinaction.coursemanager.client.scaffold.ScaffoldApp;
import org.rooinaction.coursemanager.client.scaffold.place.CreateAndEditProxy;
import org.rooinaction.coursemanager.client.scaffold.place.FindAndEditProxy;
import org.rooinaction.coursemanager.client.scaffold.place.ProxyPlace;
import org.rooinaction.coursemanager.web.gwt.proxies.CourseProxy;
import org.rooinaction.coursemanager.web.gwt.proxies.OfferingProxy;
import org.rooinaction.coursemanager.web.gwt.proxies.TagProxy;
import org.rooinaction.coursemanager.web.gwt.proxies.TrainingProgramProxy;
import org.rooinaction.coursemanager.web.gwt.requests.CourseRequest;

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
