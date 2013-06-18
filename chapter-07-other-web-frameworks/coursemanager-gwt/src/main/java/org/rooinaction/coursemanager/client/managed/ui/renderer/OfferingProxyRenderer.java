package org.rooinaction.coursemanager.client.managed.ui.renderer;
import com.google.web.bindery.requestfactory.gwt.ui.client.ProxyRenderer;
import org.rooinaction.coursemanager.web.proxy.OfferingProxy;

public class OfferingProxyRenderer extends ProxyRenderer<OfferingProxy> {

    private static OfferingProxyRenderer INSTANCE;

    protected OfferingProxyRenderer() {
        super(new String[] { "id" });
    }

    public static OfferingProxyRenderer instance() {
        if (INSTANCE == null) {
            INSTANCE = new OfferingProxyRenderer();
        }
        return INSTANCE;
    }

    public String render(OfferingProxy object) {
        if (object == null) {
            return "";
        }
        return object.getId() + " (" + object.getId() + ")";
    }
}
