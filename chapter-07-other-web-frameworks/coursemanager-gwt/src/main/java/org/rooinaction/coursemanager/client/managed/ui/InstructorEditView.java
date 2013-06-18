package org.rooinaction.coursemanager.client.managed.ui;
import java.util.Collection;
import java.util.List;
import org.rooinaction.coursemanager.client.scaffold.place.ProxyEditView;
import org.rooinaction.coursemanager.web.proxy.InstructorProxy;

public interface InstructorEditView<V extends ProxyEditView<InstructorProxy, V>> extends ProxyEditView<InstructorProxy, V> {

    void setDelegate(Delegate delegate);

    interface Delegate extends org.rooinaction.coursemanager.client.scaffold.place.ProxyEditView.Delegate {
    }
}
