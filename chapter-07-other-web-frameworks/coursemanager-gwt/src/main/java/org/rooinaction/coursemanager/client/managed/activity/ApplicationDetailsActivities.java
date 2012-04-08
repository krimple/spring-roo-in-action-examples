package org.rooinaction.coursemanager.client.managed.activity;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.inject.Inject;
import org.rooinaction.coursemanager.client.managed.request.ApplicationEntityTypesProcessor;
import org.rooinaction.coursemanager.client.managed.request.ApplicationRequestFactory;
import org.rooinaction.coursemanager.client.scaffold.place.ProxyPlace;
import org.rooinaction.coursemanager.proxy.CourseProxy;
import org.rooinaction.coursemanager.proxy.InstructorProxy;
import org.rooinaction.coursemanager.proxy.OfferingProxy;
import org.rooinaction.coursemanager.proxy.RegistrationProxy;
import org.rooinaction.coursemanager.proxy.StudentProxy;
import org.rooinaction.coursemanager.proxy.TagProxy;
import org.rooinaction.coursemanager.proxy.TrainingProgramProxy;

public class ApplicationDetailsActivities extends ApplicationDetailsActivities_Roo_Gwt {

    @Inject
    public ApplicationDetailsActivities(ApplicationRequestFactory requestFactory, PlaceController placeController) {
        this.requests = requestFactory;
        this.placeController = placeController;
    }
}
