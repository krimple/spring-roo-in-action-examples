package org.rooinaction.coursemanager.client.managed.ui;

import com.google.web.bindery.requestfactory.gwt.ui.client.ProxyRenderer;
import org.rooinaction.coursemanager.proxy.TagProxy;

public class TagProxyRenderer extends ProxyRenderer<TagProxy> {

    private static org.rooinaction.coursemanager.client.managed.ui.TagProxyRenderer INSTANCE;

    protected TagProxyRenderer() {
        super(new String[] { "tag" });
    }

    public static org.rooinaction.coursemanager.client.managed.ui.TagProxyRenderer instance() {
        if (INSTANCE == null) {
            INSTANCE = new TagProxyRenderer();
        }
        return INSTANCE;
    }

    public String render(TagProxy object) {
        if (object == null) {
            return "";
        }
        return object.getTag() + " (" + object.getTag() + ")";
    }
}
