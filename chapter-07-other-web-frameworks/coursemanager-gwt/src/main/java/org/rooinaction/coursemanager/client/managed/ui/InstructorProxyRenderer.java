package org.rooinaction.coursemanager.client.managed.ui;

import com.google.web.bindery.requestfactory.gwt.ui.client.ProxyRenderer;
import org.rooinaction.coursemanager.proxy.InstructorProxy;

public class InstructorProxyRenderer extends ProxyRenderer<InstructorProxy> {

    private static org.rooinaction.coursemanager.client.managed.ui.InstructorProxyRenderer INSTANCE;

    protected InstructorProxyRenderer() {
        super(new String[] { "fullName" });
    }

    public static org.rooinaction.coursemanager.client.managed.ui.InstructorProxyRenderer instance() {
        if (INSTANCE == null) {
            INSTANCE = new InstructorProxyRenderer();
        }
        return INSTANCE;
    }

    public String render(InstructorProxy object) {
        if (object == null) {
            return "";
        }
        return object.getLastName() + " (" + object.getLastName() + ")";
    }
}
