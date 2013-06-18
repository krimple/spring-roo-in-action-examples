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
import org.rooinaction.coursemanager.client.managed.ui.RegistrationEditView;
import org.rooinaction.coursemanager.client.managed.ui.RegistrationEditView.Delegate;
import org.rooinaction.coursemanager.client.scaffold.place.AbstractProxyEditActivity;
import org.rooinaction.coursemanager.client.scaffold.place.ProxyListPlace;
import org.rooinaction.coursemanager.web.proxy.RegistrationProxy;
import org.rooinaction.coursemanager.web.request.RegistrationRequest;

public class RegistrationEditActivity extends AbstractProxyEditActivity<RegistrationProxy> implements Delegate {

    private final RegistrationEditView<?> view;

    private final RegistrationRequest request;

    public RegistrationEditActivity(EntityProxyId<RegistrationProxy> proxyId, ApplicationRequestFactory factory, RegistrationEditView<?> view, PlaceController placeController) {
        super(proxyId, factory, placeController);
        this.view = view;
        this.request = factory.registrationRequest();
    }

    @Override
    protected RegistrationEditView<?> getView() {
        return view;
    }

    @Override
    public void start(AcceptsOneWidget display, EventBus eventBus) {
        this.view.setDelegate(this);
        super.start(display, eventBus);
    }

    @Override
    protected RegistrationProxy createProxy() {
        return request.create(RegistrationProxy.class);
    }

    @Override
    protected RequestContext createSaveRequest(RegistrationProxy proxy) {
        request.persist().using(proxy);
        return request;
    }
}
