package org.rooinaction.coursemanager.client.managed.ui;
import org.rooinaction.coursemanager.client.scaffold.place.ProxyDetailsView;
import org.rooinaction.coursemanager.web.proxy.RegistrationProxy;

public interface RegistrationDetailsView extends ProxyDetailsView<RegistrationProxy> {

    void setDelegate(Delegate delegate);

    interface Delegate extends org.rooinaction.coursemanager.client.scaffold.place.ProxyDetailsView.Delegate {
    }
}
