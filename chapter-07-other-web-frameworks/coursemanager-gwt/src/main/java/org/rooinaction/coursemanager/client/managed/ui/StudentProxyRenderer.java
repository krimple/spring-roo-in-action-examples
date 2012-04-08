package org.rooinaction.coursemanager.client.managed.ui;

import com.google.web.bindery.requestfactory.gwt.ui.client.ProxyRenderer;
import org.rooinaction.coursemanager.proxy.StudentProxy;

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
        return object.getLastName() + " (" + object.getLastName() + ")";
    }
}
