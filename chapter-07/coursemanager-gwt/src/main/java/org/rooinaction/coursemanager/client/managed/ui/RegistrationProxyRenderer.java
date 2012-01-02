package org.rooinaction.coursemanager.client.managed.ui;

import com.google.web.bindery.requestfactory.gwt.ui.client.ProxyRenderer;
import org.rooinaction.coursemanager.web.gwt.proxies.OfferingProxy;
import org.rooinaction.coursemanager.web.gwt.proxies.RegistrationProxy;
import org.rooinaction.coursemanager.web.gwt.proxies.StudentProxy;

public class RegistrationProxyRenderer extends ProxyRenderer<RegistrationProxy> {

    private static org.rooinaction.coursemanager.client.managed.ui.RegistrationProxyRenderer INSTANCE;

    protected RegistrationProxyRenderer() {
        super(new String[] { "id" });
    }

    public static org.rooinaction.coursemanager.client.managed.ui.RegistrationProxyRenderer instance() {
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
