package org.rooinaction.coursemanager.client.managed.activity;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.inject.Inject;
import org.rooinaction.coursemanager.client.managed.request.ApplicationEntityTypesProcessor;
import org.rooinaction.coursemanager.client.managed.request.ApplicationRequestFactory;
import org.rooinaction.coursemanager.client.managed.ui.desktop.CourseDesktopListView;
import org.rooinaction.coursemanager.client.managed.ui.desktop.InstructorDesktopListView;
import org.rooinaction.coursemanager.client.managed.ui.desktop.OfferingDesktopListView;
import org.rooinaction.coursemanager.client.managed.ui.desktop.RegistrationDesktopListView;
import org.rooinaction.coursemanager.client.managed.ui.desktop.StudentDesktopListView;
import org.rooinaction.coursemanager.client.managed.ui.desktop.TagDesktopListView;
import org.rooinaction.coursemanager.client.managed.ui.desktop.TrainingProgramDesktopListView;
import org.rooinaction.coursemanager.client.managed.ui.mobile.CourseMobileListView;
import org.rooinaction.coursemanager.client.managed.ui.mobile.InstructorMobileListView;
import org.rooinaction.coursemanager.client.managed.ui.mobile.OfferingMobileListView;
import org.rooinaction.coursemanager.client.managed.ui.mobile.RegistrationMobileListView;
import org.rooinaction.coursemanager.client.managed.ui.mobile.StudentMobileListView;
import org.rooinaction.coursemanager.client.managed.ui.mobile.TagMobileListView;
import org.rooinaction.coursemanager.client.managed.ui.mobile.TrainingProgramMobileListView;
import org.rooinaction.coursemanager.client.scaffold.ScaffoldApp;
import org.rooinaction.coursemanager.client.scaffold.place.ProxyListPlace;
import org.rooinaction.coursemanager.web.proxy.CourseProxy;
import org.rooinaction.coursemanager.web.proxy.InstructorProxy;
import org.rooinaction.coursemanager.web.proxy.OfferingProxy;
import org.rooinaction.coursemanager.web.proxy.RegistrationProxy;
import org.rooinaction.coursemanager.web.proxy.StudentProxy;
import org.rooinaction.coursemanager.web.proxy.TagProxy;
import org.rooinaction.coursemanager.web.proxy.TrainingProgramProxy;

public final class ApplicationMasterActivities extends ApplicationMasterActivities_Roo_Gwt {

    @Inject
    public ApplicationMasterActivities(ApplicationRequestFactory requests, PlaceController placeController) {
        this.requests = requests;
        this.placeController = placeController;
    }
}
