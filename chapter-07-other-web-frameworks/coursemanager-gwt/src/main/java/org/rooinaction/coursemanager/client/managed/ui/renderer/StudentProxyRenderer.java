package org.rooinaction.coursemanager.client.managed.ui.renderer;
import com.google.web.bindery.requestfactory.gwt.ui.client.ProxyRenderer;
import org.rooinaction.coursemanager.web.proxy.StudentProxy;

public class StudentProxyRenderer extends ProxyRenderer<StudentProxy> {

    private static StudentProxyRenderer INSTANCE;

    protected StudentProxyRenderer() {
        super(new String[] { "fullName" });
    }

    public static StudentProxyRenderer instance() {
        if (INSTANCE == null) {
            INSTANCE = new StudentProxyRenderer();
        }
        return INSTANCE;
    }

    public String render(StudentProxy object) {
        if (object == null) {
            return "";
        }
        return object.getFullName() + " (" + object.getFullName() + ")";
    }
}
