package org.rooinaction.coursemanager.client.managed.activity;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.inject.Inject;
import org.rooinaction.coursemanager.client.managed.request.ApplicationEntityTypesProcessor;
import org.rooinaction.coursemanager.client.managed.request.ApplicationRequestFactory;
import org.rooinaction.coursemanager.client.managed.ui.CourseListView;
import org.rooinaction.coursemanager.client.managed.ui.CourseMobileListView;
import org.rooinaction.coursemanager.client.managed.ui.InstructorListView;
import org.rooinaction.coursemanager.client.managed.ui.InstructorMobileListView;
import org.rooinaction.coursemanager.client.managed.ui.OfferingListView;
import org.rooinaction.coursemanager.client.managed.ui.OfferingMobileListView;
import org.rooinaction.coursemanager.client.managed.ui.RegistrationListView;
import org.rooinaction.coursemanager.client.managed.ui.RegistrationMobileListView;
import org.rooinaction.coursemanager.client.managed.ui.StudentListView;
import org.rooinaction.coursemanager.client.managed.ui.StudentMobileListView;
import org.rooinaction.coursemanager.client.managed.ui.TagListView;
import org.rooinaction.coursemanager.client.managed.ui.TagMobileListView;
import org.rooinaction.coursemanager.client.managed.ui.TrainingProgramListView;
import org.rooinaction.coursemanager.client.managed.ui.TrainingProgramMobileListView;
import org.rooinaction.coursemanager.client.scaffold.ScaffoldApp;
import org.rooinaction.coursemanager.client.scaffold.place.ProxyListPlace;
import org.rooinaction.coursemanager.proxy.CourseProxy;
import org.rooinaction.coursemanager.proxy.InstructorProxy;
import org.rooinaction.coursemanager.proxy.OfferingProxy;
import org.rooinaction.coursemanager.proxy.RegistrationProxy;
import org.rooinaction.coursemanager.proxy.StudentProxy;
import org.rooinaction.coursemanager.proxy.TagProxy;
import org.rooinaction.coursemanager.proxy.TrainingProgramProxy;

public final class ApplicationMasterActivities extends ApplicationMasterActivities_Roo_Gwt {

    @Inject
    public ApplicationMasterActivities(ApplicationRequestFactory requests, PlaceController placeController) {
        this.requests = requests;
        this.placeController = placeController;
    }
}
