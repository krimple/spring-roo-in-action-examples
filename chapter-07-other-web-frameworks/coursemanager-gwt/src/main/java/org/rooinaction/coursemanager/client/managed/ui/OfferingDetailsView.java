package org.rooinaction.coursemanager.client.managed.ui;
import org.rooinaction.coursemanager.client.scaffold.place.ProxyDetailsView;
import org.rooinaction.coursemanager.web.proxy.OfferingProxy;

public interface OfferingDetailsView extends ProxyDetailsView<OfferingProxy> {

    void setDelegate(Delegate delegate);

    interface Delegate extends org.rooinaction.coursemanager.client.scaffold.place.ProxyDetailsView.Delegate {
    }
}
