package org.rooinaction.coursemanager.client.managed.ui;
import java.util.Collection;
import java.util.List;
import org.rooinaction.coursemanager.client.scaffold.place.ProxyEditView;
import org.rooinaction.coursemanager.web.proxy.TrainingProgramProxy;

public interface TrainingProgramEditView<V extends ProxyEditView<TrainingProgramProxy, V>> extends ProxyEditView<TrainingProgramProxy, V> {

    void setDelegate(Delegate delegate);

    interface Delegate extends org.rooinaction.coursemanager.client.scaffold.place.ProxyEditView.Delegate {
    }
}
