package org.rooinaction.coursemanager.client.managed.ui;

import com.google.web.bindery.requestfactory.gwt.ui.client.ProxyRenderer;
import java.util.Set;
import org.rooinaction.coursemanager.web.gwt.proxies.CourseProxy;
import org.rooinaction.coursemanager.web.gwt.proxies.TrainingProgramProxy;

public class TrainingProgramProxyRenderer extends ProxyRenderer<TrainingProgramProxy> {

    private static org.rooinaction.coursemanager.client.managed.ui.TrainingProgramProxyRenderer INSTANCE;

    protected TrainingProgramProxyRenderer() {
        super(new String[] { "name" });
    }

    public static org.rooinaction.coursemanager.client.managed.ui.TrainingProgramProxyRenderer instance() {
        if (INSTANCE == null) {
            INSTANCE = new TrainingProgramProxyRenderer();
        }
        return INSTANCE;
    }

    public String render(TrainingProgramProxy object) {
        if (object == null) {
            return "";
        }
        return object.getName() + " (" + object.getName() + ")";
    }
}
