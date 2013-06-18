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
import org.rooinaction.coursemanager.client.managed.ui.OfferingEditView;
import org.rooinaction.coursemanager.client.managed.ui.OfferingEditView.Delegate;
import org.rooinaction.coursemanager.client.scaffold.place.AbstractProxyEditActivity;
import org.rooinaction.coursemanager.client.scaffold.place.ProxyListPlace;
import org.rooinaction.coursemanager.web.proxy.OfferingProxy;
import org.rooinaction.coursemanager.web.request.OfferingRequest;

public class OfferingEditActivity extends AbstractProxyEditActivity<OfferingProxy> implements Delegate {

    private final OfferingEditView<?> view;

    private final OfferingRequest request;

    public OfferingEditActivity(EntityProxyId<OfferingProxy> proxyId, ApplicationRequestFactory factory, OfferingEditView<?> view, PlaceController placeController) {
        super(proxyId, factory, placeController);
        this.view = view;
        this.request = factory.offeringRequest();
    }

    @Override
    protected OfferingEditView<?> getView() {
        return view;
    }

    @Override
    public void start(AcceptsOneWidget display, EventBus eventBus) {
        this.view.setDelegate(this);
        super.start(display, eventBus);
    }

    @Override
    protected OfferingProxy createProxy() {
        return request.create(OfferingProxy.class);
    }

    @Override
    protected RequestContext createSaveRequest(OfferingProxy proxy) {
        request.persist().using(proxy);
        return request;
    }
}
