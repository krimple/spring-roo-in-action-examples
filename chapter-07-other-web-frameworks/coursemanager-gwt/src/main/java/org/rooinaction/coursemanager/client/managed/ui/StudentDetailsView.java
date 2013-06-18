package org.rooinaction.coursemanager.client.managed.ui;
import org.rooinaction.coursemanager.client.scaffold.place.ProxyDetailsView;
import org.rooinaction.coursemanager.web.proxy.StudentProxy;

public interface StudentDetailsView extends ProxyDetailsView<StudentProxy> {

    void setDelegate(Delegate delegate);

    interface Delegate extends org.rooinaction.coursemanager.client.scaffold.place.ProxyDetailsView.Delegate {
    }
}
