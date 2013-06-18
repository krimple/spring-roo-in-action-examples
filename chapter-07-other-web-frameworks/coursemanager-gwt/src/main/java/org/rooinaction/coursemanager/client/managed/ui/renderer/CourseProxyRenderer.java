package org.rooinaction.coursemanager.client.managed.ui.renderer;
import com.google.web.bindery.requestfactory.gwt.ui.client.ProxyRenderer;
import org.rooinaction.coursemanager.web.proxy.CourseProxy;

public class CourseProxyRenderer extends ProxyRenderer<CourseProxy> {

    private static CourseProxyRenderer INSTANCE;

    protected CourseProxyRenderer() {
        super(new String[] { "name" });
    }

    public static CourseProxyRenderer instance() {
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
