package org.rooinaction.coursemanager.client.managed.activity;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.web.bindery.requestfactory.shared.EntityProxyId;
import com.google.web.bindery.requestfactory.shared.Receiver;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.rooinaction.coursemanager.client.managed.request.ApplicationRequestFactory;
import org.rooinaction.coursemanager.client.managed.ui.InstructorEditView;
import org.rooinaction.coursemanager.client.managed.ui.InstructorEditView.Delegate;
import org.rooinaction.coursemanager.client.scaffold.place.AbstractProxyEditActivity;
import org.rooinaction.coursemanager.client.scaffold.place.ProxyListPlace;
import org.rooinaction.coursemanager.web.proxy.InstructorProxy;
import org.rooinaction.coursemanager.web.request.InstructorRequest;

public class InstructorEditActivity extends AbstractProxyEditActivity<InstructorProxy> implements Delegate {

    private final InstructorEditView<?> view;

    private final InstructorRequest request;

    public InstructorEditActivity(EntityProxyId<InstructorProxy> proxyId, ApplicationRequestFactory factory, InstructorEditView<?> view, PlaceController placeController) {
        super(proxyId, factory, placeController);
        this.view = view;
        this.request = factory.instructorRequest();
    }

    @Override
    protected InstructorEditView<?> getView() {
        return view;
    }

    @Override
    public void start(AcceptsOneWidget display, EventBus eventBus) {
        this.view.setDelegate(this);
        super.start(display, eventBus);
    }

    @Override
    protected InstructorProxy createProxy() {
        return request.create(InstructorProxy.class);
    }

    @Override
    protected RequestContext createSaveRequest(InstructorProxy proxy) {
        request.persist().using(proxy);
        return request;
    }
}
