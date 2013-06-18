package org.rooinaction.coursemanager.client.managed.ui.renderer;
import com.google.web.bindery.requestfactory.gwt.ui.client.ProxyRenderer;
import org.rooinaction.coursemanager.web.proxy.InstructorProxy;

public class InstructorProxyRenderer extends ProxyRenderer<InstructorProxy> {

    private static InstructorProxyRenderer INSTANCE;

    protected InstructorProxyRenderer() {
        super(new String[] { "fullName" });
    }

    public static InstructorProxyRenderer instance() {
        if (INSTANCE == null) {
            INSTANCE = new InstructorProxyRenderer();
        }
        return INSTANCE;
    }

    public String render(InstructorProxy object) {
        if (object == null) {
            return "";
        }
        return object.getFullName() + " (" + object.getFullName() + ")";
    }
}
