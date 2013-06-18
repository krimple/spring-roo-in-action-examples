package org.rooinaction.coursemanager.client.managed.ui.renderer;
import com.google.web.bindery.requestfactory.gwt.ui.client.ProxyRenderer;
import org.rooinaction.coursemanager.web.proxy.RegistrationProxy;

public class RegistrationProxyRenderer extends ProxyRenderer<RegistrationProxy> {

    private static RegistrationProxyRenderer INSTANCE;

    protected RegistrationProxyRenderer() {
        super(new String[] { "id" });
    }

    public static RegistrationProxyRenderer instance() {
        if (INSTANCE == null) {
            INSTANCE = new RegistrationProxyRenderer();
        }
        return INSTANCE;
    }

    public String render(RegistrationProxy object) {
        if (object == null) {
            return "";
        }
        return object.getId() + " (" + object.getId() + ")";
    }
}
