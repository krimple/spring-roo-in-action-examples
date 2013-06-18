package org.rooinaction.coursemanager.client.managed.ui;
import java.util.Collection;
import java.util.List;
import org.rooinaction.coursemanager.client.scaffold.place.ProxyEditView;
import org.rooinaction.coursemanager.web.proxy.RegistrationProxy;

public interface RegistrationEditView<V extends ProxyEditView<RegistrationProxy, V>> extends ProxyEditView<RegistrationProxy, V> {

    void setDelegate(Delegate delegate);

    interface Delegate extends org.rooinaction.coursemanager.client.scaffold.place.ProxyEditView.Delegate {
    }
}
