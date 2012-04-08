package org.rooinaction.coursemanager.client.managed.ui;

import com.google.web.bindery.requestfactory.gwt.ui.client.ProxyRenderer;
import org.rooinaction.coursemanager.proxy.CourseProxy;
import org.rooinaction.coursemanager.shared.CourseTypeEnum;

public class CourseProxyRenderer extends ProxyRenderer<CourseProxy> {

    private static org.rooinaction.coursemanager.client.managed.ui.CourseProxyRenderer INSTANCE;

    protected CourseProxyRenderer() {
        super(new String[] { "name" });
    }

    public static org.rooinaction.coursemanager.client.managed.ui.CourseProxyRenderer instance() {
        if (INSTANCE == null) {
            INSTANCE = new CourseProxyRenderer();
        }
        return INSTANCE;
    }

    public String render(CourseProxy object) {
        if (object == null) {
            return "";
        }
        return object.getName() + " (" + object.getName() + ")";
    }
}
