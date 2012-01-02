package org.rooinaction.coursemanager.client.managed.ui;

import com.google.web.bindery.requestfactory.gwt.ui.client.ProxyRenderer;
import java.util.Set;
import org.rooinaction.coursemanager.web.gwt.proxies.RegistrationProxy;
import org.rooinaction.coursemanager.web.gwt.proxies.StudentProxy;

public class StudentProxyRenderer extends ProxyRenderer<StudentProxy> {

    private static org.rooinaction.coursemanager.client.managed.ui.StudentProxyRenderer INSTANCE;

    protected StudentProxyRenderer() {
        super(new String[] { "fullName" });
    }

    public static org.rooinaction.coursemanager.client.managed.ui.StudentProxyRenderer instance() {
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
